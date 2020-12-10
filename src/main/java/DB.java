import org.slf4j.LoggerFactory;
import org.sql2o.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Logger;

public class DB {
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ndyklddhfhadqu:bd48dab52e2afab110d497f2ec39184ba60a06d447e14819a09c4a30c6a760e1@ec2-3-214-4-151.compute-1.amazonaws.com:5432/da4n8koktimghb");
    public static URI dbUri;
    static Logger logger = (Logger) LoggerFactory.getLogger(DB.class);
    static {

        try {
            if (System.getenv("DATABASE_URL") == null) {
                dbUri = new URI("postgres://localhost:5432/to_do");
            } else {
                dbUri = new URI(System.getenv("DATABASE_URL"));
            }
            int port = dbUri.getPort();
            String host = dbUri.getHost();
            String path = dbUri.getPath();
            String username = (dbUri.getUserInfo() == null) ? "gladys" : dbUri.getUserInfo().split(":")[0];
            String password = (dbUri.getUserInfo() == null) ? "mypassword" : dbUri.getUserInfo().split(":")[1];
            sql2o = new Sql2o("jdbc:postgresql://" + host + ":" + port + path, username, password);
        } catch (URISyntaxException e) {
//            logger. error("Unable to connect to the database.");
        }
    }
}




