package org.uclbrt.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment {
	private int id;
	private String content;
	private Date createdTime;
	private Daily dailyInfo;
	private UserLogin userInfo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Daily getDailyinfo() {
		return dailyinfo;
	}
	public void setDailyinfo(Daily dailyinfo) {
		this.dailyinfo = dailyinfo;
	}
	public UserLogin getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(UserLogin userinfo) {
		this.userinfo = userinfo;
	}
}
