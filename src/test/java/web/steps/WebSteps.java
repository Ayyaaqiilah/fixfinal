package web.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import web.pages.LoginPage;
import web.pages.ProductsPage;
import web.utils.WebDriverFactory;

import static org.junit.Assert.*;

public class WebSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;

    private boolean isHeadless() {
        String env = System.getenv("CI_HEADLESS");
        return env != null && env.equalsIgnoreCase("true");
    }

    @Before
    public void setup() {
        driver = WebDriverFactory.createChrome(isHeadless());
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @After
    public void teardown() {
        if (driver != null) driver.quit();
    }

    @Given("I open Saucedemo login page")
    public void openLoginPage() {
        loginPage.open();
    }

    @When("I login with username {string} and password {string}")
    public void login(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("I should see the products page")
    public void verifyProductsPage() {
        assertTrue(loginPage.isOnProductsPage());
    }

    @Then("I should see an error message")
    public void verifyErrorMessage() {
        assertTrue(loginPage.isErrorDisplayed());
    }

    // End-to-end steps
    @Given("I login with valid credentials for E2E")
    public void loginForE2E() {
        loginPage.open();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }

    @When("I add first product to cart")
    public void addFirstProductToCart() {
        productsPage.addFirstProductToCart();
    }

    @When("I proceed to checkout")
    public void proceedToCheckout() {
        productsPage.checkout();
    }

    @Then("I should see order confirmation page")
    public void verifyOrderConfirmation() {
        assertTrue(productsPage.isOrderConfirmed());
    }
}
