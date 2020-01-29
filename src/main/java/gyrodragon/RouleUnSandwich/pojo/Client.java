package gyrodragon.RouleUnSandwich.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {
	@Id
	@Column(name = "cli_id")
	int id;

	@OneToMany
	@JoinColumn(name = "com_cli_id")
	List<Commande> commandes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	
	@Override
	public String toString() {
		return "client n°" + id + " a passé " + commandes.size() + " commandes :" + commandes;
	}
}
