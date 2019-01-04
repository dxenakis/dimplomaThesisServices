package domain.dao;

import domain.dto.UserDTO;
import domain.generic.GenericHibernateDAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class UserDAO extends GenericHibernateDAO<UserDTO,Long>{
	
public  List<UserDTO> findByUniqueFacebookID(String facebookID)
{
	List<Criterion> criteria = new ArrayList<Criterion>();
	
	if (facebookID != null)
	{
	    criteria.add(Restrictions.eq("facebookID",facebookID));
	    
	}
	
	return findByCriteria(criteria);
}
	
public  List<UserDTO> findByUsernamePassword(String username, String password)
{
	List<Criterion> criteria = new ArrayList<Criterion>();
	
	if (username != null)
	{
	    criteria.add(Restrictions.eq("username",username));
	    
	}
	
	if (password != null)
	{
	    criteria.add(Restrictions.eq("password",password));
	    
	}
	
	return findByCriteria(criteria);
}

}
