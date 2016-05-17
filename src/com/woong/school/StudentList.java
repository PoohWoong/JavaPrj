package com.woong.school;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StudentList {
	private List<Student> list;
	
	public StudentList() {
		list=new LinkedList<Student>();
	}
	
	public static void submenu(StudentList students){
		Scanner scan= new Scanner(System.in);
		boolean loop=true;
		while(loop){
			System.out.println("1. 목록 출력");
			System.out.println("2. 학생 추가");
			System.out.println("3. 학생 삭제");
			System.out.println("4. 상위 메뉴");
			switch(scan.nextInt()){
			case 1:
				for(int i=0;i<students.list.size();i++){
					students.list.get(i).print();
					System.out.println();
				}
				break;
			case 2:
				Student student = new Student();
				student.input();
				students.list.add(student);
				break;
			case 3:
				remove(students.list);
				break;
			case 4:
				loop=false;
				break;
			}
		}
	}
	
	private static void remove(List<Student> list){
		Scanner scan= new Scanner(System.in);
		String name;
		System.out.print("이름 입력: ");
		name=scan.next();
		
		int count=0;
		for(int i=0;i<list.size();i++)
			if(list.get(i).getName().compareTo(name)==0){
				count=i;
				break;
			}
		list.remove(count);
		
	}

}
