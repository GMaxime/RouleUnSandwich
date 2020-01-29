package gyrodragon.RouleUnSandwich.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import gyrodragon.RouleUnSandwich.pojo.associations.CommandeAccompagnement;

@Entity
@Table(name = "commandes")
public class Commande {
	@Id
	@Column(name = "com_id")
	int id;
	
	@ManyToOne
	@JoinColumn(name = "com_cli_id")
	Client client;
	
	@OneToMany
	@JoinColumn(name = "sp_com_id")
	List<SandwichPerso> sandwichs;
	
	@OneToMany
	@JoinColumn(name = "ca_com_id")
	List<CommandeAccompagnement> accompagnements;
	
	@Column(name = "com_status")
	String etat;
	
	public List<Accompagnement> getAccompagnements() {
		List<Accompagnement> pro = new ArrayList<Accompagnement>();
		for (CommandeAccompagnement ps : accompagnements) {
			pro.add(ps.getAccompagnement());
		}
		return pro;
	}
	
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

	public List<SandwichPerso> getSandwichs() {
		return sandwichs;
	}

	public void setSandwichs(List<SandwichPerso> sandwichs) {
		this.sandwichs = sandwichs;
	}
//	
//	public void fetchSandwichs() {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Transaction tcx = session.beginTransaction();
//		
//		Query query = session.createQuery("select idSan from CommandeSandwich where idCom = :idcom");
//		query.setParameter("idcom", id);
//		ArrayList<Integer> cs = (ArrayList<Integer>) query.getResultList();
//		tcx.commit();
//		
//		query = session.createQuery("from SandwichPerso where id in (:idlist)");
//		query.setParameter("idlist", cs);
//		sandwichs = (ArrayList<SandwichPerso>) query.getResultList();
//	}
	
	@Override
	public String toString() {
		return "Commande n°"+ id +" : passée par le client " + client.getId() + " comprends " + sandwichs.size() + " sandwichs et " + getAccompagnements().size() + " accompagnements";
	}
}
