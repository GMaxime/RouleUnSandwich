package gyrodragon.RouleUnSandwich.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
}