package domain.services;

import antlr.collections.List;
import domain.dto.Users;
import domain.generic.HiberCritiria;

public class Test {

	
	
	
	
	public static void main(String[] args) {
		
		
		
		java.util.List list  =  HiberCritiria.findByUserName("Nikos");
		 
		for (java.util.Iterator iterator = list.iterator(); iterator.hasNext();){
	            Users user = (Users) iterator.next(); 
	            System.out.print("First Name: " + user.getUsername()); 
	            System.out.print("Last Name: " + user.getPassword());
	            System.out.println("ID: " + user.getId()); 
	         }
		
		
	}
}
