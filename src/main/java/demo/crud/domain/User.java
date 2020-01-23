package demo.crud.domain;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7936592771311949566L;
	private long id;
	private String name;
	private String email;
	private char gender;
	private String address;	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	
	public char getGender() {
		return gender;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
}
