package com.woong.app.omok;

public class Board {
	private int width;
	private int height;
	private char[][] buf;
	private Stone[] stones;
	private int count;
	
	public Board(){
		width = 21;
		height= 21;
		count=0;
		buf = new char[height][width];
		stones = new Stone[width*height];				
	}
	
	
	private void putStone(Stone stone){
		buf[stone.getY()][stone.getX()] =stone.getType()==2?'¡Û':'¡Ü';				
	}
	
	public void add(Stone stone) {
		stones[count]=stone;
		//stones[count].setType(count%2+1);
		Stone.toggleTurn();
		count++;
		
	}

	public void print(){
		initBoard();
		for(int i=0; i<count;i++)
			putStone(stones[i]);
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++)
				System.out.printf("%c", buf[y][x]);
			System.out.println();
		}		
	}
	
	private void initBoard(){
		for (int j = 0; j < height; j++)
			for (int i = 0; i < width; i++)
				buf[j][i] = '¦«';
		for (int i = 0; i < width; i++) {
			buf[0][i] = '¦¨';
			buf[height - 1][i] = '¦ª';
		}
		for (int i = 0; i < height; i++) {
			buf[i][0] = '¦§';
			buf[i][width - 1] = '¦©';
		}
		buf[0][0] = '¦£';
		buf[0][width - 1] = '¦¤';
		buf[height - 1][0] = '¦¦';
		buf[height - 1][width - 1] = '¦¥';
		buf[height / 2][width / 2] = '¦¶';
	}	

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public char[][] getBuf() {
		return buf;
	}
	public void setBuf(char[][] buf) {
		this.buf = buf;
	}
	public Stone[] getStone() {
		return stones;
	}
	public void setStone(Stone[] stone) {
		this.stones = stone;
	}

	public boolean checkDuplicated(Stone stone) {
		for(int i=0;i<count;i++)
			if(stones[i].getX()==stone.getX()&&stones[i].getY()==stone.getY())
				return true;
		return false;
	}
}