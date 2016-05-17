package com.woong.sist.seat;

import java.io.FileNotFoundException;

public class Program {

	public static void main(String[] args) throws FileNotFoundException {
		Group[] groups= new Group[5];
		Member[] students= new Member[25];
		
		for(int i=0;i<25;i++){
			Member member=new Member();
			member.input(2,i);
			students[i]=member;
		}
		
		for(int i=0;i<25;i++){
			students[i].print();
		}
	}

}
