import java.util.Scanner;

//������ ����ü �ٷ��

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

		System.out.println("����������������������������");
		System.out.println("��            ����  ���           ��");
		System.out.println("����������������������������");
		
		for(int i=0;i<current+1;i++){
			Exam exam= exams[i];
			int total = exam.kor + exam.eng + exam.math;
			double avg = total / 3.0;
			System.out.printf("\t���� : %3d\n", exam.kor);
			System.out.printf("\t���� : %3d\n", exam.eng);
			System.out.printf("\t���� : %3d\n", exam.math);
			System.out.printf("\t���� : %3d\n", total);
			System.out.printf("\t��� : %.2f\n", avg);
			System.out.println("����������������������������");
		}
	}

	private static int inputExam(Exam[] exams, int current) {
		System.out.println("����������������������������");
		System.out.println("��            ����  �Է�           ��");
		System.out.println("����������������������������");
		
		// �Է� �Լ�ȭ
		Exam exam = new Exam();
		exam.kor = inputScore("����");
		exam.eng = inputScore("����");
		exam.math = inputScore("����");
		
		exams[++current] = exam;		
		
		return current;
	}

	private static int inputScore(String string) {
		Scanner scan = new Scanner(System.in);
		int score;
		System.out.printf("\t%s : ", string);
		score = scan.nextInt();
		while (score > 100 || score < 0) {
			System.out.print("�Է� ���� ����. ���Է�: ");
			score = scan.nextInt();
		}
		return score;
	}

	private static int inputMainMenu() {
		Scanner scan = new Scanner(System.in);
		int menu;

		System.out.println("����������������������������");
		System.out.println("��            ����  �޴�           ��");
		System.out.println("����������������������������");
		System.out.println("\t1. ���� �Է�");
		System.out.println("\t2. ���� ���");
		System.out.println("\t3. ����");
		System.out.print("\t>  ");
		menu = scan.nextInt();

		return menu;
	}
}