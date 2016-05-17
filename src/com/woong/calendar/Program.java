package com.woong.calendar;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		NewCalendar calendar=new NewCalendar();
		calendar.print();
		
		Scanner scan=new Scanner(System.in);
		boolean loop=true;
		while(loop){
			System.out.println("1. 입력 년 월의 달력");
			System.out.println("2. 입력 년 월 일의 달력");
			System.out.println("3. 종료");
			System.out.print("메뉴 : > ");
			switch(scan.nextInt()){
			case 1:
				submenu1();
				break;
			case 2:
				submenu2();
				break;
			case 3:
				loop=quit();
				break;
			}
		}
	}

	private static void submenu1() {
		Scanner scan=new Scanner(System.in);
		System.out.print("년 월 입력 (yyyy sp mm)");
		int year =scan.nextInt();
		int month=scan.nextInt();
		
		NewCalendar cal=new NewCalendar(year, month);
		cal.print();
	}

	private static void submenu2() {
		Scanner scan=new Scanner(System.in);
		System.out.print("년 월 일 입력 (yyyy sp mm sp dd)");
		int year =scan.nextInt();
		int month=scan.nextInt();
		int date=scan.nextInt();
		
		NewCalendar cal=new NewCalendar(year, month, date);
		cal.print();
	}

	private static boolean quit() {
		System.out.println("바이바이");
		return false;
	}

}
