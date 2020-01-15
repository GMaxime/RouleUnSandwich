package gyrodragon.RouleUnSandwich.pojo;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.Session;
import org.hibernate.Transaction;

import gyrodragon.RouleUnSandwich.pojo.associations.CommandeSandwich;
import gyrodragon.RouleUnSandwich.pojo.hibernate.HibernateUtil;

@Entity
@Table(name = "commandes")
public class Commande {
	@Id
	@Column(name = "com_id")
	int id;
	
	@ManyToOne
	@JoinColumn(name = "com_cli_id")
	Client client;
	
	@Transient
	ArrayList<SandwichPerso> sandwichs = new ArrayList<SandwichPerso>();

	public int getId() {
		return id;
	}

	public Client getClient() {
		return client;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ArrayList<SandwichPerso> getSandwichs() {
		return sandwichs;
	}

	public void setSandwichs(ArrayList<SandwichPerso> sandwichs) {
		this.sandwichs = sandwichs;
	}
	
	public void fetchSandwichs() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tcx = session.beginTransaction();
		
		Query query = session.createQuery("select idSan from CommandeSandwich where idCom = :idcom");
		query.setParameter("idcom", id);
		ArrayList<Integer> cs = (ArrayList<Integer>) query.getResultList();
		tcx.commit();
		
		query = session.createQuery("from SandwichPerso where id in (:idlist)");
		query.setParameter("idlist", cs);
		sandwichs = (ArrayList<SandwichPerso>) query.getResultList();
	}
}
