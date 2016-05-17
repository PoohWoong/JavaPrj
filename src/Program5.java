import java.util.Scanner;

//함수를 이용해 구조만 작성하는 코드

public class Program5 {

	public static void main(String[] args) {

		Exam exam = new Exam();

		boolean pc = true;
		while (pc) {
			switch (inputMainMenu()) {
			case 1:
				inputExam(exam);
				break;
			case 2:
				printExam(exam);
				break;
			case 3:
				pc = exitProgram();
				break;		
			}
		}
	}

	private static boolean exitProgram() {
		System.out.println("\tGood Bye~");
		return false;

	}

	private static void printExam(Exam exam) {
		int total = exam.kor + exam.eng + exam.math;
		double avg = total / 3.0;

		System.out.println("┌────────────┐");
		System.out.println("│            성적  출력           │");
		System.out.println("└────────────┘");
		System.out.printf("\t국어 : %3d\n", exam.kor);
		System.out.printf("\t영어 : %3d\n", exam.eng);
		System.out.printf("\t수학 : %3d\n", exam.math);
		System.out.printf("\t총점 : %3d\n", total);
		System.out.printf("\t평균 : %.2f\n", avg);
		System.out.println("──────────────");
	}

	private static void inputExam(Exam exam) {
		System.out.println("┌────────────┐");
		System.out.println("│            성적  입력           │");
		System.out.println("└────────────┘");
		
		// 입력 함수화
		exam.kor = inputScore("국어");
		exam.eng = inputScore("영어");
		exam.math = inputScore("수학");
		
	}

	private static int inputScore(String string) {
		Scanner scan = new Scanner(System.in);
		int score;
		System.out.printf("\t%s : ", string);
		score = scan.nextInt();
		while (score > 100 || score < 0) {
			System.out.print("입력 범위 오류. 재입력: ");
			score = scan.nextInt();
		}
		return score;
	}

	private static int inputMainMenu() {
		Scanner scan = new Scanner(System.in);
		int menu;

		System.out.println("┌────────────┐");
		System.out.println("│            메인  메뉴           │");
		System.out.println("└────────────┘");
		System.out.println("\t1. 성적 입력");
		System.out.println("\t2. 성적 출력");
		System.out.println("\t3. 종료");
		System.out.print("\t>  ");
		menu = scan.nextInt();

		return menu;
	}
}