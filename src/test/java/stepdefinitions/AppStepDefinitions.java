package stepdefinitions;

import com.github.javafaker.Faker;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.appmanagement.BaseActivateApplicationOptions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.EtsyPageMobile;
import utilities.DriverApp;

import java.net.MalformedURLException;
import java.util.Map;

public class AppStepDefinitions {
    EtsyPageMobile etsyPageMobile = new EtsyPageMobile();
    Faker faker = new Faker();
    private static AndroidDriver<AndroidElement> appiumDriver = DriverApp.getAndroidDriver();

    @Given("etsy app opens on phone")
    public void etsyAppOpensOnPhone() throws MalformedURLException {
        appiumDriver.activateApp("com.etsy.android");
        EtsyPageMobile.bekle(5);
    }

    @Then("Choose Continue as guest option")
    public void chooseContinueAsGuestOption() {
        etsyPageMobile.asAGuestOption.click();
    }

    @Then("Choose Maybe Later option")
    public void chooseMaybeLaterOption() {
        etsyPageMobile.maybeButton.click();
    }

    @Then("Click the searchbox and type {string} then search")
    public void clickTheSearchboxAndTypeThenSearch(String aranacakUrun) {
        EtsyPageMobile.koordinataTikla(305, 172);
        EtsyPageMobile.koordinataTikla(305, 172);
        EtsyPageMobile.bekle(4);
        appiumDriver.getKeyboard().sendKeys(aranacakUrun);
        EtsyPageMobile.bekle(2);
        EtsyPageMobile.koordinataTikla(990, 1999);
    }

    @And("Choose the first product from the results")
    public void chooseTheFirstProductFromTheResults() {
        EtsyPageMobile.bekle(3);
        etsyPageMobile.firstProductInResults.click();
        EtsyPageMobile.bekle(2);
    }

    @And("Add to cart after selects size from the edit item section")
    public void selectsSizeAndColorFromTheEditItemSection() {
        etsyPageMobile.selectOptionDDM.click();
        etsyPageMobile.anOption.click();
        EtsyPageMobile.birNoktadanDigerineSurukle(506, 1837, 513, 1180);
        try {
            etsyPageMobile.selectOptionDDM2.click();
            etsyPageMobile.anotherOption.click();
        } catch (Exception e) {

        }

        etsyPageMobile.addToCartButon.click();
        EtsyPageMobile.bekle(2);
        try {
            EtsyPageMobile.koordinataTikla(237, 1091);
            appiumDriver.getKeyboard().sendKeys(faker.pokemon().name());
            etsyPageMobile.addToCartButon.click();
        } catch (Exception e) {
        }
        etsyPageMobile.ViewInYourCart.click();
    }

    @Then("Makes payment from the proceed to checkout section")
    public void makesPaymentFromTheProceedToCheckoutSection() {
        EtsyPageMobile.birNoktadanDigerineSurukle(506, 1837, 513, 1180);
        etsyPageMobile.proceedToCheckoutButton.click();
        String email = faker.internet().emailAddress();
        EtsyPageMobile.koordinataTikla(129, 524);
        appiumDriver.getKeyboard().sendKeys(email);
        etsyPageMobile.continueButton.click();
        EtsyPageMobile.bekle(2);

        etsyPageMobile.fullNameBox.click();
        etsyPageMobile.firstNameBox.sendKeys(faker.name().firstName());
        EtsyPageMobile.bekle(2);

        etsyPageMobile.passwordBox.click();
        EtsyPageMobile.bekle(2);

        appiumDriver.getKeyboard().sendKeys("kl23...");
        EtsyPageMobile.bekle(2);

        etsyPageMobile.registerButton.click();
        EtsyPageMobile.bekle(3);

        etsyPageMobile.notificationDenyOption.click();
        EtsyPageMobile.bekle(3);
    }

    @And("Finish the order")
    public void finishTheOrder() {
        etsyPageMobile.fullNameBox.click();
        etsyPageMobile.fullNameBox.sendKeys(faker.name().fullName());
        EtsyPageMobile.bekle(2);

        etsyPageMobile.streetAdressBox.click();
        etsyPageMobile.streetAdressBox.sendKeys(faker.address().streetAddress());
        EtsyPageMobile.bekle(2);

        etsyPageMobile.aptBox.sendKeys("YaSabırAPT...");
        EtsyPageMobile.bekle(2);
        EtsyPageMobile.klavyeyiKapat();

        etsyPageMobile.zipCodeBox.click();
        etsyPageMobile.zipCodeBox.sendKeys("80202");
        EtsyPageMobile.bekle(2);

        etsyPageMobile.cityBox.click();
        etsyPageMobile.cityBox.sendKeys("Denver");
        EtsyPageMobile.bekle(2);
        EtsyPageMobile.klavyeyiKapat();

        etsyPageMobile.selectState.click();
        EtsyPageMobile.bekle(3);
        EtsyPageMobile.koordinataTikla(301, 1500);
        EtsyPageMobile.bekle(3);
        EtsyPageMobile.birNoktadanDigerineSurukle(506, 1837, 513, 1180);
        try {
            EtsyPageMobile.koordinataTikla(477, 2110);
        } catch (Exception e) {
            etsyPageMobile.continuePaymentButton.click();
        }

        EtsyPageMobile.bekle(5);
        EtsyPageMobile.koordinataTikla(65, 642);
        EtsyPageMobile.bekle(3);

        EtsyPageMobile.koordinataTikla(606, 1030);
        EtsyPageMobile.bekle(2);
        appiumDriver.getKeyboard().sendKeys(faker.name().fullName());
        EtsyPageMobile.bekle(3);

        EtsyPageMobile.koordinataTikla(423, 1292);
        appiumDriver.getKeyboard().sendKeys(faker.business().creditCardNumber());
        EtsyPageMobile.bekle(3);
        EtsyPageMobile.klavyeyiKapat();

        EtsyPageMobile.koordinataTikla(118, 1543);
        EtsyPageMobile.bekle(2);
        EtsyPageMobile.koordinataTikla(118, 1543);
        EtsyPageMobile.bekle(3);
        EtsyPageMobile.koordinataTikla(843, 1543);
        EtsyPageMobile.bekle(3);
        appiumDriver.getKeyboard().sendKeys("101");
        EtsyPageMobile.birNoktadanDigerineSurukle(506, 1837, 513, 1180);

    }
}
