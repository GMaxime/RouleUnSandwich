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
	
	@Column(name = "com_price")
	Double price;
	
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
	
	@Override
	public String toString() {
		return "Commande n°"+ id +" : passée par le client " + client.getId() + " comprends " + sandwichs.size() + " sandwichs et " + getAccompagnements().size() + " accompagnements";
	}
	
	public int getSandwichNumber() {
		return getSandwichs().size();
	}
	
	public int getAccompagnementNumber() {
		return getAccompagnements().size();
	}
	
	public void addSandwich(SandwichPerso sandwich) {
		sandwichs.add(sandwich);
		sandwich.setCommandeId(this.id);
	}
	
	public void addAccompagnement(Accompagnement acc) {
		CommandeAccompagnement ca = new CommandeAccompagnement();
		accompagnements.add(ca);
	}
	
	public double calculPrice() {
		int sanNb = getSandwichNumber();
		int accNb = getAccompagnementNumber();
		double price = 0;
		
		while(accNb>0) {
			while(sanNb>0) {
				if (accNb >= 2) {
					price += 11.2;
					sanNb-=1;
					accNb-=2;
				}
				else if (accNb >= 1) {
					price += 9.8;
					sanNb-=1;
					accNb-=1;
				}
				else {
					price += 8;
					sanNb-=1;
				}
			}
			price += accNb*2;
		}
		
		return price;
	}
}
