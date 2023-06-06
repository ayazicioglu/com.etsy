package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverWeb {
    private DriverWeb(){

    }

    public static WebDriver driverWeb;
    static ChromeOptions ops = new ChromeOptions();
    public static WebDriver getDriver(){
        String istenenBrowser=ConfigReader.getProperty("browser");

        if (driverWeb==null){
            switch (istenenBrowser){

                case "chrome":
                    ops.addArguments("--remote-allow-origins=*");
                    WebDriverManager.chromedriver().setup();
                    driverWeb = new ChromeDriver(ops);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverWeb=new FirefoxDriver();
                    break;
                case  "edge":
                    WebDriverManager.edgedriver().setup();
                    driverWeb=new EdgeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driverWeb=new SafariDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driverWeb=new ChromeDriver();


            }
            driverWeb.manage().window().maximize();
            driverWeb.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }


        return driverWeb;
    }

    public static void closeDriver(){
        if (driverWeb!=null){
            driverWeb.close();
            driverWeb=null;
        }
    }
    public static void quitDriver(){
        if (driverWeb!=null){
            driverWeb.quit();
            driverWeb=null;
        }
    }
}