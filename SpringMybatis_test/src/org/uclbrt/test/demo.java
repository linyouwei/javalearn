package org.uclbrt.test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class demo {
	static String sql = null;  
    static testConnectionMysql db1 = null;  
    static ResultSet ret = null;  

	public static void main(String[] args) {
		sql = "select * from USER_LOGIN";//SQL语句  
        db1 = new testConnectionMysql(sql);//创建DBHelper对象  
        try {  
            ret = db1.pst.executeQuery();//执行语句，得到结果集  
            while (ret.next()) {  
                String uid = ret.getString(1);  
                String ufname = ret.getString(2);  
                String ulname = ret.getString(3);  
                String udate = ret.getString(4); 
                String ROLE_ID = ret.getString(5); 
                System.out.println(uid + "\t" + ufname + "\t" + ulname + "\t" + udate+"\t" +ROLE_ID );  
            }//显示数据  
            ret.close();  
            db1.close();//关闭连接  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  

	}
