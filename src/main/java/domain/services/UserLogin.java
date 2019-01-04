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

import org.json.JSONObject;

import domain.dao.UserDAO;
import domain.dao.UsersDao;
import domain.dto.UserDTO;
import domain.dto.Users;
import domain.generic.HiberConnerction;
import domain.generic.HiberCritiria;



public class UserLogin extends HttpServlet {
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
			
			
			if(data.has("username") && data.has("password") && (data.get("username").toString()!=null) )           {
		
				
				String username =data.get("username").toString();
			//	System.out.println("ID: " + username); 		
				
				
				HiberCritiria HiberCritiria = new HiberCritiria();
			//	List <Users> users = HiberCritiria.findByUserName(username);				
			  	List <Users> users = UsersDao.findByUniqueFacebookID(username);
								
				
				
				 
		//        for (java.util.Iterator iterator = users.iterator(); iterator.hasNext();){
		//            Users user = (Users) iterator.next(); 
		//            System.out.print(" UserName: " + user.getUsername()); 
		//            System.out.print(" Password: " + user.getPassword());
		//            System.out.println(" dbID: " + user.getId()); 
		//            resp.put("userID",user.getId());
		        
		        
		//        }
				
				
				
		        
		        
		        
				    if (users.isEmpty()) {
				    	resp.put("response", "no user found or multiple users with same credentials");
				    }
				    else {
				    	resp.put("userID", users.get(0).getId());
				    	resp.put("password", users.get(0).getPassword());
				    	resp.put("response", "ok");
				    	//resp.put("FileSystem", "Internal");
				    	System.out.println(" response_id:       " + users.get(0).getId()); 
				    	System.out.println(" response_password: " + users.get(0).getPassword()); 
				    }
			    }
				
				
			
			
			utx.commit();
			response.setCharacterEncoding("UTF-8");
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");	
			response.addHeader("Access-Control-Allow-Origin", "http://localhost:*");		
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
