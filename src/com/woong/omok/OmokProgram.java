package com.woong.omok;

/* 오목6
 * 오목 프로그램의 구조화 * 
 */

public class OmokProgram {
	
	final static int width=21;// 바둑판의 크기
	final static int height=21;// 바둑판은 정방행렬이 되어야 한다.

	public static void main(String[] args) {
		
		OmokGame game=new OmokGame(width, height);
		
		game.initBoard();
		
		// 바둑판 출력
		game.print();		

		while (game.getCount() < width * height && game.getWin()==false) {
			
			int count=game.getCount();
		
			game.input();

			// 바둑판 출력
			game.print();
			// 승패검사 - 놓아진 돌을 기준으로 ±4 기준으로 검사하는 방식.

			game.winnerCheck(1, 0);
			game.winnerCheck(0, 1);
			game.winnerCheck(1, 1);
			game.winnerCheck(1, -1);
			
			count++;
			game.setCount(count);
			if (game.getCount() == height * width) // 만약 바둑판을 다 채워버리면 무승부
				System.out.println("게임 끝! 무승부!");
		}

	}
	
}
