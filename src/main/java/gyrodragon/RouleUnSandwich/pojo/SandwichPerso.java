package gyrodragon.RouleUnSandwich.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import gyrodragon.RouleUnSandwich.pojo.associations.ProduitSandwichPerso;

@Entity
@Table(name = "sandwichs_perso")
public class SandwichPerso {
	@Id
	@Column(name = "sp_id")
	int id;
	
	@ManyToOne
	@JoinColumn(name = "sp_san_id")
	Sandwich base;
	
	@OneToMany
	@JoinColumn(name = "psp_san_id")
	List<ProduitSandwichPerso> produits;
	
	@Column(name = "sp_com_id")
	int commandeId;

	public int getId() {
		return id;
	}

	public Sandwich getBase() {
		return base;
	}

	public List<Produit> getProduits() {
		List<Produit> pro = new ArrayList<Produit>();
		for (ProduitSandwichPerso ps : produits) {
			pro.add(ps.getProduit());
		}
		return pro;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setBase(Sandwich base) {
		this.base = base;
	}

	public void setProduits(List<Produit> produits) {
//		this.produits = produits; TODO
	}
	
	
}
