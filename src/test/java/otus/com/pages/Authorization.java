package otus.com.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Authorization extends BasePage {

    public Authorization(WebDriver driver) {
        super(driver);
    }
    private final String OTUS_URL = "https://otus.ru";
    private By buttonLogin = By.xpath("//button[@class=\"header2__auth js-open-modal\"]");
    private By inputEmail = By.xpath("(//input[@placeholder=\"Электронная почта\"])[3]");
    private By inputPass = By.xpath("//input[@type=\"password\"]");
    private By buttonEntry = By.xpath("(//button[@type=\"submit\"])[3]");
    private By buttonMyСourse = By.xpath("(//a[@href=\"/learning/\"])[1]");

    public void openOtus() {
        driver.get(OTUS_URL);
        logger.info("Сайт открыт");
        wait.until(ExpectedConditions.elementToBeClickable(buttonLogin));
    }

    public void auth(String login, String password) {
        driver.findElement(buttonLogin).click();
        wait.until(ExpectedConditions.elementToBeClickable(inputEmail));
        driver.findElement(inputEmail).sendKeys(login);
        driver.findElement(inputPass).sendKeys(password);
        driver.findElement(buttonEntry).click();
        logger.info("Авторизация прошла");
        wait.until(ExpectedConditions.elementToBeClickable(buttonMyСourse));
    }
}
