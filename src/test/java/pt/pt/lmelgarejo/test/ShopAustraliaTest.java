package pt.pt.lmelgarejo.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.pt.lmelgarejo.core.BaseTest;
import pt.pt.lmelgarejo.page.ShopAustraliaPage;

import static pt.pt.lmelgarejo.core.DriverFactory.getDriver;

public class ShopAustraliaTest extends BaseTest {

    private ShopAustraliaPage shopAustraliaPage;


    @BeforeEach
    public void setup(){
        getDriver().manage().window().maximize();
        getDriver().get("https://shop.mercedes-benz.com/en-au/shop/vehicle/srp/demo");
        shopAustraliaPage = new ShopAustraliaPage();
    }

    @Test
    public void shouldSelectYourState() throws InterruptedException {
        shopAustraliaPage.acceptCookies();
        shopAustraliaPage.selectYourState();
        shopAustraliaPage.insertYourPostalCode();
        shopAustraliaPage.selectYourPurpose();
        shopAustraliaPage.confirmYourLocation();
        shopAustraliaPage.clickSearchOptions();
        shopAustraliaPage.selectPreOwned();
        shopAustraliaPage.selectColoursOption();
        shopAustraliaPage.sortResultAsPriceDescendending();
        shopAustraliaPage.selectExpensiveCar();
        shopAustraliaPage.collectCarData();
        shopAustraliaPage.confirmEnquire();
        shopAustraliaPage.fillForm();
        shopAustraliaPage.confirmeFormOptions();
        String invalidEmailErrorMessage = shopAustraliaPage.getInvalidadEmailErrorMessage();
        String submitFormErrorMessage = shopAustraliaPage.getSubmitFormErrorMessage();
        Assertions.assertEquals("Please enter a valid email address using a minimum of six characters.", invalidEmailErrorMessage);
        Assertions.assertTrue(submitFormErrorMessage.contains("An error has occurred."));
    }
}
