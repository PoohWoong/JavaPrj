package com.woong.exceptionlib;

public class Calculator {
	public static int add(int x, int y){
		int result = x+y;
		return result;
	}
	
	public static int sub(int x, int y){
		int result = x-y;
		return result;
	}
	
	public static int multi(int x, int y){
		int result = x*y;
		return result;
	}
	
	public static int div(int x, int y) throws DivideByZero, OutOfBound{
		if(y==0)
			throw new DivideByZero();
		
		if(x<0 || x>100)
			throw new OutOfBound();
		
		int result = x/y;
		return result;
	}
}
