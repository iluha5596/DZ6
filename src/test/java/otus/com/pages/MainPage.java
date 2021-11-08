package otus.com.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }
    private By buttonSave = By.xpath("//button[@title=\"Сохранить и продолжить\"]");
    private By divMenuIcon = By.xpath("//div[@class=\"header2-menu__icon-img ic-blog-default-avatar\"]");
    private By aLk = By.xpath("//a[@title=\"Личный кабинет\"]");
    private By aAboutMe = By.xpath("(//a[@title=\"О себе\"])[1]");

    public void openSectionYourself() {
        driver.findElement(divMenuIcon).click();
        driver.findElement(aLk).click();
        wait.until(ExpectedConditions.elementToBeClickable(aAboutMe));
        driver.findElement(aAboutMe).click();
        logger.info("Раздел о себе открыт");
        wait.until(ExpectedConditions.elementToBeClickable(buttonSave));
    }

}
