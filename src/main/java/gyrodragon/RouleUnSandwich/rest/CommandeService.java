package gyrodragon.RouleUnSandwich.rest;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.JSONArray;
import org.json.JSONObject;

import gyrodragon.RouleUnSandwich.pojo.Commande;
import gyrodragon.RouleUnSandwich.pojo.hibernate.HibernateUtil;

@Path("/commande")
@Produces(MediaType.APPLICATION_JSON)
public class CommandeService {

	
	@GET
	@Path("/valide")
	public Response valide() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tcx = session.beginTransaction();
		
		Query<Commande> query = session.createQuery("FROM Commande WHERE etat = 'valide'");
		
		List<Commande> commandes = query.list();
		JSONArray jsons = new JSONArray();
		
		for (Commande com : commandes) {
			JSONObject json = new JSONObject();

			json.put("id", com.getId());
			json.put("sandwichs", com.getSandwichs());
			json.put("accompagnements", com.getAccompagnements());
			
			jsons.put(json);
		}
		
		return Response.ok(jsons.toString()).build();
	}
	
	@POST
	@Path("/create")
	public Response createCommande(
			@QueryParam("client") @DefaultValue("0") int client) {
		Commande com = create(client);
		
		
		return Response.ok().build();
	}
	
	public static Commande create(int client) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tcx = session.beginTransaction();
		
		try {
			final Commande com = new Commande(client);
			session.save(com);
			tcx.commit();
			return com;
		} catch (Exception e) {
			tcx.rollback();
			return null;
		}
	}
}
