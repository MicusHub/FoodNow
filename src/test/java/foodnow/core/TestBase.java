package foodnow.core;

import com.foodnow.core.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();
    private Logger logger = LoggerFactory.getLogger(TestBase.class); // Инициализация логгера

    public Logger getLogger() { // добавили getter для logger
        return logger;
    }

    @BeforeSuite
    public void start() {
        getLogger().info("*** TESTING IN PROGRESS ***");
        app.init();
    }

    @BeforeMethod
    public void startTest(Method method) {
        getLogger().info("Test " + method.getName() + " started"); // используем getter
    }

    @AfterMethod
    public void stopTest(Method method, ITestResult result) {
        if (result.isSuccess()) {
            getLogger().info("Test PASSED: " + method.getName()); // используем getter
        } else {
            getLogger().error("Test FAILED: " + method.getName() + ", Screenshot: " + app.getBaseHelper().takeScreenshot()); // используем getter
        }
    }

    @AfterSuite(enabled = true)
    public void tearDown() {
        getLogger().info("*** TESTING Ended ***"); // используем getter
        app.stop();
    }
}