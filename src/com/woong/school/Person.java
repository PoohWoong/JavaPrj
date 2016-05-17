package com.woong.school;

import java.util.Scanner;

public abstract class Person {
	private String name;
	private String tel;
	private String email;
	
	protected void input(){
		Scanner scan=new Scanner(System.in);
		System.out.print("이름 : ");
		name=scan.next();
		System.out.print("전화번호 : ");
		scan.nextLine();
		tel=scan.nextLine();
		System.out.print("이메일 : ");
		email=scan.next();		
	}
	
	protected void print(){
		System.out.println("이름 : " + name);
		onPrint();
		System.out.println("전화번호 : " + tel);
		System.out.println("이메일 : " + email);
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