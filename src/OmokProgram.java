import java.util.Scanner;

public class OmokProgram {

	public static void main(String[] args) {
		
		Scanner scan= new Scanner(System.in);
						
		for(int y=0;y<20;y++){
			for(int x=0;x<20;x++)
				if(y==0)
					if(x==0)
						System.out.print("┏");
					else if(x==19)
						System.out.print("┓");
					else
						System.out.print("┳");
				else if(y==19)
					if(x==0)
						System.out.print("┗");
					else if(x==19)
						System.out.print("┛");
					else
						System.out.print("┻");
				else
					if(x==0)
						System.out.print("┣");
					else if(x==19)
						System.out.print("┫");
					else
						System.out.print("╋");

			System.out.println();
		}
		
		//사용자에게 오목 좌표 하나를 입력 받는다.
		// 오목판 출력
		int map_x=0;
		int map_y=0;
		System.out.print("좌표 입력(x y): ");
		map_x=scan.nextInt();
		map_y=scan.nextInt();
		while(map_x<1||map_y<1||map_x>20||map_y>20){
			System.out.print("다시 입력(x y): ");
			map_x=scan.nextInt();
			map_y=scan.nextInt();
		}
		
		
		for(int y=0;y<20;y++){
			for(int x=0;x<20;x++)
				if(x==map_x-1 && y==map_y-1)
					System.out.print("●");
				else if(y==0)
					if(x==0)
						System.out.print("┏");
					else if(x==19)
						System.out.print("┓");
					else
						System.out.print("┳");
				else if(y==19)
					if(x==0)
						System.out.print("┗");
					else if(x==19)
						System.out.print("┛");
					else
						System.out.print("┻");
				else
					if(x==0)
						System.out.print("┣");
					else if(x==19)
						System.out.print("┫");
					else
						System.out.print("╋");

			System.out.println();
		}
		
	}
}
