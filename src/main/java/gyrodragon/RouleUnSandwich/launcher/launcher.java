package gyrodragon.RouleUnSandwich.launcher;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import gyrodragon.RouleUnSandwich.pojo.*;
import gyrodragon.RouleUnSandwich.pojo.hibernate.HibernateUtil;

public class launcher {
	public static void main(String[] args) {
		ProduitRepository.create("toto",1.0);

	}

	private static void ShowProductChoice() {
		System.out.println("Sandwichs");
		System.out.println("Accompagnements");
		
	}

	private static boolean commandNotFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}