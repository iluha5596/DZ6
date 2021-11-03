package otus.com.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SectionYourself extends BasePage {

    public SectionYourself(WebDriver driver) {
        super(driver);
    }
    private final String SECTION_YOURSELF = "https://otus.ru/lk/biography/personal/";
    private By buttonSave = By.xpath("//button[@title=\"Сохранить и продолжить\"]");

    public void openSectionYourself() {
        driver.get(SECTION_YOURSELF);
        logger.info("Раздел о себе открыт");
        wait.until(ExpectedConditions.elementToBeClickable(buttonSave));
    }


}
