package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverApp;

import java.time.Duration;

public class EtsyPageMobile {
    public EtsyPageMobile(){
        PageFactory.initElements(new AppiumFieldDecorator(DriverApp.getAndroidDriver(), Duration.ofSeconds(15)), this);
    }
    static AndroidDriver<AndroidElement> driver=DriverApp.getAndroidDriver();
    static TouchAction action = new TouchAction<>(driver);
    @FindBy(xpath = "//*[@text='Continue as guest']")
    public WebElement asAGuestOption;

    @FindBy(xpath = "//*[@text='Maybe later']")
    public WebElement maybeButton;

    @FindBy(xpath = "(//*[@class='android.view.ViewGroup'])[6]")
    public WebElement firstProductInResults;

    @FindBy(xpath = "(//*[@text='Select an option'])[1]")
    public WebElement selectOptionDDM;

    @FindBy(xpath = "(//*[@text='Select an option'])[1]")
    public WebElement selectOptionDDM2;

    @FindBy(xpath = "(//*[@class='android.view.ViewGroup'])[3]")
    public WebElement anOption;

    @FindBy(xpath = "(//*[@resource-id='join_neu_first_name_field'])[1]")
    public WebElement firstNameBox;

    @FindBy(xpath = "(//*[@resource-id='join_neu_password_field'])[1]")
    public WebElement passwordBox;

    @FindBy(xpath = "(//*[@class='android.view.ViewGroup'])[2]")
    public WebElement anotherOption;

    @FindBy(xpath = "(//*[@text='Add to cart'])")
    public WebElement addToCartButon;

    @FindBy(xpath = "(//*[@text='View in your cart'])")
    public WebElement ViewInYourCart;

    @FindBy(xpath = "(//*[@text='Proceed to checkout'])")
    public WebElement proceedToCheckoutButton;

    @FindBy(xpath = "(//*[@text='Continue'])")
    public WebElement continueButton;

    @FindBy(xpath = "(//*[@text='Continue to payment'])")
    public WebElement continuePaymentButton;

    @FindBy(xpath = "(//*[@text='Register'])")
    public WebElement registerButton;

    @FindBy(xpath = "(//*[@text='Don’t allow'])")
    public WebElement notificationDenyOption;

    public static void koordinataTikla(int xKoordinat, int yKoordinat) {
        action.press(PointOption.point(xKoordinat, yKoordinat)).release().perform();
    }
    public static void birNoktadanDigerineSurukle(int x1, int y1, int x2, int y2) {
        action.press(PointOption.point(x1, y1)).
                waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).
                moveTo(PointOption.point(x2, y2)).
                release().perform();
    }
    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
        }
    }

}
