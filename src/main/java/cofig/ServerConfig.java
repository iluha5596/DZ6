package cofig;
import org.aeonbits.owner.Config;

@Config.Sources("classpath: ServerConfig.properties")
public interface ServerConfig extends Config {

    String login() ;
    String password();
}
