package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uclbrt.entity.Daily;
import org.uclbrt.util.EmptyUtil;

public class test {
	public static void main(String[] args) {
		List list = new ArrayList<String>();
		System.out.println(list);
		if(EmptyUtil.isNullOrEmpty(list)){
			System.out.println(44);
		}else{
			System.out.println(333);
		}
		
	}

}