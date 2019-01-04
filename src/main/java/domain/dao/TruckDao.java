package domain.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;


import domain.dto.ProductsDto;
import domain.dto.TruckDto;
import domain.generic.HiberCritiria;


public class TruckDao extends HiberCritiria {

	public static  List<TruckDto> findAllTrucks()
	{
		List<Criterion> criteria = new ArrayList<Criterion>();
		
		
		return findTrucks();
	}

	
	
	
	
	
	
	
}
