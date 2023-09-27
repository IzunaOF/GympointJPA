package Utils;

import static Main.Main.dotenv;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaManager {

    public static EntityManagerFactory createEntityManagerFactory() {
        Map<String, String> properties = new HashMap<>();

        // Configure as variáveis de ambiente aqui
        properties.put("javax.persistence.jdbc.driver", dotenv.get("DB_DRIVER"));
        properties.put("javax.persistence.jdbc.url", dotenv.get("DB_URL"));
        properties.put("javax.persistence.jdbc.user", dotenv.get("DB_USER"));
        properties.put("javax.persistence.jdbc.password", dotenv.get("DB_PASSWORD"));

        return Persistence.createEntityManagerFactory("gympoint", properties);
    }

    public static EntityManager getEntityManager() {
        return createEntityManagerFactory().createEntityManager();
    }

    public static void closeEntityManagerFactory() {
        createEntityManagerFactory().close();
    }
}
