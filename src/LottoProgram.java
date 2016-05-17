import java.util.Scanner;

public class LottoProgram {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int num1 = 0, num2 = 0, num3 = 0, num4 = 0, num5 = 0, num6 = 0;

		// 숫자 입력 부분
		System.out.println("\t\t★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		System.out.println("\t\t☆                나눔로또 6/45                 ★");
		System.out.println("\t\t★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		System.out.print("\t\t   주의! 과다한 복권 구매는 가정 경제를\n\t\t\t파탄에 이르게 할 수 있습니다.\n");
		System.out.println("\t\t────────────────────");

		while (1 > num1 || num1 > 45) { // 초기값이 0이므로 돌아감. 입력받은 숫자가 1~45가 아니면 반복됨
			System.out.print("\t\t    첫 번째 숫자: ");
			num1 = scan.nextInt();
			if (num1 < 1 || num1 > 45) // 입력받은 숫자가 1~45의 범위가 아닐 때
				System.out.println("다시 입력하세요");
		}
		while (1 > num2 || num2 > 45) {
			System.out.print("\t\t    두 번째 숫자: ");
			num2 = scan.nextInt();
			if (num2 < 1 || num2 > 45)
				System.out.println("다시 입력하세요");
		}
		while (1 > num3 || num3 > 45) {
			System.out.print("\t\t    세 번째 숫자: ");
			num3 = scan.nextInt();
			if (num3 < 1 || num3 > 45)
				System.out.println("다시 입력하세요");
		}
		while (1 > num4 || num4 > 45) {
			System.out.print("\t\t    네 번째 숫자: ");
			num4 = scan.nextInt();
			if (num4 < 1 || num4 > 45)
				System.out.println("다시 입력하세요");
		}
		while (1 > num5 || num5 > 45) {
			System.out.print("\t\t 다섯 번째 숫자: ");
			num5 = scan.nextInt();
			if (num5 < 1 || num5 > 45)
				System.out.println("다시 입력하세요");
		}
		while (1 > num6 || num6 > 45) {
			System.out.print("\t\t 여섯 번째 숫자: ");
			num6 = scan.nextInt();
			if (num6 < 1 || num6 > 45)
				System.out.println("다시 입력하세요");
		}

		System.out.println("\t\t────────────────────\n\n\n\n");

		// 번호 출력부분
		System.out.println("\t\t★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		System.out.println("\t\t☆                나눔로또 6/45                 ★");
		System.out.println("\t\t★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		System.out.println("\t\tGame");
		System.out.printf("\t\t   A\t\t%2d\t%2d\t%2d\t%2d\t%2d\t%2d\n", num1, num2, num3, num4, num5, num6);
		System.out.println("\t\t────────────────────");
		System.out.printf("\t\t\t\t\t\t\t\\  %d\n", 1 * 1000);

	}

}
