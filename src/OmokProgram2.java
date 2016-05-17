import java.util.Scanner;

public class OmokProgram2 {

	public static void main(String[] args) {
		
		Scanner scan= new Scanner(System.in);

		int width=20;
		int height=20;
		char[] board = new char[width*height];
		
		for(int i=0; i<400;i++)
			board[i]='╋';
		
		//좌표를 이용한 테두리 두기
		board[width*0+0]='┏';
		board[width*0+19]='┓';
		board[width*19+0]='┗';
		board[width*19+19]='┛';
		
		board[width*(3-1)+(3-1)]='●';
		
		for(int y=0; y<height;y++){
			for(int x=0; x<width;x++)
				System.out.printf("%c", board[x+y*width]);
			System.out.println();
		}
		
	}
}
