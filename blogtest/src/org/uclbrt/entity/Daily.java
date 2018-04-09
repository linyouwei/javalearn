package org.uclbrt.entity;

import java.io.Serializable;
import java.util.Date;

public class Daily {
	private int id;
	private String title;
	private String body;
	private Date createdTime;
	private Date modifiedTime;
	private int categoryId;
	private int click;
	private UserLogin userinfo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getClick() {
		return click;
	}
	public void setClick(int click) {
		this.click = click;
	}
	public UserLogin getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(UserLogin userinfo) {
		this.userinfo = userinfo;
	}
}
