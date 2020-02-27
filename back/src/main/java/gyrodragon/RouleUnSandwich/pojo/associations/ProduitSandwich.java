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
@Table(name = "produits_sandwichs")
public class ProduitSandwich implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ps_san_id")
	int idSan;
	
	@Id
	@Column(name = "ps_pro_id")
	int idPro;
	
	@ManyToOne
	@JoinColumn(name = "ps_pro_id")
	Produit produit;

	public Produit getProduit() {
		return produit;
	}
}
