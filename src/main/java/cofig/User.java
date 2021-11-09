package cofig;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:User.properties")
public interface User extends Config {

    String firstName();
    String lastName();
    String name();
    String dataBirth();
    String numberPhone1();
    String numberPhone2();
    String company();
    String work();
    String country();
    String city();
    String levelEnglish();
    String email();
    String communicationMethodTelegram();
    String communicationMethodWhatsApp();
    String genderM();
}