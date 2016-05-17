package com.woong.school;

import java.util.Scanner;

public class Student extends Person{
	private int studentId;
	private int rank;
		
	@Override
	public void input(){
		Scanner scan=new Scanner(System.in);
		super.input();
		System.out.print("학번 : ");
		studentId=scan.nextInt();
		System.out.print("석차 : ");
		rank=scan.nextInt();
	}

	@Override
	protected void onPrint() {
		System.out.println("학번 : " + studentId);
		System.out.println("석차 : " + rank);
		
	}

}