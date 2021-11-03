package otus.com.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FillDataLk extends BasePage {

    public FillDataLk(WebDriver driver) {
        super(driver);
    }
    private By inputName = By.xpath("//input[@data-title=\"Имя\"]");
    private By inputLastName = By.xpath("//input[@data-title=\"Фамилия\"]");
    private By inputBlogName = By.xpath("//input[@name=\"blog_name\"]");
    private By inputDateBirth = By.xpath("//input[@title=\"День рождения\"]");
    private By inputCompany = By.xpath("//input[@name=\"company\"]");
    private By inputWork = By.xpath("//input[@name=\"work\"]");
    private By labelCountry = By.cssSelector(".js-lk-cv-dependent-master > label:nth-child(1) > div:nth-child(2)");
    private By divCountry = By.xpath("(//div[@class=\"input input_full lk-cv-block__input lk-cv-block__input_fake lk-cv-block__input_select-fake js-custom-select-presentation\"])[1]");
    private By buttonCountry = By.xpath("//button[@title=\"Россия\"]");
    private By divEmpty = By.xpath("//div[@class=\"container__col container__col_9 container__col_md-12\"]");
    private By buttonCity = By.xpath("//button[@title=\"Москва\"]");
    private By inputCity = By.xpath("//input[@data-title=\"Город\"]/..//div");
    private By divLevelEnglish = By.xpath("(//div[@class=\"input input_full lk-cv-block__input lk-cv-block__input_fake lk-cv-block__input_select-fake js-custom-select-presentation\"])[3]");
    private By buttonElementary = By.xpath("//button[@title=\"Элементарный уровень (Elementary)\"]");
    private By inputFullDay = By.xpath("//input[@title=\"Полный день\"]//..");
    private By spanCommunication = By.xpath("//span[text() = \"Способ связи\"]");
    private By buttonWhatsapp = By.xpath("//button[@data-value=\"whatsapp\"]");
    private By inputNumberPhone = By.xpath("//input[@name=\"contact-0-value\"]");
    private By buttonAdd = By.xpath("//button[text() = \"Добавить\"]");
    private By buttonTelegram = By.xpath("(//button[@data-value=\"telegram\"])[2]");
    private By inputNumberPhone1 = By.xpath("//input[@name=\"contact-1-value\"]");
    private By selectGender = By.xpath("//select[@name=\"gender\"]");
    private By optionMen = By.xpath("//option[@value=\"m\"]");
    private By buttonSave = By.xpath("//button[@title=\"Сохранить и продолжить\"]");

    public void dataLk() {
        //Очистка данных
        driver.findElement(inputName).clear();
        driver.findElement(inputLastName).clear();
        driver.findElement(inputBlogName).clear();
        driver.findElement(inputDateBirth).clear();
        driver.findElement(inputCompany).clear();
        driver.findElement(inputWork).clear();
        //Заполнение данных
        driver.findElement(inputName).sendKeys("Илья");
        driver.findElement(inputLastName).sendKeys("Пантиков");
        driver.findElement(inputBlogName).sendKeys("Ilya");
        driver.findElement(inputDateBirth).sendKeys("05.07.1996");
        //Страна
        if(!driver.findElement(labelCountry).getText().contains("Россия")) {
            driver.findElement(divEmpty).click();
            driver.findElement(divCountry).click();
            driver.findElement(buttonCountry).click();
        }
        //Город
        if(!driver.findElement(buttonCity).getText().contains("Москва")){
            driver.findElement(divEmpty).click();
            driver.findElement(inputCity).click();
            driver.findElement(buttonCity).click();
        }
        //Уровень английского
        driver.findElement(divLevelEnglish).click();
        driver.findElement(buttonElementary).click();
        //Форма работы
        driver.findElement(inputFullDay).click();
        //Контактная информация
        driver.findElement(spanCommunication).click();
        driver.findElement(buttonWhatsapp).click();
        driver.findElement(inputNumberPhone).sendKeys("+79999999999");
        driver.findElement(buttonAdd).click();
        driver.findElement(spanCommunication).click();
        driver.findElement(buttonTelegram).click();
        driver.findElement(inputNumberPhone1).sendKeys("+79999999999");
        //Пол
        driver.findElement(selectGender).click();
        driver.findElement(optionMen).click();
        //Место работы
        driver.findElement(inputCompany).sendKeys("ПАО Абсолют банк");
        //Должность
        driver.findElement(inputWork).sendKeys("QA Engineer");
        //Сохранение данных
        driver.findElement(buttonSave).click();
        logger.info("Данные заполнены");
    }
}
