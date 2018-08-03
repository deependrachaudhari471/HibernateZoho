package in.com.prestige.util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	public static SessionFactory factory = null;

	// Disallow creating object by other class
	private HibernateUtil(){

	}
   //Making SessionFactory object Singleton
	public static SessionFactory getSessionFactory() {
		if (factory == null) {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(cfg.getProperties())
					.buildServiceRegistry();
			factory = cfg.buildSessionFactory(registry);
		}
		return factory;
	}
}
