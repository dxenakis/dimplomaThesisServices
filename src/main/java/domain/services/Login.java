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
import domain.dto.UserDTO;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
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
			System.out.println("Full place");
			InitialContext ctx2 = new InitialContext();
			UserTransaction utx = (UserTransaction) ctx2.lookup("java:module/UserTransaction");
			utx.begin();
			String jsonStr = jb.toString();
			
			JSONObject data = new JSONObject(jsonStr);
			JSONObject resp = new JSONObject();
			if(data.has("username") && data.has("password")){
				UserDAO userDAO = new UserDAO();
				List<UserDTO> users = userDAO.findByUniqueFacebookID(data.getString("facebookID"));
				if(users.size() == 1){
					resp.put("userID", users.get(0).getId());
					resp.put("response", "ok");
				}else{
					resp.put("response", "no user found or multiple users with same credentials");
				}
				
				
			}else{
				resp.put("response", "missing data");
			}
			
			utx.commit();
			response.setCharacterEncoding("UTF-8");
			response.getOutputStream().write(resp.toString().getBytes());
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
