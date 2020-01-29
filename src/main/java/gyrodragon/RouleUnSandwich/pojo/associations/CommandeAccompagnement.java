package gyrodragon.RouleUnSandwich.pojo.associations;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gyrodragon.RouleUnSandwich.pojo.Accompagnement;

@Entity
@Table(name = "commandes_accompagnements")
public class CommandeAccompagnement implements Serializable {
	@Id
	@Column(name = "ca_com_id")
	int comId;

	@Id
	@Column(name = "ca_acc_id")
	int accId;
	
	@ManyToOne
	@JoinColumn(name = "ca_acc_id")
	Accompagnement accompagnement;

	public Accompagnement getAccompagnement() {
		return accompagnement;
	}
}
