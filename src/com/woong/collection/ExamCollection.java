package com.woong.collection;

import org.omg.CORBA.FREE_MEM;

public class ExamCollection {
	private Exam[] exams;// = new Exam[10];
	private int current;//=-1;
	private int capacity;
	private int amount;
	
	
	public ExamCollection() {
		capacity=3;
		amount=5;
		exams=new Exam[capacity];
		current=-1;
	}
	
	public int size() {
		
		return current+1;
	}

	public Exam get(int i) {
		return exams[i];
	}

	public void add(Exam exam) {
		//만약 공간이 모자라면
		current++;
		if(capacity<=current){
			//공간을 늘려준다.
			capacity+=amount;
			Exam[] tmp= new Exam[capacity];
			for(int i=0;i<current;i++)
				tmp[i]=exams[i];
			exams=tmp;			
		}
		
		exams[current] = exam;		
	}
	
	
	
}
