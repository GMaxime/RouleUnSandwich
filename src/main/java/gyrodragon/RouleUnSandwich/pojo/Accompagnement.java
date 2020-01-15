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
	
	@Column(name = "name")
	String name;
	
	@Column(name = "price")
	double price;
	
	
}
