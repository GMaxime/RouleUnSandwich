package gyrodragon.RouleUnSandwich.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import gyrodragon.RouleUnSandwich.pojo.associations.ProduitSandwich;

@Entity
@Table(name = "sandwichs")
public class Sandwich {
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

	public List<Produit> getProduits() {
		List<Produit> pro = new ArrayList<Produit>();
		for (ProduitSandwich ps : produits) {
			pro.add(ps.getProduit());
		}
		return pro;
	}
}