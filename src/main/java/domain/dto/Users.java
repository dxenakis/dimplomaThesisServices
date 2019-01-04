package domain.dto;

import java.io.Serializable;

public class Users {

    private int id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String address;
    private String telephone;
    
    public Users() {
    }
    public Users(int id, String username, String password, String name, String email, String address,String telephone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.name = name;
        this.email = email;
        this.address = address;
        this.telephone = telephone;
    }
    
	public Users(String username, String password,String name, String email, String address, String telephone) {
    	this.username = username;
        this.password = password;
    	this.name = name;
        this.email = email;
        this.address = address;
        this.telephone = telephone;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    
    
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}