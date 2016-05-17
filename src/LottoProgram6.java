import java.util.Random;
import java.util.Scanner;

//함수 모듈 적용한 버전2. 새로 만들기!

public class LottoProgram6 {
	public static void main(String[] args){
		//메인 메뉴 입력		
		int[][] lottos = new int[10][6];
		int current=-1;
		
		MainLoop:
		while(true){
			switch(inputMainMenu()){
			case 1:
				//로또 자동 생성
				current=genLottoAuto(lottos, current);			
				break;
			case 2:
				//로또 수동 생성
				current=genLottoManual(lottos, current);
				break;
			case 3:
				//로또 번호 보기
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

		System.out.print("생성할 게임의 갯수를 입력하세요:");
		int count= scan.nextInt();
		
		for(int i=0;i<count;i++){
			current++;
			makeLotto(lotto);	// 번호 생성
			bubbleSort(lotto);	// 정렬하기
			printLotto(lotto);	// 번호 출력
			for (int j = 0; j < 6; j++)
				lottos[current][j] = lotto[j];			
		}
		return current;		
	}
	
	private static int genLottoManual(int[][] lottos, int current) {
		Scanner scan= new Scanner(System.in);
		int[] lotto = new int[6];
		
		System.out.print("6개의 숫자를 입력하세요(sp 구분)");
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
		생성루프:
		while (cnt < 6) {
			arr[cnt] = rand.nextInt(45) + 1;
			for (int j = 0; j < cnt; j++)
				if (arr[cnt] == arr[j])
					continue 생성루프;
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
		System.out.println("로또 메인 메뉴");
		System.out.println("   1. 번호 자동 생성");
		System.out.println("   2. 번호 수동 생성");
		System.out.println("   3. 내 로또 번호 보기");
		System.out.println("   4. 종료");

		menu = scan.nextInt();
		return menu;
	}
}
