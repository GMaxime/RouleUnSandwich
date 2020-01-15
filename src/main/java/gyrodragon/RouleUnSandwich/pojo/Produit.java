package gyrodragon.RouleUnSandwich.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produits")
public class Produit {

	@Id
	@Column(name = "pro_id")
	int id;

	@Column(name = "pro_name")
	String name;

	@Column(name = "pro_price")
	double price;

	public Produit() {
	}
	
	public Produit(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return id + " : " + name + " à " + price + "€";
	}
}
