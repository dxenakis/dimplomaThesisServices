package domain.generic;

import java.io.Serializable;
import java.rmi.registry.Registry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import domain.dto.Users;
import org.hibernate.Session;
public class HiberConnerction {

	private static final Session Session =  GetConnection();
	private static Session GetConnection(){
        // loads configuration and creates a session factory
        Configuration configuration = new Configuration().configure();
        ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
        registry.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
         
        // opens a new session from the session factory
        Session Session = sessionFactory.openSession();
        
        
         
       return Session;
	}   

	 public static Session getSession() {
	        return Session;
	    }

	 public static  void CloseSession() {
		 Session.getTransaction().commit();
		 Session.close(); 
	    }

	
	
}


