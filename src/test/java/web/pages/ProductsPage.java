package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver driver;
    private By firstProduct = By.cssSelector(".inventory_item:first-child button");
    private By cartButton = By.id("shopping_cart_container");
    private By checkoutButton = By.id("checkout");
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By zipField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addFirstProductToCart() {
        driver.findElement(firstProduct).click();
    }

    public void checkout() {
        driver.findElement(cartButton).click();     // buka cart
        driver.findElement(checkoutButton).click(); // klik checkout

        // isi form checkout info
        driver.findElement(firstNameField).sendKeys("John");
        driver.findElement(lastNameField).sendKeys("Doe");
        driver.findElement(zipField).sendKeys("12345");
        driver.findElement(continueButton).click(); // lanjut ke overview
        driver.findElement(finishButton).click();   // klik finish
    }

    public boolean isOrderConfirmed() {
        return driver.getCurrentUrl().contains("checkout-complete.html");
    }
}
