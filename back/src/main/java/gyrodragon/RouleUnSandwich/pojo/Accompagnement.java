package gyrodragon.RouleUnSandwich.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import gyrodragon.RouleUnSandwich.pojo.hibernate.HibernateUtil;

@Entity
@Table(name = "accompagnements")
public class Accompagnement {
	
	public static List<Accompagnement> all;
	
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
	
	public static List<Accompagnement> getAll() {
		if (all == null) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tcx = session.beginTransaction();
			
			@SuppressWarnings("unchecked")
			Query<Accompagnement> query = session.createQuery("from Accompagnement");
			
			tcx.commit();
			all = query.list();
		}
		return all;
	}
}
