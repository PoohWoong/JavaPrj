import java.util.Scanner;

public class LottoProgram {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int num1 = 0, num2 = 0, num3 = 0, num4 = 0, num5 = 0, num6 = 0;

		// ���� �Է� �κ�
		System.out.println("\t\t�ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ�");
		System.out.println("\t\t��                �����ζ� 6/45                 ��");
		System.out.println("\t\t�ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ�");
		System.out.print("\t\t   ����! ������ ���� ���Ŵ� ���� ������\n\t\t\t��ź�� �̸��� �� �� �ֽ��ϴ�.\n");
		System.out.println("\t\t����������������������������������������");

		while (1 > num1 || num1 > 45) { // �ʱⰪ�� 0�̹Ƿ� ���ư�. �Է¹��� ���ڰ� 1~45�� �ƴϸ� �ݺ���
			System.out.print("\t\t    ù ��° ����: ");
			num1 = scan.nextInt();
			if (num1 < 1 || num1 > 45) // �Է¹��� ���ڰ� 1~45�� ������ �ƴ� ��
				System.out.println("�ٽ� �Է��ϼ���");
		}
		while (1 > num2 || num2 > 45) {
			System.out.print("\t\t    �� ��° ����: ");
			num2 = scan.nextInt();
			if (num2 < 1 || num2 > 45)
				System.out.println("�ٽ� �Է��ϼ���");
		}
		while (1 > num3 || num3 > 45) {
			System.out.print("\t\t    �� ��° ����: ");
			num3 = scan.nextInt();
			if (num3 < 1 || num3 > 45)
				System.out.println("�ٽ� �Է��ϼ���");
		}
		while (1 > num4 || num4 > 45) {
			System.out.print("\t\t    �� ��° ����: ");
			num4 = scan.nextInt();
			if (num4 < 1 || num4 > 45)
				System.out.println("�ٽ� �Է��ϼ���");
		}
		while (1 > num5 || num5 > 45) {
			System.out.print("\t\t �ټ� ��° ����: ");
			num5 = scan.nextInt();
			if (num5 < 1 || num5 > 45)
				System.out.println("�ٽ� �Է��ϼ���");
		}
		while (1 > num6 || num6 > 45) {
			System.out.print("\t\t ���� ��° ����: ");
			num6 = scan.nextInt();
			if (num6 < 1 || num6 > 45)
				System.out.println("�ٽ� �Է��ϼ���");
		}

		System.out.println("\t\t����������������������������������������\n\n\n\n");

		// ��ȣ ��ºκ�
		System.out.println("\t\t�ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ�");
		System.out.println("\t\t��                �����ζ� 6/45                 ��");
		System.out.println("\t\t�ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ�");
		System.out.println("\t\tGame");
		System.out.printf("\t\t   A\t\t%2d\t%2d\t%2d\t%2d\t%2d\t%2d\n", num1, num2, num3, num4, num5, num6);
		System.out.println("\t\t����������������������������������������");
		System.out.printf("\t\t\t\t\t\t\t\\  %d\n", 1 * 1000);

	}

}
