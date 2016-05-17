import java.util.Scanner;

public class OmokProgram3 {

	public static void main(String[] args) {
		
		Scanner scan= new Scanner(System.in);

		int width=21;
		int height=21;
		char[][] board = new char[height][width];
		int[] omokXs = new int[400];
		int[] omokYs = new int[400];
		int[] types = new int[400];
		
		//좌표를 이용한 테두리 두기
		for(int j=0;j<height;j++)
			for(int i=0; i<width;i++)
				board[j][i]='┼';
		
		for(int i=0;i<width;i++)
		{
			board[0][i]='┬';
			board[height-1][i]='┴';			
		}
		for(int i=0;i<height;i++)
		{
			board[i][0]='├';
			board[i][width-1]='┤';
		}
				
		board[0][0]='┌';
		board[0][width-1]='┐';
		board[height-1][0]='└';
		board[height-1][width-1]='┘';
		
		//사용자 입력을 받는 로직
		int mapx;
		int mapy;
		int type;
		int count=0;
		
		mapx=5;
		mapy=7;
		type=1;
		
		omokXs[count]=mapx;
		omokYs[count]=mapy;
		types[count]=type;
		count++;
	
		
		for(int i=0;i<count;i++)
			board[omokYs[i]-1][omokXs[i]-1]='○';
		//
		
		for(int y=0; y<height;y++){
			for(int x=0; x<width;x++)
				System.out.printf("%c", board[y][x]);
			System.out.println();
		}
		
	}
}
