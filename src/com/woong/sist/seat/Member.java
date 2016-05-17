package com.woong.sist.seat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Member {
	private String name;
	private String grade;
	private String gender;
	private int[] groupRecord= new int[5];
	private int currentGroup;
	private int nextGroup;
	
	public void input(int count, int number) throws FileNotFoundException {
		FileInputStream fis= new FileInputStream("res/namelist.txt");
		Scanner scan= new Scanner(fis);
		for(int i=0;i<number;i++)
			scan.nextLine();
		name=scan.next();
		grade=scan.next();
		gender=scan.next();
		for(int i=0;i<count;i++)
			groupRecord[i]=scan.nextInt();		
	}

	public void print() {
		System.out.printf("%s\t%s\t%s\t%d %d %d %d %d\n",name, gender, grade, groupRecord[0],groupRecord[1],groupRecord[2],groupRecord[3],groupRecord[4]);
	}

}