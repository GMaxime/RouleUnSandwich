package gyrodragon.RouleUnSandwich.pojo.associations;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produits_sandwichs")
public class ProduitSandwich implements Serializable {
	@Id
	@Column(name = "ps_san_id")
	int idSan;
	
	@Id
	@Column(name = "ps_pro_id")
	int idPro;
}
