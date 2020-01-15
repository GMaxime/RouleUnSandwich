package gyrodragon.RouleUnSandwich.launcher;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import gyrodragon.RouleUnSandwich.pojo.Commande;
import gyrodragon.RouleUnSandwich.pojo.Produit;
import gyrodragon.RouleUnSandwich.pojo.hibernate.HibernateUtil;

public class launcher {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tcx = session.beginTransaction();
		
//		System.out.println(produit);
//		System.out.println(session.save(produit));
		Query query = session.createQuery("from Commande");
		Commande c = (Commande) query.getResultList().get(0);
		c.fetchSandwichs();
		System.out.println(c.getSandwichs());
		
		tcx.commit();
	}
}
