package domain.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;


import domain.dto.ProductsDto;
import domain.generic.HiberCritiria;


public class ProductsDao extends HiberCritiria {

	public static  List<ProductsDto> findAllProducts()
	{
		List<Criterion> criteria = new ArrayList<Criterion>();
		
		
		return findProducts();
	}

	
	
	
	
	
	
	
}
