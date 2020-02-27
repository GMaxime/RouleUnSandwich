package gyrodragon.RouleUnSandwich.rest;

import gyrodragon.RouleUnSandwich.pojo.Produit;
import gyrodragon.RouleUnSandwich.pojo.hibernate.HibernateUtil;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;

@Path("/produits")
@Produces(MediaType.APPLICATION_JSON)
public class ProduitService {

    @GET
    @Path("/")
    public Response retrieveIngredientById() throws SQLException {
        return Response.status(200).entity(Produit.getAll()).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProduct(InputProduit produit) {
        Produit createdProduct = create(produit.getName(), produit.getPrice());

        if (createdProduct == null) {
            return Response.status(500).build();
        }

        return Response.status(200).entity(createdProduct).build();
    }

    public static Produit create(String name, double price) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tcx = session.beginTransaction();

        try {
            final Produit produit = new Produit(name, price);
            session.save(produit);

            tcx.commit();
            return produit;
        } catch (Exception ex) {
            ex.printStackTrace();
            tcx.rollback();
        }

        return null;
    }
}
