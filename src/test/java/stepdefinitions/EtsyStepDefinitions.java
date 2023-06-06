package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.EtsyPageWeb;
import utilities.DriverWeb;

public class EtsyStepDefinitions {
    EtsyPageWeb etsyPageWeb =new EtsyPageWeb();

    Faker faker=new Faker();

    Select select;

    Actions actions=new Actions(DriverWeb.getDriver());

    @Given("User goes to {string} web page")
    public void user_goes_to_web_page(String url) {
        DriverWeb.getDriver().get(url);
    }
    @Then("Type {string} in the search box and search")
    public void type_in_the_search_box_and_search(String urunAdi) {
        etsyPageWeb.aramaKutusu.sendKeys(urunAdi+Keys.ENTER);
    }
    @Then("Adds the first product in the search result to the cart")
    public void adds_the_first_product_in_the_search_result_to_the_cart() {
        etsyPageWeb.firstAddToCartButton.click();
    }
    @Then("Selects size and color from the Edit item section")
    public void selects_size_and_color_from_the_edit_item_section() {
     select=new Select(etsyPageWeb.sizeDDM);
     select.selectByIndex(faker.random().nextInt(1,3));
        try {
            select=new Select(etsyPageWeb.colorDDM);
            select.selectByIndex(1);
        } catch (Exception e) {
        }
        EtsyPageWeb.clickWithJS(DriverWeb.getDriver(),etsyPageWeb.saveButton);
    }
    @Then("Makes payment from the Proceed to checkout section")
    public void makes_payment_from_the_proceed_to_checkout_section() {
        etsyPageWeb.bekle(2);
        EtsyPageWeb.clickWithJS(DriverWeb.getDriver(),etsyPageWeb.checkOutButton);
        etsyPageWeb.continueAsAGuestButton.click();
        String email=faker.internet().emailAddress();
        etsyPageWeb.eMailBox.sendKeys(email);
        actions.sendKeys(Keys.TAB).sendKeys(email).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(faker.name().fullName()).sendKeys(Keys.TAB).
                sendKeys(faker.address().streetAddress()).sendKeys(Keys.TAB).
                sendKeys(faker.address().buildingNumber()).sendKeys(Keys.TAB).
                sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB).
                sendKeys(faker.address().cityName()).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        etsyPageWeb.bekle(2);
        etsyPageWeb.passwordBox.sendKeys(faker.internet().password());
        etsyPageWeb.registerAndContinueButton.click();
        EtsyPageWeb.bekle(3);
        EtsyPageWeb.clickWithJS(DriverWeb.getDriver(),etsyPageWeb.shipHereButton);
        EtsyPageWeb.clickWithJS(DriverWeb.getDriver(),etsyPageWeb.cardOptionButton);
        etsyPageWeb.creditCardNameBox.sendKeys(faker.name().fullName().toUpperCase());
        actions.sendKeys(Keys.TAB).sendKeys(faker.business().creditCardNumber()).sendKeys(Keys.TAB).
                sendKeys("9").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("193").perform();
        DriverWeb.quitDriver();
    }


}
