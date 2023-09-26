package com.smart.entites;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String role;
	private String password;
	@Column(unique = true)
	private String email;
	private boolean activeUser;
	private String imageUrl;
	@Column(length=500)
	private String aboutUser;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
	private List<Contact>li=new ArrayList<>();
	
	public List<Contact> getLi() {
		return li;
	}
	public void setLi(List<Contact> li) {
		this.li = li;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isActiveUser() {
		return activeUser;
	}
	public void setActiveUser(boolean activeUser) {
		this.activeUser = activeUser;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getAboutUser() {
		return aboutUser;
	}
	public void setAboutUser(String aboutUser) {
		this.aboutUser = aboutUser;
	}
	
	
	
}
