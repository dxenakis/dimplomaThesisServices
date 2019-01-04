package domain.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;


import domain.dto.StorageDto;
import domain.generic.HiberCritiria;


public class StorageDao extends HiberCritiria {

	public static  List<StorageDto> findallStorage()
	{
		List<Criterion> criteria = new ArrayList<Criterion>();
		
		
		return findStorage();
	}

	
	
	
	
	
	
	
}