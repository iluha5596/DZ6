package otus.com.pages;
import cofig.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import otus.com.dto.UserDto;

public class Lk extends BasePage {

    private User userDto;
    public Lk(WebDriver driver, User userDto) {
        super(driver);
        this.userDto = userDto;
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
    private By inputNumberPhone1 = By.xpath("//input[@name=\"contact-0-value\"]");
    private By buttonAdd = By.xpath("//button[text() = \"Добавить\"]");
    private By buttonTelegram = By.xpath("(//button[@data-value=\"telegram\"])[2]");
    private By inputNumberPhone2 = By.xpath("//input[@name=\"contact-1-value\"]");
    private By selectGender = By.xpath("//select[@name=\"gender\"]");
    private By optionMen = By.xpath("//option[@value=\"m\"]");
    private By buttonSave = By.xpath("//button[@title=\"Сохранить и продолжить\"]");
    private By GenderNoSpecified  = By.xpath("//option[@value]");
    private By buttonDeleteContactInfo2 = By.xpath("(//button[text() = \"Удалить\"])[2]");
    private By buttonDeleteContactInfo4 = By.xpath("(//button[text() = \"Удалить\"])[4]");
    private By inputEmail = By.xpath("(//input[@name=\"email\"])[1]");
    private By divTelegram = By.xpath("(//div[@class=\"input input_full lk-cv-block__input input_straight-bottom-right input_straight-top-right input_no-border-right lk-cv-block__input_fake lk-cv-block__input_select-fake js-custom-select-presentation\"])[1]");
    private By divWhatsApp = By.xpath("(//div[@class=\"input input_full lk-cv-block__input input_straight-bottom-right input_straight-top-right input_no-border-right lk-cv-block__input_fake lk-cv-block__input_select-fake js-custom-select-presentation\"])[2]");
    private By inputCompanyName = By.xpath("//input[@id=\"id_company\"]");
    private By inputWorkName = By.xpath("//input[@id=\"id_work\"]");
    private By inputEnglishLevel = By.xpath("//input[@data-title=\"Уровень знания английского языка\"]/..//div");

    public void fillDataLk() {
        //Очистка данных
        driver.findElement(inputName).clear();
        driver.findElement(inputLastName).clear();
        driver.findElement(inputBlogName).clear();
        driver.findElement(inputDateBirth).clear();
        driver.findElement(inputCompany).clear();
        driver.findElement(inputWork).clear();
        //Заполнение данных
        driver.findElement(inputName).sendKeys(userDto.firstName());
        driver.findElement(inputLastName).sendKeys(userDto.lastName());
        driver.findElement(inputBlogName).sendKeys(userDto.name());
        driver.findElement(inputDateBirth).sendKeys(userDto.dataBirth());
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
        driver.findElement(inputNumberPhone1).sendKeys(userDto.numberPhone1());
        driver.findElement(buttonAdd).click();
        driver.findElement(spanCommunication).click();
        driver.findElement(buttonTelegram).click();
        driver.findElement(inputNumberPhone2).sendKeys(userDto.numberPhone2());
        //Пол
        driver.findElement(selectGender).click();
        driver.findElement(optionMen).click();
        //Место работы
        driver.findElement(inputCompany).sendKeys(userDto.company());
        //Должность
        driver.findElement(inputWork).sendKeys(userDto.work());
        //Сохранение данных
        driver.findElement(buttonSave).click();
        logger.info("Данные заполнены");
    }

    public void clearDataLkOptionalFields () {
        driver.findElement(inputFullDay).click();
        driver.findElement(buttonDeleteContactInfo2).click();
        driver.findElement(buttonDeleteContactInfo4).click();
        driver.findElement(selectGender).click();
        driver.findElement(GenderNoSpecified).click();
        driver.findElement(buttonSave).click();
        logger.info("Данные очищены");
    }

    public UserDto actualValues () {
        UserDto userDto = new UserDto();
        String actualFirstName = driver.findElement(inputName).getAttribute("value");
        String actualLastName = driver.findElement(inputLastName).getAttribute("value");
        String actualName = driver.findElement(inputBlogName).getAttribute("value");
        String actualDateBirth = driver.findElement(inputDateBirth).getAttribute("value");
        String actualCountry = driver.findElement(labelCountry).getText();
        String actualCity = driver.findElement(inputCity).getText();
        String actualLevelEnglish = driver.findElement(inputEnglishLevel).getText();
        String actualEmail= driver.findElement(inputEmail).getAttribute("value");
        String actualCommunicationMethodTelegram = driver.findElement(divTelegram).getText();
        String actualCommunicationMethodWhatsApp = driver.findElement(divWhatsApp).getText();
        String actualCommunicationPhone1 = driver.findElement(inputNumberPhone1).getAttribute("value");
        String actualCommunicationPhone2 = driver.findElement(inputNumberPhone2).getAttribute("value");
        String actualGender = driver.findElement(optionMen).getText();
        String actualCompanyName = driver.findElement(inputCompanyName).getAttribute("value");
        String actualWorkName = driver.findElement(inputWorkName).getAttribute("value");

        userDto.setUserFirstName(actualFirstName);
        userDto.setUserLastName(actualLastName);
        userDto.setUserName(actualName);
        userDto.setUserDataBirth(actualDateBirth);
        userDto.setCountry(actualCountry);
        userDto.setCity(actualCity);
        userDto.setLevelEnglish(actualLevelEnglish);
        userDto.setEmail(actualEmail);
        userDto.setCommunicationMethodTelegram(actualCommunicationMethodTelegram);
        userDto.setCommunicationMethodWhatsApp(actualCommunicationMethodWhatsApp);
        userDto.setNumberPhone1(actualCommunicationPhone1);
        userDto.setNumberPhone2(actualCommunicationPhone2);
        userDto.setGender(actualGender);
        userDto.setCompany(actualCompanyName);
        userDto.setWork(actualWorkName);

        return userDto;

    }
}
