package com.woong.omok;

import java.util.Scanner;

public class OmokGame {
	private int count;
	private boolean win;
	private int width ;
	private int height ;

	private char[][] board;
	private OmokStone[] stone;
	
	public OmokGame() {
		this(10, 10);
	}
	
	//생성자. 입력받은 값에 따라 오목판 생성
	public OmokGame(int height, int width){
		this.width=width;
		this.height=height;
		this.initBoard();
		count=0;
		win=false;
	}
	

	public void setCount(int count){
		this.count=count;
	}
	public void setWidth(int width){
		this.width = width;
	}
	public void setHeight(int height){
		this.height = height;
	}
	public void setWin(boolean win){
		this.win = win;
	}
	public int getCount(){
		return count;
	}	
	public boolean getWin(){
		return win;
	}
	
	//돌 입력받는 함수
	public void input(){
		Scanner scan = new Scanner(System.in);
		int mapx;
		int mapy;
		OmokStone stone= new OmokStone();

		stone.setType(count % 2 + 1);

		// 사용자 입력을 받는 로직
		while(true){
			System.out.printf("턴 %d. %s돌 오목 두기 (x sp y): ", count + 1, stone.getType() == 1 ? "흑" : "백");
			mapx = scan.nextInt();
			mapy = scan.nextInt();
			stone.setX(mapx-1);
			stone.setY(mapy-1);
			
			this.stone[count]=stone;
			
			//범위 유효성 검사
			if(1<=mapx && mapx <= width && 1<= mapy && mapy <= height)
				//기존에 돌이 없는지 검사
				if(!(board[mapy - 1][mapx - 1] == '●' || board[mapy - 1][mapx - 1] == '○')){	
					board[mapy - 1][mapx - 1] = stone.getType()==2?'○':'●';
					break;
				}
		
		}
	}
	
	
	// 좌표를 이용한 테두리 두기
	public void initBoard(){
		board=new char[height][width];
		for (int j = 0; j < height; j++)
			for (int i = 0; i < width; i++)
				board[j][i] = '┼';
		for (int i = 0; i < width; i++) {
			board[0][i] = '┬';
			board[height - 1][i] = '┴';
		}
		for (int i = 0; i < height; i++) {
			board[i][0] = '├';
			board[i][width - 1] = '┤';
		}
		board[0][0] = '┌';
		board[0][width - 1] = '┐';
		board[height - 1][0] = '└';
		board[height - 1][width - 1] = '┘';
		board[height / 2][width / 2] = '╋';
		
		stone= new OmokStone[width*height];
	}
	
	// 승패검사 함수
	public void winnerCheck(int pmx, int pmy) {
		
		int chker = 0;
		int mx = stone[count].getX();
		int my = stone[count].getY();
		if (pmy != -1)
			for (int x = mx - pmx * 4, y = my - pmy * 4; x <= mx + pmx * 3 && y <= my + pmy * 3; x += pmx, y += pmy) {
				if (x < 0 || y < 0)
					continue;
				else if (x >= width - 1 || y >= height - 1)
					break;
				if (board[y][x] == board[y + pmy][x + pmx])
					chker++;
				else
					chker = 0;
				if (chker == 4) {
					System.out.printf("게임끝! %s 승리!\n", board[my][mx] == '●' ? "흑" : "백");
					break;
				}
			}
		else
			for (int x = mx - pmx * 4, y = my - pmy * 4; x <= mx + pmx * 3 && y >= my + pmy * 3; x += pmx, y += pmy) {
				if (x < 0 || y > height - 1)
					continue;
				else if (x >= width - 1 || y <= 0)
					break;
				if (board[y][x] == board[y + pmy][x + pmx])
					chker++;
				else
					chker = 0;
				if (chker == 4) {
					System.out.printf("게임끝! %s 승리!\n", board[my][mx] == '●' ? "흑" : "백");
					break;
				}
			}
		if (chker == 4)
			win = true;
	}

	public void print() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++)
				System.out.printf("%c", board[y][x]);
			System.out.println();
		}
	}
}
