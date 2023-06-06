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
    EtsyPageMobile etsyPageMobile=new EtsyPageMobile();
    Faker faker=new Faker();
    private static AndroidDriver<AndroidElement> appiumDriver=DriverApp.getAndroidDriver();

    @Given("etsy app opens on phone")
    public void etsyAppOpensOnPhone() throws MalformedURLException {
        appiumDriver.activateApp("com.etsy.android");
        EtsyPageMobile.bekle(5);
    }

    @Then("Choose Continue as guest option")
    public void chooseContinueAsGuestOption() {
      //  etsyPageMobile.asAGuestOption.click();
    }

    @Then("Choose Maybe Later option")
    public void chooseMaybeLaterOption() {
       // etsyPageMobile.maybeButton.click();
    }

    @Then("Click the searchbox and type {string} then search")
    public void clickTheSearchboxAndTypeThenSearch(String aranacakUrun) {
        EtsyPageMobile.koordinataTikla(305,172);
        EtsyPageMobile.koordinataTikla(305,172);
        EtsyPageMobile.bekle(2);
        appiumDriver.getKeyboard().sendKeys(aranacakUrun);
        EtsyPageMobile.bekle(2);
        EtsyPageMobile.koordinataTikla(990,1999);
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
        EtsyPageMobile.birNoktadanDigerineSurukle(506,1837,513,1180);
        etsyPageMobile.selectOptionDDM2.click();
        etsyPageMobile.anotherOption.click();

        etsyPageMobile.addToCartButon.click();
        EtsyPageMobile.birNoktadanDigerineSurukle(506,1837,513,1180);
        EtsyPageMobile.bekle(2);
        try {
            EtsyPageMobile.koordinataTikla(237,1091);
            appiumDriver.getKeyboard().sendKeys(faker.pokemon().name());
            etsyPageMobile.addToCartButon.click();
        } catch (Exception e) {
        }
        etsyPageMobile.ViewInYourCart.click();
    }

    @Then("Makes payment from the proceed to checkout section")
    public void makesPaymentFromTheProceedToCheckoutSection() {
        EtsyPageMobile.birNoktadanDigerineSurukle(506,1837,513,1180);
        etsyPageMobile.proceedToCheckoutButton.click();
        String email=faker.internet().emailAddress();
        EtsyPageMobile.koordinataTikla(147,513);
        appiumDriver.getKeyboard().sendKeys(email);
        etsyPageMobile.continueButton.click();
        EtsyPageMobile.koordinataTikla(258,804);
        appiumDriver.getKeyboard().sendKeys(faker.name().firstName());
        EtsyPageMobile.koordinataTikla(136,1044);
        appiumDriver.getKeyboard().sendKeys(faker.internet().password());
        etsyPageMobile.registerButton.click();
        EtsyPageMobile.bekle(3);
        etsyPageMobile.notificationDenyOption.click();
    }
}
