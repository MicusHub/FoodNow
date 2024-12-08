package com.foodnow.pages;

import com.foodnow.core.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BaseHelper {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openHomePage() { // return HomePage
        driver.get("https://oyster-app-hck73.ondigitalocean.app/#/");
        return this;
    }

    @FindBy(xpath = "//a[@href='#/user-profile']")
    WebElement login;

    public HomePage clickOnIconAuthorization() {
        click(login);
        return this;
    }


    public void quitBrowser() {
        driver.quit();
    }

    @FindBy(xpath = "(//div[@class='css-1lr0q67']/following-sibling::div)[3]")
    WebElement homePageTitle;

    public HomePage verifyTitleHomePage() {
        wait.until(ExpectedConditions.visibilityOf(homePageTitle)); // Using wait from BaseHelper
        return this;
    }

    @FindBy(xpath = "(//img[@class='css-rbpvgo'])[1]")
    WebElement imageFoodNow;

    public HomePage clickOnImageFoodNow() {
        click(imageFoodNow);
        return this;
    }

    public HomePage scrollPageProducts() {
        scrollTo(700);
        return this;
    }


    public HomePage clickOnProduct(String product) {
        // Find element dynamically each time
        click(driver.findElement(By.xpath("//button[text()='" + product + "']")));
        driver.navigate().refresh(); // Consider removing this unless absolutely necessary
        return this;
    }

    @FindBy(xpath = "//button[text()='Seafood']")
    WebElement categoriesSeafood;

    public HomePage clickOnCategoriesSeafood() {
        click(categoriesSeafood);
        return this;
    }

    @FindBy(xpath = "(//div[@class='MuiStack-root css-jj2ztu']//button)[1]")
    WebElement buttonAddToCart;

    public HomePage clickOnButtonAddToCart() {
        click(buttonAddToCart);
        return this;
    }

    @FindBy(xpath = "(//img[@class='css-13s0wde'])[2]")
    WebElement cartIcon;

    public HomePage clickOnCart() {
        click(cartIcon);
        return this;
    }
}
