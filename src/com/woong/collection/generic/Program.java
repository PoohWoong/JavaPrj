package com.woong.collection.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Program {

	public static void main(String[] args){
		
		List<Integer> list=new ArrayList<>();
		
		
		
		for(int i=0; i<100; i++)
			list.add(i+1);
	
		
		Thread th= new Thread(new Runnable() {
			
			@Override
			public void run() {
				print(2, list);
			}
		});
		
		th.start();
		print(1, list);
//		print(2, list);
		
		/*while(list.hasNext())
			System.out.println(list.next());*/				
	}
	

	private static void print(int key, List<Integer> list){
		Iterator it= list.iterator();
		while(it.hasNext())
			System.out.printf("Key : %d, Value : %d\n",key, it.next());
	}

}
