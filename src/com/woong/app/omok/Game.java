package com.woong.app.omok;

public class Game {

	public static void main(String[] args) {
		
		Board board =new Board();
		
		while(true){		
			board.print();
			Stone stone = new Stone();
			stone.input();
			
			boolean duplicated = board.checkDuplicated(stone);
		
			if(duplicated)
				printError();
			else
				board.add(stone);
			
		}
	}

	private static void printError() {
		System.out.println("Áßº¹µÈ ÁÂÇ¥!!!!");
	}
}
