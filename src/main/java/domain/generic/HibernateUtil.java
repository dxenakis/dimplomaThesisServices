package domain.generic;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static  boolean loaded=false; 
    @SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory() {
    	
        try {
        	if(!loaded){
        		loaded=true;
        		return new Configuration().configure().buildSessionFactory();
        		
        	}else{
        		return sessionFactory;
        	}
            // Create the SessionFactory from hibernate.cfg.xml
            
        	
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    	
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    

}