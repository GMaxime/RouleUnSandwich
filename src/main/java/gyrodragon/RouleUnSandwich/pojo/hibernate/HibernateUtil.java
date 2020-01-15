package gyrodragon.RouleUnSandwich.pojo.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	private final static String PATH = "gyrodragon/RouleUnSandwich/pojo/hibernate/";   
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				registry = new StandardServiceRegistryBuilder().configure(PATH+"hibernate.cfg.xml").build();
				MetadataSources metaSources = new MetadataSources(registry);
				Metadata metadata = metaSources.getMetadataBuilder().build();
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			} catch (Exception e) {
				e.printStackTrace();
				if (registry != null)
					StandardServiceRegistryBuilder.destroy(registry);
			}
		}
		return sessionFactory;
	}

	public static void shutdown() {
		if (registry != null)
			StandardServiceRegistryBuilder.destroy(registry);
	}
}
