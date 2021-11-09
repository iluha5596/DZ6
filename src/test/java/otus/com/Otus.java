package otus.com;
import cofig.ServerConfig;
import cofig.User;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import otus.com.dto.UserDto;
import otus.com.pages.*;

import static org.testng.AssertJUnit.assertEquals;


public class Otus extends BaseTest {


    @Test
    public void addingValidatingData() {
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
        Lk lk = new Lk(driver, user);
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
        Lk actualDataLk = new Lk(driver, user);
        UserDto actualDto = actualDataLk.actualValues();
        assertEquals(actualDto.getUserFirstName(), user.firstName());
        assertEquals(actualDto.getUserLastName(), user.lastName());
        assertEquals(actualDto.getUserName(), user.name());
        assertEquals(actualDto.getUserDataBirth(), user.dataBirth());
        //Страна
        assertEquals(actualDto.getCountry(), user.country());
        //Город
        assertEquals(actualDto.getCity(), user.city());
        //Уровень английского
        assertEquals(actualDto.getLevelEnglish(),user.levelEnglish());
        //Почта
        assertEquals(actualDto.getEmail(), user.email());
        //Способ связи
        assertEquals(actualDto.getCommunicationMethodTelegram(), user.communicationMethodTelegram());
        assertEquals(actualDto.getCommunicationMethodWhatsApp(), user.communicationMethodWhatsApp());
        assertEquals(actualDto.getNumberPhone1(), user.numberPhone1());
        assertEquals(actualDto.getNumberPhone2(), user.numberPhone2());
        //Пол
        assertEquals(actualDto.getGender(),user.genderM());
        //Компания
        assertEquals(actualDto.getCompany(), user.company());
        //Должность
        assertEquals(actualDto.getWork(), user.work());
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
        lk = new Lk(driver, user);
        lk.clearDataLkOptionalFields();

    }



}
