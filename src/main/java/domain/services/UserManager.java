package domain.services;

import java.io.Serializable;

import javax.servlet.http.HttpServlet;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import domain.dto.Users;
import domain.generic.FindUser;
import domain.generic.HiberCritiria;
import javassist.bytecode.Descriptor.Iterator;
 
/**
 * A sample program that demonstrates how to perform simple CRUD operations
 * with Hibernate framework.
 * @author www.codejava.net
 *
 */

public class UserManager extends HttpServlet {
	
	public static void findByName(Session session ,String Name) {
		
		
		
		
		
		Users user =  (Users) session.load(Users.class,new Integer(2));
		System.out.println("User's name: " + user.getName());
		System.out.println("User's phone:" + user.getTelephone());
		System.out.println("User's email:" + user.getEmail());
         
		
	}
	
    public static void main(String[] args) {
        // loads configuration and creates a session factory
        Configuration configuration = new Configuration().configure();
        ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
        registry.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
         
        // opens a new session from the session factory
       Session session = sessionFactory.openSession();
        session.beginTransaction();
        // persists two new Contact objects
        Users contact1 = new Users("Nikos","password","Nick", "hainatuatgmail.com", "Vietnam", "0904277091");
        session.persist(contact1);
        Users contact2 = new Users("Killahb","djgfasibfiasb","Vasilis", "billatgmail.com", "USA", "18001900");
        Serializable id = session.save(contact2);
        System.out.println("created id: " + id);
        findByName(session, "Rouxals");
   //     List users = (List) FindUser.FindByUserName("Dim32","qwerty!2");
         
        Criteria criteria = session.createCriteria(Users.class);
        criteria.add( Restrictions.eq("username", "Nikos") );
     //   criteria.add( Restrictions.eq("Password", "Nikos") );
        List userslist =  criteria.list(); 
       
        
        
        for (java.util.Iterator iterator = userslist.iterator(); iterator.hasNext();){
            Users user = (Users) iterator.next(); 
            System.out.print("First Name: " + user.getUsername()); 
            System.out.print("Last Name: " + user.getPassword());
            System.out.println("ID: " + user.getId()); 
         }
        
        
        
      
         
        // commits the transaction and closes the session
        session.getTransaction().commit();
        session.close();
        
  //      List list  = HiberCritiria.findByUserName("sdfa","fadf");
      //  System.out.println("createdasdadadas: " + userslist.getClass());
        
       
        
        
        
    }
}