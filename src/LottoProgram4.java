
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class LottoProgram4 {

	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);

		int[][] lottos = new int[10][6];
		int current = -1;

		Outer:
		while (true) {

			int menu;
			System.out.println("로또 메인 메뉴");
			System.out.println("   1. 번호 목록");
			System.out.println("   2. 번호 읽기");
			System.out.println("   3. 번호 저장");
			System.out.println("   4. 종료");

			menu = scan.nextInt();

			switch (menu) {
			case 1: {
				번호목록: 
				while (true) {
					System.out.println("로또 목록 ------------------------");
					// 목록 출력 코드 작성
					for (int i = 0; i <= current; i++) {
						int[] lotto = lottos[i];
						System.out.printf("%2d : %2d %2d %2d %2d %2d %2d\n", i + 1, lotto[0], lotto[1], lotto[2],
								lotto[3], lotto[4], lotto[5]);
					}

					System.out.println("   1. 번호 생성");
					System.out.println("   2. 번호 입력");
					System.out.println("   3. 상위 메뉴");

					int submenu;
					submenu = scan.nextInt();
					switch (submenu) {
					case 1:
						Random rand = new Random();
						int[] lotto = new int[6];
						current++;

						// 번호 생성
						int cnt = 0;
						생성루프:
						while (cnt < 6) {
							lotto[cnt] = rand.nextInt(45) + 1;
							for (int j = 0; j < cnt; j++)
								if (lotto[cnt] == lotto[j])
									continue 생성루프;
							cnt++;
						}

						// 정렬하기
						int tmp;
						for (int i = 0; i < 5; i++)
							for (int j = 0; j < 5 - i; j++)
								if (lotto[j] > lotto[j + 1]) {
									tmp = lotto[j];
									lotto[j] = lotto[j + 1];
									lotto[j + 1] = tmp;
								}

						// 번호 출력
						for (int i = 0; i < 6; i++)
							System.out.printf("\t%d", lotto[i]);
						System.out.println();

						for (int i = 0; i < 6; i++)
							lottos[current][i] = lotto[i];
						break;
					case 2:
						break;
					case 3:
						break 번호목록;
					}
				}

				break;
			}
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
				System.out.println("데이터 읽기가 완료되었습니다.");
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

}
