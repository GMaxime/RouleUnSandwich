package gyrodragon.RouleUnSandwich.pojo;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.Session;
import org.hibernate.Transaction;

import gyrodragon.RouleUnSandwich.pojo.hibernate.HibernateUtil;

@Entity
@Table(name = "sandwichs_perso")
public class SandwichPerso {
	@Id
	@Column(name = "sp_id")
	int id;
	
	@Column(name = "sp_san_id")
	Integer sandId;
	
	@Transient
	Sandwich base;
	
	@Transient
	ArrayList<Produit> produits = new ArrayList<Produit>();
	
	public void fetchProduits() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tcx = session.beginTransaction();
		
		Query query = session.createQuery("from ProduitSandwich where idSan = :idsan");
		query.setParameter("idsan", id);
		produits = (ArrayList<Produit>) query.getResultList().get(0);
		tcx.commit();
	}

	public int getId() {
		return id;
	}

	public int getSandid() {
		return sandId;
	}

	public Sandwich getBase() {
		return base;
	}

	public ArrayList<Produit> getProduits() {
		return produits;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSandid(int sandid) {
		sandId = sandid;
	}

	public void setBase(Sandwich base) {
		this.base = base;
	}

	public void setProduits(ArrayList<Produit> produits) {
		this.produits = produits;
	}
	
	
}
