package gyrodragon.RouleUnSandwich.rest;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.mindrot.jbcrypt.BCrypt;

import javax.ws.rs.ApplicationPath;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationPath("/rest")
public class AppConfig extends ResourceConfig {

    public AppConfig() throws SQLException {
        packages("gyrodragon.RouleUnSandwich.rest");
        register(ProduitService.class);
    }
}