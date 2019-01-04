package domain.generic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.mysql.jdbc.Connection;

import domain.dto.Users;
import domain.generic.HiberConnerction;
import java.io.Serializable;
import javax.servlet.http.HttpServlet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



//must take connection from hiberconnection
//
public class FindUser  {

   
     public static List FindByUserName(String Username,String Password) {
	
    	 
    	 
	
	 
     Session session =  (Session) new HiberConnerction();
  
  
     
     List Users = session.createCriteria(Users.class)
    		    .add( Restrictions.like("username", Username) )
    		    .add( Restrictions.like("password", Password) )
    		    .list();
     
     
     session.getTransaction().commit();
     session.close(); 
    return Users;
  
	} 

	
}
