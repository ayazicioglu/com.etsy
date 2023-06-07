package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverWeb;

public class EtsyPageWeb {

    public EtsyPageWeb() {
        PageFactory.initElements((WebDriver) DriverWeb.getDriver(),this);
    }

    @FindBy (xpath = "//input[@id='global-enhancements-search-query']")
    public WebElement aramaKutusu;

    @FindBy(xpath = "(//span[@class='wt-vertical-align-middle'])[1]")
    public WebElement firstAddToCartButton;

    @FindBy(xpath = "//select[@class='wt-select__element']")
    public WebElement firstDDM;

    @FindBy(xpath = "//select[@id='variation-selector-1']")
    public WebElement secondDDM;

    @FindBy(xpath = "(//button[@type='button'])[16]")
    public WebElement saveButton;

    @FindBy(xpath = "(//span[@class='submit-button-text'])")
    public WebElement checkOutButton;

    @FindBy(xpath = "(//button[@type='button'])[16]")
    public WebElement addToCartButon;

    @FindBy(xpath = "(//a[@class='wt-btn wt-width-full wt-btn--primary'])[1]")
    public WebElement viewCartCheckOut;

    @FindBy(xpath = "(//span[@class='submit-button-text'])")
    public WebElement proceedToCheckoutButton;

    @FindBy(xpath = "(//button[@class='wt-btn wt-btn--secondary wt-width-full'])[1]")
    public WebElement continueAsAGuestButton;

    @FindBy(xpath = "//button[@class='wt-btn wt-btn--transparent wt-btn--small wt-width-full']")
    public WebElement continueAsAGuestOption;

    @FindBy(xpath = "(//input[@id='shipping-form-email-input'])[1]")
    public WebElement eMailBox;

    @FindBy(xpath = "(//input[@id='join_neu_password_field'])")
    public WebElement passwordBox;

    @FindBy(xpath = "(//button[@class='wt-btn wt-btn--primary wt-width-full'])")
    public WebElement registerAndContinueButton;

    @FindBy(xpath = "(//button[@class='select_btn wt-btn wt-btn--filled wt-width-full'])[1]")
    public WebElement shipHereButton;

    @FindBy(xpath = "(//label[@class='wt-width-full'])[1]")
    public WebElement cardOptionButton;

    @FindBy(xpath = "(//div[@class='wt-radio'])[2]")
    public WebElement cardOption;

    @FindBy(xpath = "(//div[@class='wt-radio wt-mb-xs-2 wt-mb-lg-1'])[1]")
    public WebElement cardOptionOnPage;

    @FindBy(xpath = "(//input[@id='cc-name--paymentstep'])[1]")
    public WebElement creditCardNameBox;

    @FindBy(xpath = "(//button[@class='wt-btn wt-btn--filled wt-width-full'])[4]")
    public WebElement reviewOrderButton;

    @FindBy(xpath = "//textarea[@class='wt-textarea wt-textarea']")
    public WebElement personalizationBox;

    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
        }
    }
    public static void clickWithJS(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public static void scrollToBottom(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

}
