import java.util.Scanner;

//데이터 구조체 다루기

public class Program6 {

	public static void main(String[] args) {

		int current=-1;
		Exam[] exams = new Exam[10];

		boolean pc = true;
		while (pc) {
			switch (inputMainMenu()) {
			case 1:
				current=inputExam(exams, current);
				break;
			case 2:
				printExam(exams, current);
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

	private static void printExam(Exam[] exams, int current) {

		System.out.println("┌────────────┐");
		System.out.println("│            성적  출력           │");
		System.out.println("└────────────┘");
		
		for(int i=0;i<current+1;i++){
			Exam exam= exams[i];
			int total = exam.kor + exam.eng + exam.math;
			double avg = total / 3.0;
			System.out.printf("\t국어 : %3d\n", exam.kor);
			System.out.printf("\t영어 : %3d\n", exam.eng);
			System.out.printf("\t수학 : %3d\n", exam.math);
			System.out.printf("\t총점 : %3d\n", total);
			System.out.printf("\t평균 : %.2f\n", avg);
			System.out.println("──────────────");
		}
	}

	private static int inputExam(Exam[] exams, int current) {
		System.out.println("┌────────────┐");
		System.out.println("│            성적  입력           │");
		System.out.println("└────────────┘");
		
		// 입력 함수화
		Exam exam = new Exam();
		exam.kor = inputScore("국어");
		exam.eng = inputScore("영어");
		exam.math = inputScore("수학");
		
		exams[++current] = exam;		
		
		return current;
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