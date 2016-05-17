import java.util.Scanner;

public class TestProgram {

	public static void main(String[] args) {

		int start = 0;
		int end = 0;
		int menu1 = 0;
		int menu2 = 0;
		int total = 0;

		Scanner scan = new Scanner(System.in);

		Outer: 
		while (true) {
			System.out.println("┌───────────────┐");
			System.out.println("│       합을 구하는 프로그램       │");
			System.out.println("└───────────────┘");
			System.out.println("\t1. 값 입력");
			System.out.println("\t2. 결과 보기");
			System.out.println("\t3. 도움말");
			System.out.println("\t4. 종료");
			System.out.print("\t선택 >  ");
			menu1 = scan.nextInt();

			switch (menu1) {
			case 1:
				System.out.println("┌───────────────┐");
				System.out.println("│                 값 입력                 │");
				System.out.println("└───────────────┘");

				Inner: 
				while (true) {
					menu2 = 0;
					System.out.print("\t(시작값 sp 끝값) >  ");
					start = scan.nextInt();
					end = scan.nextInt();
					
					if(start>end)
					{
						int tmp;
						tmp=start;
						start=end;
						end=tmp;
					}

					while (menu2 != 1 && menu2 != 2) {
						System.out.print("상위 메뉴로 이동(yes-1/재입력-2) > ");
						menu2 = scan.nextInt();
						if (menu2 == 1)
							break Inner;
						else if (menu2 == 2)
							;
						else
							System.out.println("잘못 입력하셨습니다.");
					}
				}
				break;

			case 2:
				total = 0;
				//for (int i = start; i <= end; i++)
				//	total += i;
				int count;
				count=end-start+1;
				total= count*(start+end)/2;

				System.out.println("┌───────────────┐");
				System.out.println("│                결과 보기               │");
				System.out.println("└───────────────┘");
				System.out.printf(" [%d] 부터 [%d] 까지의 합은 [%d] 입니다.\n", start, end, total);

				while (true) {
					System.out.print("상위 메뉴로 이동(yes-1/) > ");
					menu2 = scan.nextInt();
					if (menu2 == 1)
						break;
					else
						System.out.println("잘못 입력하셨습니다.");
				}
				break;

			case 3:
				System.out.println("도움말 준비중");
				break;
			case 4:
				System.out.println("Good bye~");
				break Outer;

			default:
				System.out.println("잘못 입력하셨습니다.");

			}

		}
	}
}
