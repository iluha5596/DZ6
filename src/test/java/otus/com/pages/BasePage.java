package otus.com.pages;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected org.apache.logging.log4j.Logger logger;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        logger = LogManager.getLogger(Logger.class);

    }
}
