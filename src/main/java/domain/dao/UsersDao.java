package domain.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import domain.dto.UserDTO;
import domain.dto.Users;
import domain.generic.HiberCritiria;

public class UsersDao extends HiberCritiria {

	public static  List<Users> findByUniqueFacebookID(String username)
	{
		List<Criterion> criteria = new ArrayList<Criterion>();
		
		if (username != null)
		{
			criteria.add( Restrictions.eq("username", username) );
		    
		}
		
		return findByUserName(username);
	}

	
	
	
	
	
	
	
}
