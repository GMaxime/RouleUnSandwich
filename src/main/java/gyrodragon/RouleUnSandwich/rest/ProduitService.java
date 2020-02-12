package gyrodragon.RouleUnSandwich.rest;

        import javax.annotation.security.RolesAllowed;
        import javax.inject.Inject;
        import javax.ws.rs.GET;
        import javax.ws.rs.Path;
        import javax.ws.rs.PathParam;
        import javax.ws.rs.Produces;
        import javax.ws.rs.core.MediaType;
        import javax.ws.rs.core.Response;
        import java.sql.SQLException;

@Path("/produits")
@Produces(MediaType.APPLICATION_JSON)
public class ProduitService {


/*    @Inject
    public IngredientService(final IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }*/

    @GET
    @Path("/")
    public Response retrieveIngredientById() throws SQLException {
        return Response.status(200).entity("Hello").build();
    }

}
