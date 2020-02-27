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
	
	public SandwichPerso() {
	}

	public SandwichPerso(int commandeId) {
		this.commandeId = commandeId;
		base = null;
		produits = new ArrayList<ProduitSandwichPerso>();
	}
	
	public SandwichPerso(int commandeId, Sandwich base) {
		this.base = base;
		this.commandeId = commandeId;
		produits = new ArrayList<ProduitSandwichPerso>();
	}

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
	
	public void setCommandeId(int commandeId) {
		this.commandeId = commandeId;
	}

	public void addProduits(Produit produit) {
		ProduitSandwichPerso psp = new ProduitSandwichPerso(id,produit.getId(), produit);
		produits.add(psp);
	}
	
	public Double getPrice() {
		Double price = 0.0;
		if (base != null)
			price += base.getPrice();
		for (Produit produit : getProduits())
			price += produit.getPrice();
		
		return price;
	}
}
