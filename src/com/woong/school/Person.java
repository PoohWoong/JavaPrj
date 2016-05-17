package com.woong.school;

import java.util.Scanner;

public abstract class Person {
	private String name;
	private String tel;
	private String email;
	
	protected void input(){
		Scanner scan=new Scanner(System.in);
		System.out.print("�̸� : ");
		name=scan.next();
		System.out.print("��ȭ��ȣ : ");
		scan.nextLine();
		tel=scan.nextLine();
		System.out.print("�̸��� : ");
		email=scan.next();		
	}
	
	protected void print(){
		System.out.println("�̸� : " + name);
		onPrint();
		System.out.println("��ȭ��ȣ : " + tel);
		System.out.println("�̸��� : " + email);
	}
	
	protected abstract void onPrint();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}