import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.ClassicConfiguration;
import org.flywaydb.core.api.configuration.Configuration;

import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        //Carefully, if programmatically configuration is present the flyway.properties one will be ignored!!!!!
//        Flyway flyway = Flyway.configure()
//                .dataSource("jdbc:postgresql://localhost:54322/test", "root", "password")
//                .locations("classpath:db/migrations/manual")
//                .load();
//
//        flyway.migrate();



//This way you can configure flyway from properties file
        var cl = Main.class.getClassLoader();
        var config = cl.getResourceAsStream("flyway.properties");

        Properties properties = new Properties();
        properties.load(config);

        Flyway flyway = Flyway.configure().configuration(properties).load();
        flyway.migrate();

//        properties.forEach((key, value) -> {
//            System.out.println(key + "=" + value);
//        });
    }
}
