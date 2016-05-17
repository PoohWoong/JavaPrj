package com.woong.app.omok;

import java.util.Scanner;

public class Stone {
	private int x;
	private int y;
	private int type;
	private static boolean isWhiteTurn;
	
	public Stone(){
		x=-1;
		y=-1;
		type=1;
	}
	static{
		isWhiteTurn=false;
	}
		
	public void input(){
		Scanner scan = new Scanner(System.in);
		type=isWhiteTurn?2:1;
		System.out.printf("%s돌 오목 두기 (x sp y): ",  type == 1 ? "흑" : "백");
		x = scan.nextInt()-1;
		y = scan.nextInt()-1;						
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	public static void toggleTurn() {
		isWhiteTurn=!isWhiteTurn;		
	}
}
