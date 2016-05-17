package com.woong.collection.generic;

public class GCollection<T> {
	private T[] data;		// = new Exam[10];
	private int current;	// =-1;
	private int capacity;	// 용량
	private int amount;	// 추가 증가량
	
	public class Iterator{
		private int index;
		
		public Iterator() {
			index=-1;
		}
		
		public boolean hasNext() {
			return index < current;
		}

		public T next() {
			return data[++index];		
		}

		public void clear() {
			index=-1;		
		}
	}
	
	public Iterator iterator(){
		return new Iterator();
	}
	
	
	public GCollection() {
		capacity=3;
		amount=5;
		data=(T[])new Object[capacity];
		current=-1;
	}
	
	public int size() {
		
		return current+1;
	}

	public T get(int i) {
		return data[i];
	}

	public void add(T obj) {
		//만약 공간이 모자라면
		current++;
		if(capacity<=current){
			//공간을 늘려준다.
			capacity+=amount;
			T[] tmp= (T[])new Object[capacity];
			for(int i=0;i<current;i++)
				tmp[i]=data[i];
			data=tmp;			
		}
		
		data[current] = obj;		
	}	
}
