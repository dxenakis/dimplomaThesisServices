package domain.services;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Iterator;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.id.IdentityGenerator.GetGeneratedKeysDelegate;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import domain.dao.RouteDao;
import domain.dao.UserDAO;
import domain.dao.UsersDao;
import domain.dto.RouteDto;
import domain.dto.RouteLinesDto;
import domain.dto.StorageDto;
import domain.dto.TrackingLinesDto;
import domain.dto.UserDTO;
import domain.dto.Users;
import domain.generic.HiberCritiria;
import domain.generic.HibernateUtil;
import java.util.Date;


public class InsertRoute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	
	
	protected void doPosttest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	    
		System.out.println("Post Halndler execute..");
		StringBuilder sb = new StringBuilder();
	    BufferedReader reader = request.getReader();
	    try {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            sb.append(line).append('\n');
	        }
	    } finally {
	        reader.close();
	    }
	    System.out.println(sb.toString());
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "rawtypes", "rawtypes" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
				
		
		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			request.setCharacterEncoding("UTF-8");
		    BufferedReader reader = request.getReader();
		    while ((line = reader.readLine()) != null)
		      jb.append(line);
		  } catch (Exception e) { /*report an error*/ }
		try
		{
		//	System.out.println("Full place");
			InitialContext ctx2 = new InitialContext();
			UserTransaction utx = (UserTransaction) ctx2.lookup("java:module/UserTransaction");
			utx.begin();
			String jsonStr = jb.toString();
			
			JSONObject data = new JSONObject(jsonStr);
			JSONObject resp = new JSONObject();						
			JSONArray DataArray = new JSONArray();
			
			
			//variables from post Request comes to data jsonObject
			
			HiberCritiria HiberCritiria = new HiberCritiria();
	        Session session = HiberCritiria.getSession();
	        SQLQuery query = session.createSQLQuery("select max(routetracking) from route  ");
	        List	rows = query.list();
	     //   System.out.println("the max value of routeracking of Route Table is "+rows.toString());
	        
				java.sql.Date date =  new java.sql.Date(2018, 6,3);
				int truck = Integer.parseInt(data.get("truck").toString());
				int routetracking = ((Integer) rows.get(0)) + 1 ; 
				double longtitude   = Double.parseDouble(data.get("longtitude").toString());
				double latitude     = Double.parseDouble(data.get("latitude").toString());
				JSONArray storages= (JSONArray) data.get("storages");
				JSONObject innerObj = new JSONObject(storages.get(0).toString());
				int InitStorage = Integer.parseInt(innerObj.get("storage").toString());
				
				
				session.beginTransaction();			    
				RouteDto route = new RouteDto();
		        route.setRoutetracking(routetracking);
		        route.setStorage(InitStorage);
		        route.setTruck(truck);
		        route.setTrndate(date);
		        route.setLatitude(latitude);
		        route.setLongtitude(longtitude);
		        route.setState("Current");
		        session.save(route);
		        session.getTransaction().commit();
				
				// take the elements of the json array
				for(int i=0; i<storages.length(); i++){
					session.beginTransaction();				
					JSONObject innerObject = new JSONObject(storages.get(i).toString());
					TrackingLinesDto ins = new TrackingLinesDto();
			        ins.setRoutetracking(routetracking);
			        ins.setTruck(truck);
			        ins.setStorage(Integer.parseInt(innerObject.get("storage").toString()));
			        session.save(ins);
			        session.getTransaction().commit();
			    					
				}
			
			
			
			utx.commit();
			response.setCharacterEncoding("UTF-8");
			response.addHeader("Access-Control-Allow-Origin", "*");			
			response.addHeader("Access-Control-Allow-Credentials", "true");
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD");
			response.addHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
			response.getOutputStream().write(resp.toString().getBytes());
			 
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	
	
	
	
	
}
