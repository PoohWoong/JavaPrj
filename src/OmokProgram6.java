
/* 오목6
 * 오목 프로그램의 구조화 * 
 */

import java.util.Scanner;


public class OmokProgram6 {
	
	final static int width=21;
	final static int height=21;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		//int width = 21; // 바둑판의 크기
		//	int height = width; // 바둑판은 정방행렬이 되어야 한다.
		char[][] board = new char[height][width]; // 바둑판 배열
		int[] omokXs = new int[height * width];
		int[] omokYs = new int[height * width];
		int[] types = new int[height * width];
		boolean win=false;

		// 좌표를 이용한 테두리 두기
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

		int mapx;
		int mapy;
		int type;
		int count = 0;

		// 바둑판 출력
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++)
				System.out.printf("%c", board[y][x]);
			System.out.println();
		}

		좌표시작:
		while (count < width * height && win==false) {

			type = count % 2 + 1;

			// 사용자 입력을 받는 로직
			System.out.printf("턴 %d. %s돌 오목 두기 (x sp y): ", count + 1, type == 1 ? "흑" : "백");
			mapx = scan.nextInt();
			mapy = scan.nextInt();
			// 범위 유효성 검사
			if (mapx < 1 || mapx > width || mapy < 1 || mapy > height)
				continue 좌표시작;
			// 중복검사
			if (board[mapy - 1][mapx - 1] == '●' || board[mapy - 1][mapx - 1] == '○')
				continue;
			// 입력받은 좌표를 가지고 board배열 자체를 체크하는 방식.

			omokXs[count] = mapx;
			omokYs[count] = mapy;
			types[count] = type;

			if (type == 2)
				board[omokYs[count] - 1][omokXs[count] - 1] = '○';
			else
				board[omokYs[count] - 1][omokXs[count] - 1] = '●';

			// 바둑판 출력
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++)
					System.out.printf("%c", board[y][x]);
				System.out.println();
			}
			// 승패검사 - 놓아진 돌을 기준으로 ±4 기준으로 검사하는 방식.
			int mx = mapx - 1;
			int my = mapy - 1;
			int cnt = 0;

			win=winnerCheck(board, mx, my, 1, 0);
			win=winnerCheck(board, mx, my, 0, 1);
			win=winnerCheck(board, mx, my, 1, 1);
			

			// ↙ 대각선 검사
			for (int x = mx - 4, y = my + 4; x < mx + 4 && y > my - 4; x++, y--) {
				if (x < 0 || y > height - 1)
					continue;
				else if (x >= width - 1 || y <= 0)
					break;
				if (board[y][x] == board[y - 1][x + 1] && (board[y][x] == '●' || board[y][x] == '○'))
					cnt++;
				else
					cnt = 0;
				if (cnt == 4) {
					System.out.printf("게임끝! %s 승리!\n", board[my][mx] == '●' ? "흑" : "백");
					break 좌표시작;
				}
			}

			count++;
			if (count == height * width) // 만약 바둑판을 다 채워버리면 무승부
				System.out.println("게임 끝! 무승부!");
		}

	}
	
	//승패검사 함수
	public static boolean winnerCheck(char[][] board, int mx, int my, int pmx, int pmy)
	{
		int cnt=0;
		for (int x = mx - pmx*4, y = my - pmy*4; x <= mx + pmx*3 && y <= my + pmy*3; x+=pmx, y+=pmy) {
			if (x < 0 || y < 0)
				continue;
			else if (x >= width - 1 || y >= height - 1)
				break;
			if (board[y][x] == board[y + pmy][x + pmx] && (board[y][x] == '●' || board[y][x] == '○'))
				cnt++;
			else
				cnt = 0;
			if (cnt == 4) {
				System.out.printf("게임끝! %s 승리!\n", board[my][mx] == '●' ? "흑" : "백");
				break;				
			}
		}
		if(cnt==4)
			return true;
		else
			return false;
	}
}
