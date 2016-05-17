import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int kor = 0, eng = 0, math = 0;
		int menu;
		int total;
		double avg;

		Outer: 
		while (true) {
			System.out.println("┌────────────┐");
			System.out.println("│          메인  메뉴           │");
			System.out.println("└────────────┘");
			System.out.println("\t1. 성적 입력");
			System.out.println("\t2. 성적 출력");
			System.out.println("\t3. 종료");
			System.out.print("\t>  ");
			menu = scan.nextInt();

			switch(menu){
			// 성적 입력 코드
			//if (menu == 1) {
			case 1:
				System.out.println("┌────────────┐");
				System.out.println("│          성적  입력           │");
				System.out.println("└────────────┘");
				System.out.print("\t국어 : ");
				kor = scan.nextInt();
				System.out.print("\t수학 : ");
				math = scan.nextInt();
				System.out.print("\t영어 : ");
				eng = scan.nextInt();
				break;

			//성적 출력부
			//else if (menu == 2) {
			case 2:
					total = kor + eng + math;
					avg = total / 3.0;
					System.out.println("┌────────────┐");
					System.out.println("│          성적  출력           │");
					System.out.println("└────────────┘");
				for(int i=0; i<3; i++){
					System.out.printf("\t번호 : %3d\n", i+1);
					System.out.printf("\t국어 : %3d\n", kor);
					System.out.printf("\t수학 : %3d\n", math);
					System.out.printf("\t영어 : %3d\n", eng);
					System.out.printf("\t총점 : %3d\n", total);
					System.out.printf("\t평균 : %.2f\n", avg);
					System.out.println("──────────────");
				}
				break;


			case 3:
			//else if (menu == 3) {
				System.out.println("\tGood Bye~");
				//System.exit(0);
				break Outer;
			
			default:
				//else{
				System.out.println("잘못된 입력입니다.");
			}
			
		}
	}
}
