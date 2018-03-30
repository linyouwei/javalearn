package org.uclbrt.entity;

import java.io.Serializable;
import java.util.Date;

public class UserLogin implements Serializable {

	private static final long serialVersionUID = 1393438783592387512L;
	private int id;
	private String username;
	private String password;
	private Date create_time;
	private int role_id;
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
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date d) {
		this.create_time = d;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
