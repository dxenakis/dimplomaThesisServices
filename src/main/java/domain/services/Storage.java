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
import domain.dao.StorageDao;
import domain.dao.UserDAO;
import domain.dao.ProductsDao;
import domain.dto.ProductsDto;
import domain.dao.UsersDao;
import domain.dto.RouteDto;
import domain.dto.StorageDto;
import domain.dto.UserDTO;
import domain.dto.Users;
import domain.generic.HiberCritiria;



public class Storage extends HttpServlet {
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
	
			InitialContext ctx2 = new InitialContext();
			UserTransaction utx = (UserTransaction) ctx2.lookup("java:module/UserTransaction");
			utx.begin();
			String jsonStr = jb.toString();
			
			JSONObject data = new JSONObject(jsonStr);
			JSONObject resp = new JSONObject();						
			JSONArray DataArray = new JSONArray();
								
				HiberCritiria HiberCritiria = new HiberCritiria();
			  	List <StorageDto> storages =  StorageDao.findStorage();
			  			
			  	        
		        
				  // System.out.println(storages.get(0).getStorage());
				    	
				    	for (int i = storages.size() - 1 ; i >= 0 ; i--) {
				    			    	
				    	
				    		JSONObject eachData = new JSONObject();
	                        try {
	                        	eachData.put("storage",storages.get(i).getStorage());
	                        	eachData.put("name",  storages.get(i).getName());
	                            eachData.put("weight",storages.get(i).getWeight());
	                            eachData.put("volume",storages.get(i).getVolume());
	                        	System.out.println("storage: " + storages.get(i).getStorage() +"  weight:  " + storages.get(i).getWeight() +" volume: " + storages.get(i).getVolume() ); 
	                        	
	                        
	                        } catch (JSONException e) {
	                            e.printStackTrace();
	                        }
	                        DataArray.put(eachData);
				    		    		
				    		
				    		
				    	}
				    	
				    	 resp.put("data",DataArray);
				    	
				    	 resp.put("response","true");
				    	 resp.put("type","Storages");
	
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
