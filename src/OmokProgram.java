import java.util.Scanner;

public class OmokProgram {

	public static void main(String[] args) {
		
		Scanner scan= new Scanner(System.in);
						
		for(int y=0;y<20;y++){
			for(int x=0;x<20;x++)
				if(y==0)
					if(x==0)
						System.out.print("��");
					else if(x==19)
						System.out.print("��");
					else
						System.out.print("��");
				else if(y==19)
					if(x==0)
						System.out.print("��");
					else if(x==19)
						System.out.print("��");
					else
						System.out.print("��");
				else
					if(x==0)
						System.out.print("��");
					else if(x==19)
						System.out.print("��");
					else
						System.out.print("��");

			System.out.println();
		}
		
		//����ڿ��� ���� ��ǥ �ϳ��� �Է� �޴´�.
		// ������ ���
		int map_x=0;
		int map_y=0;
		System.out.print("��ǥ �Է�(x y): ");
		map_x=scan.nextInt();
		map_y=scan.nextInt();
		while(map_x<1||map_y<1||map_x>20||map_y>20){
			System.out.print("�ٽ� �Է�(x y): ");
			map_x=scan.nextInt();
			map_y=scan.nextInt();
		}
		
		
		for(int y=0;y<20;y++){
			for(int x=0;x<20;x++)
				if(x==map_x-1 && y==map_y-1)
					System.out.print("��");
				else if(y==0)
					if(x==0)
						System.out.print("��");
					else if(x==19)
						System.out.print("��");
					else
						System.out.print("��");
				else if(y==19)
					if(x==0)
						System.out.print("��");
					else if(x==19)
						System.out.print("��");
					else
						System.out.print("��");
				else
					if(x==0)
						System.out.print("��");
					else if(x==19)
						System.out.print("��");
					else
						System.out.print("��");

			System.out.println();
		}
		
	}
}
