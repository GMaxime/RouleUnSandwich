package gyrodragon.RouleUnSandwich.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "formules")
public class Formule {
	@Id
	@Column(name = "for_id")
	int id;
	
	@Column(name = "for_sandwichs_number")
	int sandwichsNb;
	
	@Column(name = "for_drink_number")
	int drinkNb;
	
	@Column(name = "for_dessert_number")
	int dessertNb;
	
	@Column(name = "for_price")
	double price;
}
