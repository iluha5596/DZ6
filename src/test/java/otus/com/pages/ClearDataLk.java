package otus.com.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ClearDataLk extends BasePage {

    public ClearDataLk(WebDriver driver) {
        super(driver);
    }
    private By inputFullDay = By.xpath("//input[@title=\"Полный день\"]//..");
    private By buttonDelete2 = By.xpath("(//button[text() = \"Удалить\"])[2]");
    private By buttonDelete4 = By.xpath("(//button[text() = \"Удалить\"])[4]");
    private By selectGender = By.xpath("//select[@name=\"gender\"]");
    private By option = By.xpath("//option[@value]");
    private By buttonSave = By.xpath("//button[@title=\"Сохранить и продолжить\"]");

    public void clear() {
        driver.findElement(inputFullDay).click();
        driver.findElement(buttonDelete2).click();
        driver.findElement(buttonDelete4).click();
        driver.findElement(selectGender).click();
        driver.findElement(option).click();
        driver.findElement(buttonSave).click();
        logger.info("Данные очищены");
    }


}

