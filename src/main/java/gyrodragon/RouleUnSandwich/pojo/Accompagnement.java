package gyrodragon.RouleUnSandwich.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accompagnements")
public class Accompagnement {
	@Id
	@Column(name = "acc_id")
	int id;
	
	@Column(name = "acc_name")
	String name;
	
	@Column(name = "acc_category")
	String category;
	
	@Column(name = "acc_price")
	double price;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}
	
	
}
