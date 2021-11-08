package otus.com;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import otus.com.WBFactory.Browsers;
import otus.com.WBFactory.WebDriverFactory;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.logging.Logger;

public class BaseTest {
    protected org.apache.logging.log4j.Logger logger = LogManager.getLogger(Logger.class);
    protected WebDriver driver;
    protected WebDriverWait wait;
    private String br;
    @BeforeClass
    public void startUp() {
        br = System.getProperty("browser").toUpperCase(Locale.ROOT).trim();
        driver = WebDriverFactory.getDriver(Browsers.valueOf(br));
        logger.info("Драйвер поднят");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);

    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) +  ".jpg"));
        }
    }

    @AfterClass
    public void end(){
        if (driver!=null)
            driver.quit();
    }
}
