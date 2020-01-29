package gyrodragon.RouleUnSandwich.launcher;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import gyrodragon.RouleUnSandwich.pojo.*;
import gyrodragon.RouleUnSandwich.pojo.hibernate.HibernateUtil;

public class launcher {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tcx = session.beginTransaction();
		
//		System.out.println(produit);
//		System.out.println(session.save(produit));
		Query query = session.createQuery("from Client");
		Client c = (Client) query.getResultList().get(0);
		System.out.println(c);
		
		tcx.commit();
	}
}
