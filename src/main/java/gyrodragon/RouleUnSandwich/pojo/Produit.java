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

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return id + " : " + name + " à " + price + "€";
	}
}
