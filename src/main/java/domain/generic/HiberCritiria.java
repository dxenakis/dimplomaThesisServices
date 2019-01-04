package domain.generic;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import domain.dto.RouteDto;
import domain.dto.Users;
import domain.dto.ProductsDto;
import domain.dto.StorageDto;
import domain.dto.TruckDto;
import domain.dto.TrackingInfoDto;

public class HiberCritiria {
	
	private static Session session;
	
	
	
	public void setSession(Session session) {
		this.session = session;
	}

    //protected
	public static Session getSession() {
		if (session == null)
			session =   HiberConnerction.getSession();     //HibernateUtil.getSessionFactory().getCurrentSession();
		return session;
	}
	
	
	@SuppressWarnings("unchecked")
	public static  List findByUserName(String Username) {
		Session session =getSession();
		Criteria criteria = (Criteria) session.createCriteria(Users.class);
        criteria.add( Restrictions.eq("username", Username) );
     //   criteria.add( Restrictions.eq("Password", Password) );
        List list =  criteria.list(); 
        session.clear();
	return list;
	
	}
	
	@SuppressWarnings("unchecked")
	public static  List findRoute(int routetracking) {
		Session session =getSession();
		Criteria criteria = (Criteria) session.createCriteria(RouteDto.class);
        criteria.add( Restrictions.eq("routetracking", routetracking) );
        List list =  criteria.list(); 
        session.clear();
	return list;
	
	}
	
	
	@SuppressWarnings("unchecked")
	public static  List findRouteAll() {
		Session session =getSession();
		Criteria criteria = (Criteria) session.createCriteria(RouteDto.class);
		criteria.add( Restrictions.eq("State", "Current") );
        List list =  criteria.list(); 
        session.clear();
	return list;
	
	}
	
	@SuppressWarnings("unchecked")
	public static  List findProducts() {
		Session session =getSession();
		Criteria criteria = (Criteria) session.createCriteria(ProductsDto.class);
      //  criteria.add( Restrictions.eq("product", "1") );
        List list =  criteria.list(); 
        session.clear();
	return list;
	
	}
	
	@SuppressWarnings("unchecked")
	public static  List findStorage() {
		Session session =getSession();
		Criteria criteria = (Criteria) session.createCriteria(StorageDto.class);
      //  criteria.add( Restrictions.eq("product", "1") );
        List list =  criteria.list(); 

        
	return list;
	
	}
	
	
	@SuppressWarnings("unchecked")
	public static  List findTrucks() {
		Session session =getSession();
		Criteria criteria = (Criteria) session.createCriteria(TruckDto.class);
      //  criteria.add( Restrictions.eq("product", "1") );
        List list =  criteria.list(); 
       // session.clear();
	return list;
	
	}
	

	@SuppressWarnings("unchecked")
	public static  List TrackingInfo(int RouteTracking) {
		Session session =getSession();
		
		String sql = "SELECT routetracking,truck,truckweight,truckvolume,stovolume,stoweight,TRUCKWEIGHT-STOWEIGHT AS freeweight," + 
				"TRUCKVOLUME-STOVOLUME AS freevolume" + 
				"" + 
				" FROM (SELECT A.routetracking   ,A.TRUCK as truck," + 
				"(SELECT weight FROM TRUCK WHERE TRUCK =A.TRUCK) AS truckweight ," + 
				"(SELECT VOLUME FROM TRUCK WHERE TRUCK =A.TRUCK) AS truckvolume ," + 
				"sum(d.volume) AS stovolume,sum(d.weight) AS stoweight FROM diplomatiki.route  A left join diplomatiki.trackinglines B " + 
				"on A.routetracking=B.Routetracking left join truck C ON B.Truck = C.truck " + 
				"LEFT JOIN storage d on B.Storage =d.storage " + 
				"where A.routetracking = :routetracking " + 
				"group by  A.routetracking,A.TRUCK ) AS MYTBL";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("routetracking",  RouteTracking);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		
		
		
		//	Criteria criteria = (Criteria) session.createCriteria(TrackingInfo.class);
      //  criteria.add( Restrictions.eq("product", "1") );
        List<TrackingInfoDto> list =  query.list(); 
       // session.clear();
	return list;
	
	}

	
	
	
	
	





}
