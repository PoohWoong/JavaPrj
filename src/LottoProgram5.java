//�Լ� ��� ������ ����.


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class LottoProgram5 {
	
	public static void makeLotto(int[] arr){
		Random rand = new Random();
		int cnt = 0;
		��������:
		while (cnt < 6) {
			arr[cnt] = rand.nextInt(45) + 1;
			for (int j = 0; j < cnt; j++)
				if (arr[cnt] == arr[j])
					continue ��������;
			cnt++;
		}
	}
	
	public static void bubbleSort(int[] lotto){
		int tmp;
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5 - i; j++)
				if (lotto[j] > lotto[j + 1]) {
					tmp = lotto[j];
					lotto[j] = lotto[j + 1];
					lotto[j + 1] = tmp;
				}		
	}

	public static void printLotto(int[] lotto){
		for (int i = 0; i < 6; i++)
			System.out.printf("%2d ", lotto[i]);
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);

		int[][] lottos = new int[10][6];
		int current = -1;

		Outer:
		while (true) {
			switch (inputMainMenu()) {
			case 1: 
				current= manageLotto(lottos, current);
				
				break;
			case 2:
				current=-1;
				FileInputStream fis= new FileInputStream("res/lotto/lottos.txt");
				int count=fis.read();
				for(int lo=0;lo<count;lo++){
					current++;
					int[] lotto=lottos[lo];
					for(int i=0;i<6;i++)
						lotto[i]=fis.read();
				}
							
				fis.close();
				System.out.println("������ �бⰡ �Ϸ�Ǿ����ϴ�.");
				break;
			case 3:
				FileOutputStream fos = new FileOutputStream("res/lotto/lottos.txt");
				//PrintStream fout = new PrintStream(fos);
				
				/*for (int i = 0; i <= current; i++) {
					int[] lotto = lottos[i];
					fout.printf("%2d %2d %2d %2d %2d %2d\r\n", lotto[0], lotto[1], lotto[2],
							lotto[3], lotto[4], lotto[5]);
				}
				
				fout.close();*/
				fos.write(current+1);
				for(int lo=0;lo<=current;lo++){
					int[] lotto=lottos[lo];
					for(int i=0;i<6;i++)
						fos.write(lotto[i]);					
				}

				fos.close();
				break;
			case 4:
				break Outer;
			}

		}

	}

	private static int manageLotto(int[][] lottos, int current) {
		Scanner scan = new Scanner(System.in);
		��ȣ���: 
			while (true) {
				System.out.println("�ζ� ��� ------------------------");
				// ��� ��� �ڵ� �ۼ�
				for (int i = 0; i <= current; i++) {
					int[] lotto = lottos[i];
					System.out.printf("%2d : ",i+1);
					printLotto(lotto);
				}

				System.out.println("   1. ��ȣ ����");
				System.out.println("   2. ��ȣ �Է�");
				System.out.println("   3. ���� �޴�");

				int submenu;
				submenu = scan.nextInt();
				switch (submenu) {
				case 1:
					int[] lotto = new int[6];
					current++;

					makeLotto(lotto);	// ��ȣ ����
					bubbleSort(lotto);	// �����ϱ�
					printLotto(lotto);	// ��ȣ ���

					for (int i = 0; i < 6; i++)
						lottos[current][i] = lotto[i];
					break;
				case 2:
					break;
				case 3:
					break ��ȣ���;
				}
			}
		return current;
		
	}

	public static int inputMainMenu() {
		Scanner scan = new Scanner(System.in);

		int menu;
		System.out.println("�ζ� ���� �޴�");
		System.out.println("   1. ��ȣ ���");
		System.out.println("   2. ��ȣ �б�");
		System.out.println("   3. ��ȣ ����");
		System.out.println("   4. ����");

		menu = scan.nextInt();
		return menu;
	}

}
