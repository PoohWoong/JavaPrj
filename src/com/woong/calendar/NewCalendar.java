package com.woong.calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class NewCalendar extends GregorianCalendar{
	
	private int month;
	private int lastdate;
	private int firstdayofweek;
	private int year;
	private int date;
	
	public NewCalendar() {
		super();
		year=this.get(Calendar.YEAR);
		month=this.get(Calendar.MONTH)+1;
		date=this.get(Calendar.DATE);
		this.setter();
	}
	
	public NewCalendar(int year, int month, int date){
		super(year, month-1,date);
		this.year=year;
		this.month=month;
		this.date=date;
		this.setter();
	}
	
	public NewCalendar(int year, int month) {
		this(year,month,1);
		this.date=0;	
	}

	public void setter(){
		lastdate=this.getActualMaximum(Calendar.DATE);
		firstdayofweek=(this.get(Calendar.DAY_OF_WEEK)-(this.get(Calendar.DATE)%7)+1)%7;
/*		System.out.println(this.get(Calendar.DAY_OF_WEEK));
		System.out.println(this.get(Calendar.DATE)%7);
		System.out.println(firstdayofweek);*/
		
		if(firstdayofweek<=0)
			firstdayofweek+=7;
	}
	

	public void print() {
		System.out.printf("\t%d³â %2d¿ù\n", year, month);
		System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
		for(int i=1; i<firstdayofweek;i++)
			System.out.printf(" \t");
		for(int i=1, j=firstdayofweek;i<=lastdate;i++,j++){
			if(i==date)
				System.out.printf("[%d]", i);
			else
				System.out.printf("%3d", i);
			
			if(j%7==0){
				System.out.println();
				j=0;
			}
			else
				System.out.printf("\t");
		}
		System.out.println();
	}
}
