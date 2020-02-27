package gyrodragon.RouleUnSandwich.rest;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;
import java.sql.SQLException;

@ApplicationPath("/rest")
public class AppConfig extends ResourceConfig {

    public AppConfig() throws SQLException {
        packages("gyrodragon.RouleUnSandwich.rest");
        register(ProduitService.class);
    }
}