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
			System.out.println("����������������������������");
			System.out.println("��          ����  �޴�           ��");
			System.out.println("����������������������������");
			System.out.println("\t1. ���� �Է�");
			System.out.println("\t2. ���� ���");
			System.out.println("\t3. ����");
			System.out.print("\t>  ");
			menu = scan.nextInt();

			switch(menu){
			// ���� �Է� �ڵ�
			//if (menu == 1) {
			case 1:
				System.out.println("����������������������������");
				System.out.println("��          ����  �Է�           ��");
				System.out.println("����������������������������");
				System.out.print("\t���� : ");
				kor = scan.nextInt();
				System.out.print("\t���� : ");
				math = scan.nextInt();
				System.out.print("\t���� : ");
				eng = scan.nextInt();
				break;

			//���� ��º�
			//else if (menu == 2) {
			case 2:
					total = kor + eng + math;
					avg = total / 3.0;
					System.out.println("����������������������������");
					System.out.println("��          ����  ���           ��");
					System.out.println("����������������������������");
				for(int i=0; i<3; i++){
					System.out.printf("\t��ȣ : %3d\n", i+1);
					System.out.printf("\t���� : %3d\n", kor);
					System.out.printf("\t���� : %3d\n", math);
					System.out.printf("\t���� : %3d\n", eng);
					System.out.printf("\t���� : %3d\n", total);
					System.out.printf("\t��� : %.2f\n", avg);
					System.out.println("����������������������������");
				}
				break;


			case 3:
			//else if (menu == 3) {
				System.out.println("\tGood Bye~");
				//System.exit(0);
				break Outer;
			
			default:
				//else{
				System.out.println("�߸��� �Է��Դϴ�.");
			}
			
		}
	}
}
