package gyrodragon.RouleUnSandwich.pojo.associations;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "commandes_sandwichs")
public class CommandeSandwich implements Serializable {
	@Id
	@Column(name = "cs_com_id")
	int idCom;
	
	@Id
	@Column(name = "cs_sp_id")
	int idSan;
}
