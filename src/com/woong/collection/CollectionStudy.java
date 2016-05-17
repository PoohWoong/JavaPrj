package com.woong.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CollectionStudy {

	public static void main(String[] args) {
		
		System.out.println("--------------<List>---------");
		List<String> list = new ArrayList<>();
		list.add("Hello");
		list.add("OK");
		list.add("Hello");
		list.add("OK");
			
		for(String s : list)
			System.out.println(s);
		
		System.out.println("--------------<Set>---------");
		Set<String> sets = new TreeSet<>();
		sets.add("6341");
		sets.add("24553");
		sets.add("645");
		sets.add("436346");
		
		for(String s : sets)
			System.out.println(s);
		System.out.println("--------------<Map>---------");
		Map<String, String> m = new HashMap<>();
		m.put("name", "홍길동");
		m.put("addr", "서울시 마포구");
		m.put("name", "김길동");
		
		System.out.println(m.get("name"));
		
		System.out.println("--------------<종합>---------");
		System.out.println(list);
		System.out.println(sets);
		
		System.out.println(m);
		
	}

}