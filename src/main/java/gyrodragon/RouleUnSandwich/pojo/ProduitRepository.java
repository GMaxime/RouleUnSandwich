package gyrodragon.RouleUnSandwich.pojo;

import gyrodragon.RouleUnSandwich.pojo.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProduitRepository {

    public static Produit create(String name, double price) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tcx = session.beginTransaction();

        try {
            final Produit produit = new Produit(name, price);
            session.save(produit);

            tcx.commit();
            return produit;
        } catch (Exception ex) {
            ex.printStackTrace();
            tcx.rollback();
        }

        return null;
    }
}
