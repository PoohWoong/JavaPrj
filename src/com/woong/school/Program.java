package com.woong.school;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		boolean loop=true;
		StudentList students=new StudentList();
		
		while(loop){
			switch(menu()){
			case 1:
				StudentList.submenu(students);
				break;
			case 2:
				break;
			case 3:
				loop=exit();
				break;			
			}
		}

	}

	private static boolean exit() {
		System.out.println("Bye!");
		return false;
	}

	private static int menu() {
		Scanner scan= new Scanner(System.in);
			System.out.println("1. �л�����");
			System.out.println("2. �������");
			System.out.println("3. ����");
			return scan.nextInt();
	}

}
