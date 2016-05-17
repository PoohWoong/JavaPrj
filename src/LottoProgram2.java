import java.util.Random;
import java.util.Scanner;

public class LottoProgram2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int[] lotto = new int[6];

		Random rand = new Random();

		//��ȣ ���� �� �ߺ� üũ -> �迭 �̿��ؼ� �迭���� ���� ���� �迭 ä���� 1 ���θ�ŭ ���� �����°� �غ���
		int cnt = 0;
		��������:
		while (cnt < 6) {
			lotto[cnt] = rand.nextInt(45) + 1;
			for (int j = 0; j < cnt; j++)
				if (lotto[cnt] == lotto[j])
					continue ��������;
			cnt++;
		}

		// ��ȣ ���

		for (int i = 0; i < 6; i++)
			System.out.printf("\t%d", lotto[i]);
		System.out.println();

		// �����ϱ�
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
