package otus.com;
import cofig.ServerConfig;
import cofig.User;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import otus.com.dto.UserDto;
import otus.com.pages.*;


public class Otus extends BaseTest {


    @Test
    public void addingValidatingData() {
        UserDto userDto = new UserDto();
        ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
        User user = ConfigFactory.create(User.class);
        //Авторизация
        Authorization authorization = new Authorization(driver);
        authorization.openOtus();
        authorization.auth(cfg.login(), cfg.password());
        //Переход в раздел о себе
        MainPage mainPage = new MainPage(driver);
        mainPage.openSectionYourself();
        //Заполнение данных
        Lk lk = new Lk(driver, userDto);
        lk.fillDataLk();
        //Закрытие драйвера
        driver.quit();
        logger.info("Драйвер закрыт");
        //Поднять драйвер
        driver = new ChromeDriver();
        logger.info("Драйвер поднят");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        //Авторизация
        authorization = new Authorization(driver);
        authorization.openOtus();
        authorization.auth(cfg.login(), cfg.password());
        //Переход в раздел о себе
        mainPage = new MainPage(driver);
        mainPage.openSectionYourself();
        //Проверка ранее введённых данных в ЛК
        Assert.assertEquals("Илья", driver.findElement(By.xpath("//input[@data-title=\"Имя\"]")).getAttribute("value"));
        logger.info("Имя - ОК");
        Assert.assertEquals("Пантиков", driver.findElement(By.xpath("//input[@data-title=\"Фамилия\"]")).getAttribute("value"));
        logger.info("Фамилия - ОК");
        Assert.assertEquals("05.07.1996", driver.findElement(By.xpath("//input[@title=\"День рождения\"]")).getAttribute("value"));
        logger.info("День рождения - ОК");
        //Страна
        Assert.assertEquals("Россия", driver.findElement(By.cssSelector(".js-lk-cv-dependent-master > label:nth-child(1) > div:nth-child(2)")).getText());
        logger.info("Страна - ОК");
        //Город
        Assert.assertEquals("Москва", driver.findElement(By.xpath("//input[@data-title=\"Город\"]/..//div")).getText());
        logger.info("Город - ОК");
        //Уровень английского
        Assert.assertEquals("Элементарный уровень (Elementary)", driver.findElement(By.xpath("//input[@data-title=\"Уровень знания английского языка\"]/..//div")).getText());
        logger.info("Уровень английского - ОК");
        //Почта
        Assert.assertEquals("pantik96@mail.ru", driver.findElement(By.xpath("(//input[@name=\"email\"])[1]")).getAttribute("value"));
        logger.info("Почта - ОК");
        //Способ связи
        Assert.assertEquals("Тelegram", driver.findElement(By.xpath("(//div[@class=\"input input_full lk-cv-block__input input_straight-bottom-right input_straight-top-right input_no-border-right lk-cv-block__input_fake lk-cv-block__input_select-fake js-custom-select-presentation\"])[1]")).getText());
        logger.info("Телеграмм - ОК");
        Assert.assertEquals("WhatsApp", driver.findElement(By.xpath("(//div[@class=\"input input_full lk-cv-block__input input_straight-bottom-right input_straight-top-right input_no-border-right lk-cv-block__input_fake lk-cv-block__input_select-fake js-custom-select-presentation\"])[2]")).getText());
        logger.info("WhatsApp - ОК");
        Assert.assertEquals("+79999999999", driver.findElement(By.xpath("//input[@name=\"contact-0-value\"]")).getAttribute("value"));
        logger.info("Номер Tg - ОК");
        Assert.assertEquals("+79999999999", driver.findElement(By.xpath("//input[@name=\"contact-1-value\"]")).getAttribute("value"));
        logger.info("Номер WhatsApp - ОК");
        //Пол
        Assert.assertEquals("m", driver.findElement(By.xpath("//select[@name=\"gender\"]")).getAttribute("value"));
        logger.info("Пол - ОК");
        //Компания
        Assert.assertEquals("ПАО Абсолют банк", driver.findElement(By.xpath("//input[@id=\"id_company\"]")).getAttribute("value"));
        logger.info("Компания - ОК");
        //Должность
        Assert.assertEquals("QA Engineer", driver.findElement(By.xpath("//input[@id=\"id_work\"]")).getAttribute("value"));
        logger.info("Должность - ОК");
        //Проверка чекбокса
        if (driver.findElement(By.xpath("//input[@title=\"Полный день\"]//..")).isSelected())
        {
            logger.info("Неверный данные в Готовность к переезду");
        }
        if (driver.findElement(By.xpath("//input[@title=\"Полный день\"]//..")).isSelected()) {
            logger.info("Неверный данные в Форма работы");
        }
        logger.info("Данные заполнены верно");
        //Очистка данных
        lk = new Lk(driver, userDto);
        lk.clearDataLkOptionalFields();

    }



}
