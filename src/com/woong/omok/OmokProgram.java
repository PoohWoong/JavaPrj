package com.woong.omok;

/* ����6
 * ���� ���α׷��� ����ȭ * 
 */

public class OmokProgram {
	
	final static int width=21;// �ٵ����� ũ��
	final static int height=21;// �ٵ����� ��������� �Ǿ�� �Ѵ�.

	public static void main(String[] args) {
		
		OmokGame game=new OmokGame(width, height);
		
		game.initBoard();
		
		// �ٵ��� ���
		game.print();		

		while (game.getCount() < width * height && game.getWin()==false) {
			
			int count=game.getCount();
		
			game.input();

			// �ٵ��� ���
			game.print();
			// ���а˻� - ������ ���� �������� ��4 �������� �˻��ϴ� ���.

			game.winnerCheck(1, 0);
			game.winnerCheck(0, 1);
			game.winnerCheck(1, 1);
			game.winnerCheck(1, -1);
			
			count++;
			game.setCount(count);
			if (game.getCount() == height * width) // ���� �ٵ����� �� ä�������� ���º�
				System.out.println("���� ��! ���º�!");
		}

	}
	
}
