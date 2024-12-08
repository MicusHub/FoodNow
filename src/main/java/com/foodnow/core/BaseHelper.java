package com.foodnow.core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

public class BaseHelper {
    Logger logger = LoggerFactory.getLogger(BaseHelper.class);
    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor js;


    public BaseHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    protected void click(WebElement element) {
        element.click();
        logger.info("[" + element + "] is pressed");
    }

    protected void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
            logger.info("Typed text '" + text + "' into element: " + element);
        }
    }


    protected boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }


    protected boolean isAlertPresent() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            logger.warn("Alert present: " + alert.getText());
            alert.accept();
            return true;
        } catch (TimeoutException e) {
            logger.info("Alert is not present");
            return false;
        }
    }

    protected void scrollTo(int y) {
        js.executeScript("window.scrollBy(0," + y + ")");
    }

    public String takeScreenshot() {
        File screenshot = new File("src/test_screenshots/screen-" + System.currentTimeMillis() + ".png");
        try {
            File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(tmp.toPath(), screenshot.toPath());
        } catch (IOException e) {
            logger.error("Failed to save screenshot", e);
            throw new RuntimeException(e);
        }
        return screenshot.getAbsolutePath();
    }
}
