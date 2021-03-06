package org.uclbrt.util;
/**
 * 系统常量接口
 * @author Administrator
 *
 */
public interface SystemConstant {
	
	//笔记本类型ID
	String NOTEBOOK_TYPE_ID_FAVORITES = "1";//收藏
	String NOTEBOOK_TYPE_ID_RECYCLE = "2";//
	String NOTEBOOK_TYPE_ID_ACTION = "3";
	String NOTEBOOK_TYPE_ID_PUSH ="4";
	String NOTEBOOK_TYPE_ID_NORMAL= "5";//普通
	
	//笔记本类型名
	String NOTEBOOK_TYPE_NAME_FAVORITES = "收藏";
	String NOTEBOOK_TYPE_NAME_RECYCLE = "回收";
	String NOTEBOOK_TYPE_NAME_ACTION = "活动";
	String NOTEBOOK_TYPE_NAME_PUSH = "推送";
	String NOTEBOOK_TYPE_NAME_NORMAL = "普通";
	//成功进入edit.html
	int SUCCESS = 0;
	//名字错误
	int NAME_ERROR = 1;
	//密码错误
	int PASSWORD_ERROR = 2;
	//修改密码页面的密码错误
	int ORIGINAL_PASSWORD_ERROR = 3;
	//成功进行修改密码
	int CHANGESUCCESS = 4;
	
	//搜索显示页面的行数
	int PAGE_SIZE = 5;

	
}
