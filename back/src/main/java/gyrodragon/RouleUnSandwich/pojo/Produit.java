package gyrodragon.RouleUnSandwich.pojo;

import gyrodragon.RouleUnSandwich.pojo.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "produits")
public class Produit {

    public static List<Produit> all;

    public Produit() {
    }

    public Produit(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Id
    @Column(name = "pro_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "pro_name")
    public String name;

    @Column(name = "pro_price")
    private double price;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public static List<Produit> getAll() {
        if (all == null) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tcx = session.beginTransaction();

            @SuppressWarnings("unchecked")
            Query<Produit> query = session.createQuery("from Produit");

            tcx.commit();
            all = query.list();
        }
        return all;
    }



    @Override
    public String toString() {
        return id + " : " + name + " à " + price + "€";
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return id == produit.id &&
                Double.compare(produit.price, price) == 0 &&
                Objects.equals(name, produit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
}
