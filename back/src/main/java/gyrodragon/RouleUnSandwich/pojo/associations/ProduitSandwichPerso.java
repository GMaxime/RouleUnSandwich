package gyrodragon.RouleUnSandwich.pojo.associations;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gyrodragon.RouleUnSandwich.pojo.Produit;

@Entity
@Table(name = "produits_sandwichs_perso")
public class ProduitSandwichPerso implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "psp_san_id")
	int idSan;
	
	@Id
	@Column(name = "psp_pro_id")
	int idPro;
	
	@ManyToOne
	@JoinColumn(name = "psp_pro_id")
	Produit produit;

	public ProduitSandwichPerso(){}

	public ProduitSandwichPerso(int idSan, int idPro, Produit produit) {
		super();
		this.idSan = idSan;
		this.idPro = idPro;
		this.produit = produit;
	}

	public Produit getProduit() {
		return produit;
	}
}
