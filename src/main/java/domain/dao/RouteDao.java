package domain.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import domain.dto.RouteDto;
import domain.generic.HiberCritiria;
import domain.dto.TrackingInfoDto;

public class RouteDao extends HiberCritiria {

	public static  List<RouteDto> findbyRoutetracking(int routetracking)
	{
		List<Criterion> criteria = new ArrayList<Criterion>();
		
		if (routetracking!=0)
		{
			criteria.add( Restrictions.eq("routetracking", routetracking) );
		    
		}
		
		return findRoute(routetracking);
	}
	
	
	public static  List<RouteDto> findbyRoutetrackingAll()
	{
		List<Criterion> criteria = new ArrayList<Criterion>();
		criteria.add( Restrictions.eq("State", "Current"));
				
		return findRouteAll();
	}

	public static List TrackingInfoDao(int Routetracking) {
		
		return TrackingInfo(Routetracking);
		
	}
	
	
	
	
	
	
}
