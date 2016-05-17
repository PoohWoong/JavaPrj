package com.woong.collection.object;

public class ObjectCollection {
	private Object[] data;// = new Exam[10];
	private int current;//=-1;
	private int capacity;
	private int amount;
	
	
	public ObjectCollection() {
		capacity=3;
		amount=5;
		data=new Object[capacity];
		current=-1;
	}
	
	public int size() {
		
		return current+1;
	}

	public Object get(int i) {
		return data[i];
	}

	public void add(Object obj) {
		//���� ������ ���ڶ��
		current++;
		if(capacity<=current){
			//������ �÷��ش�.
			capacity+=amount;
			Object[] tmp= new Object[capacity];
			for(int i=0;i<current;i++)
				tmp[i]=data[i];
			data=tmp;			
		}
		
		data[current] = obj;		
	}
	
	
	
}
