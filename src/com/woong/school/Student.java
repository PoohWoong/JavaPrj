package com.woong.school;

import java.util.Scanner;

public class Student extends Person{
	private int studentId;
	private int rank;
		
	@Override
	public void input(){
		Scanner scan=new Scanner(System.in);
		super.input();
		System.out.print("�й� : ");
		studentId=scan.nextInt();
		System.out.print("���� : ");
		rank=scan.nextInt();
	}

	@Override
	protected void onPrint() {
		System.out.println("�й� : " + studentId);
		System.out.println("���� : " + rank);
		
	}

}