package gyrodragon.RouleUnSandwich.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import gyrodragon.RouleUnSandwich.pojo.associations.ProduitSandwich;
import gyrodragon.RouleUnSandwich.pojo.hibernate.HibernateUtil;

@Entity
@Table(name = "sandwichs")
public class Sandwich {
	
	public static List<Sandwich> all;
	
	@Id
	@Column(name = "san_id")
	int id;
	
	@Column(name = "san_name")
	String name;

	@Column(name = "san_price")
	double price;
	
	@OneToMany
	@JoinColumn(name = "ps_san_id")
	List<ProduitSandwich> produits;
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public List<Produit> getProduits() {
		List<Produit> pro = new ArrayList<Produit>();
		for (ProduitSandwich ps : produits) {
			pro.add(ps.getProduit());
		}
		return pro;
	}
	
	public static List<Sandwich> getAll() {
		if (all == null) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tcx = session.beginTransaction();
			
			@SuppressWarnings("unchecked")
			Query<Sandwich> query = session.createQuery("from Sandwich");
			
			tcx.commit();
			all = query.list();
		}
		return all;
	}
}