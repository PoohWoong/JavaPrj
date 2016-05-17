import java.util.Random;
import java.util.Scanner;

//�Լ� ��� ������ ����2. ���� �����!

public class LottoProgram6 {
	public static void main(String[] args){
		//���� �޴� �Է�		
		int[][] lottos = new int[10][6];
		int current=-1;
		
		MainLoop:
		while(true){
			switch(inputMainMenu()){
			case 1:
				//�ζ� �ڵ� ����
				current=genLottoAuto(lottos, current);			
				break;
			case 2:
				//�ζ� ���� ����
				current=genLottoManual(lottos, current);
				break;
			case 3:
				//�ζ� ��ȣ ����
				viewLotto(lottos,current);
				break;
			case 4:
				break MainLoop;
			}			
		}
	}

	private static void viewLotto(int[][] lottos, int current) {
		int[] lotto = new int[6];
		for(int i=0;i<=current;i++){
			lotto=lottos[i];
			printLotto(lotto);
		}		
	}

	private static int genLottoAuto(int[][] lottos, int current) {
		Scanner scan= new Scanner(System.in);
		int[] lotto = new int[6];

		System.out.print("������ ������ ������ �Է��ϼ���:");
		int count= scan.nextInt();
		
		for(int i=0;i<count;i++){
			current++;
			makeLotto(lotto);	// ��ȣ ����
			bubbleSort(lotto);	// �����ϱ�
			printLotto(lotto);	// ��ȣ ���
			for (int j = 0; j < 6; j++)
				lottos[current][j] = lotto[j];			
		}
		return current;		
	}
	
	private static int genLottoManual(int[][] lottos, int current) {
		Scanner scan= new Scanner(System.in);
		int[] lotto = new int[6];
		
		System.out.print("6���� ���ڸ� �Է��ϼ���(sp ����)");
		for(int i=0;i<6;i++)
			lotto[i]=scan.nextInt();
		current++;
		for (int j = 0; j < 6; j++)
			lottos[current][j] = lotto[j];
		
		return current;
	}
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

	private static int inputMainMenu() {
		
		Scanner scan= new Scanner(System.in);
		
		int menu;
		System.out.println("�ζ� ���� �޴�");
		System.out.println("   1. ��ȣ �ڵ� ����");
		System.out.println("   2. ��ȣ ���� ����");
		System.out.println("   3. �� �ζ� ��ȣ ����");
		System.out.println("   4. ����");

		menu = scan.nextInt();
		return menu;
	}
}
