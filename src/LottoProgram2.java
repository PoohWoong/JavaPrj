import java.util.Random;
import java.util.Scanner;

public class LottoProgram2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int[] lotto = new int[6];

		Random rand = new Random();

		//번호 생성 및 중복 체크 -> 배열 이용해서 배열에서 숫자 빼고 배열 채워서 1 줄인만큼 랜덤 돌리는거 해보기
		int cnt = 0;
		생성루프:
		while (cnt < 6) {
			lotto[cnt] = rand.nextInt(45) + 1;
			for (int j = 0; j < cnt; j++)
				if (lotto[cnt] == lotto[j])
					continue 생성루프;
			cnt++;
		}

		// 번호 출력

		for (int i = 0; i < 6; i++)
			System.out.printf("\t%d", lotto[i]);
		System.out.println();

		// 정렬하기
		int tmp;
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5 - i; j++)
				if (lotto[j] > lotto[j + 1]) {
					tmp = lotto[j];
					lotto[j] = lotto[j + 1];
					lotto[j + 1] = tmp;
				}

		for (int i = 0; i < 6; i++)
			System.out.printf("\t%d", lotto[i]);
		System.out.println();
	}

}
