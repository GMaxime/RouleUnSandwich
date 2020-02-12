package gyrodragon.RouleUnSandwich.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import gyrodragon.RouleUnSandwich.pojo.hibernate.HibernateUtil;

@Entity
@Table(name = "produits")
public class Produit {
	
	public static List<Produit> all;

	@Id
	@Column(name = "pro_id")
	int id;

	@Column(name = "pro_name")
	String name;

	@Column(name = "pro_price")
	double price;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
	public static List<Produit> getAll() {
		if (all == null) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tcx = session.beginTransaction();
			
			@SuppressWarnings("unchecked")
			Query<Produit> query = session.createQuery("from Produit");
			
			tcx.commit();
			all = query.list();
		}
		return all;
	}

	@Override
	public String toString() {
		return id + " : " + name + " à " + price + "€";
	}
}
