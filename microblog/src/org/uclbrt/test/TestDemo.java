package org.uclbrt.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Map> list = new ArrayList<Map>();
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(1,"123");
		list.add(map);
		System.out.println(list);
	}

}
