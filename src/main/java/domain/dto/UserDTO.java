package domain.dto;

import java.io.Serializable;
import java.util.Date;


public class UserDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String surname;
	private String username;
	private Long numberOfReviews;
	private Long numberOfCheckins;
	private String login;
	private String facebookID;
	private String status;
	private String photoUrl;
	private Long lastLoginDate;
	private String password;
	private String email;
	private String version;
	private String androidGcmToken;

	public String getAndroidGcmToken() {
		return androidGcmToken;
	}
	public void setAndroidGcmToken(String androidGcmToken) {
		this.androidGcmToken = androidGcmToken;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Long lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFacebookID() {
		return facebookID;
	}
	public void setFacebookID(String facebookID) {
		this.facebookID = facebookID;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Long getNumberOfCheckins() {
		return numberOfCheckins;
	}
	public void setNumberOfCheckins(Long numberOfCheckins) {
		this.numberOfCheckins = numberOfCheckins;
	}
	public Long getNumberOfReviews() {
		return numberOfReviews;
	}
	public void setNumberOfReviews(Long numberOfReviews) {
		this.numberOfReviews = numberOfReviews;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	

}
