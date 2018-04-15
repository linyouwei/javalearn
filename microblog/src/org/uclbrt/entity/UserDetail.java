package org.uclbrt.entity;

import java.io.Serializable;
import java.util.Date;

public class UserDetail implements Serializable {

	private int id;
	private UserLogin userInfo;
	private int gender ;
	private Date birthday;
	private Province province;
	private City city;
	private int marriage;
	
	

	
}
