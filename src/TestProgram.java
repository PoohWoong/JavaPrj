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
			System.out.println("����������������������������������");
			System.out.println("��       ���� ���ϴ� ���α׷�       ��");
			System.out.println("����������������������������������");
			System.out.println("\t1. �� �Է�");
			System.out.println("\t2. ��� ����");
			System.out.println("\t3. ����");
			System.out.println("\t4. ����");
			System.out.print("\t���� >  ");
			menu1 = scan.nextInt();

			switch (menu1) {
			case 1:
				System.out.println("����������������������������������");
				System.out.println("��                 �� �Է�                 ��");
				System.out.println("����������������������������������");

				Inner: 
				while (true) {
					menu2 = 0;
					System.out.print("\t(���۰� sp ����) >  ");
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
						System.out.print("���� �޴��� �̵�(yes-1/���Է�-2) > ");
						menu2 = scan.nextInt();
						if (menu2 == 1)
							break Inner;
						else if (menu2 == 2)
							;
						else
							System.out.println("�߸� �Է��ϼ̽��ϴ�.");
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

				System.out.println("����������������������������������");
				System.out.println("��                ��� ����               ��");
				System.out.println("����������������������������������");
				System.out.printf(" [%d] ���� [%d] ������ ���� [%d] �Դϴ�.\n", start, end, total);

				while (true) {
					System.out.print("���� �޴��� �̵�(yes-1/) > ");
					menu2 = scan.nextInt();
					if (menu2 == 1)
						break;
					else
						System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				}
				break;

			case 3:
				System.out.println("���� �غ���");
				break;
			case 4:
				System.out.println("Good bye~");
				break Outer;

			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");

			}

		}
	}
}
