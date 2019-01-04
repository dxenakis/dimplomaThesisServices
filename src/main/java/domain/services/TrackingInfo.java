package domain.services;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import domain.dao.RouteDao;
import domain.dao.UserDAO;
import domain.dao.UsersDao;
import domain.dto.RouteDto;
import domain.dto.TrackingInfoDto;
import domain.dto.UserDTO;
import domain.dto.Users;


import domain.generic.HiberCritiria;



public class TrackingInfo extends HttpServlet {
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
			
			
			if(data.has("routetracking"))           {
		
				
				int routetracking = Integer.parseInt(data.get("routetracking").toString());
				System.out.println("RouteTracking: " + routetracking); 
				
				HiberCritiria HiberCritiria = new HiberCritiria();
			  	List<TrackingInfoDto> routetrackinginfo =  RouteDao.TrackingInfoDao(routetracking);
			  		//	RouteDao.findbyRoutetracking(1);
			  	
			  	
			  	
			  	
			
			  	
		      //  for (java.util.Iterator iterator = routes.iterator(); iterator.hasNext();){
		      //      RouteDao routesList = (Users) iterator.next(); 
		      //      System.out.println(" RouteTrndate: " + user.getUsername()); 
		      //      System.out.println(" Password: " + user.getPassword());
		      //      System.out.println("size: " + routes.size()); 
		      //      System.out.println("size: " + routes.get(1).getTrndate());
		      //      resp.put("userID",user.getId());
 	        
		      //  }		            
		        
		        
				    if (routetrackinginfo.isEmpty()) {
				    	resp.put("response", "no info found for this Route_id");
				    }
				    else {
				    	
				    	for (int i = routetrackinginfo.size() - 1 ; i >= 0 ; i--) {
				    		System.out.println(" console:       " + routetrackinginfo.get(0)); 		    	

				    		JSONObject eachData = new JSONObject();
	                //        try {
	                //        	eachData.put("routetracking",routetrackinginfo.get(i).getRoutetracking());
			        //            eachData.put("truck",  routetrackinginfo.get(i).getTruck());
	                //            eachData.put("freeweight",routetrackinginfo.get(i).getFreeweight());
	                //            eachData.put("freevolume",routetrackinginfo.get(i).getFreevolume());
	                            
	                        
	                //        } catch (JSONException e) {
	                //            e.printStackTrace();
	                //        }
	               //         DataArray.put(eachData);
				    		    		
				    		
				    		
				    	}
				    	
				    	 resp.put("data",routetrackinginfo.get(0));
				    	 resp.put("response","true");
				    	 
				    	
				    	
				    //	resp.put("Route", routes.get(0).
				    //	resp.put("response", "ok");
				    	//resp.put("FileSystem", "Internal");
				  //  	System.out.println(" response_id:       " + routes.get(0).; 
				  //  	System.out.println(" response_password: " + routes.get(0).getPassword()); 
				    }
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
