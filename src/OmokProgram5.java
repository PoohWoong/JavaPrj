
/* ����5
 * ���� üũ�� ������ ���� �������� +-4 ���� �������� �Ѵ�.
 * �ӵ��� �ξ� �� ��������..
 */

import java.util.Scanner;

public class OmokProgram5 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int width = 21; // �ٵ����� ũ��
		int height = width; // �ٵ����� ��������� �Ǿ�� �Ѵ�.
		char[][] board = new char[height][width]; // �ٵ��� �迭
		int[] omokXs = new int[height * width];
		int[] omokYs = new int[height * width];
		int[] types = new int[height * width];

		// ��ǥ�� �̿��� �׵θ� �α�
		for (int j = 0; j < height; j++)
			for (int i = 0; i < width; i++)
				board[j][i] = '��';
		for (int i = 0; i < width; i++) {
			board[0][i] = '��';
			board[height - 1][i] = '��';
		}
		for (int i = 0; i < height; i++) {
			board[i][0] = '��';
			board[i][width - 1] = '��';
		}
		board[0][0] = '��';
		board[0][width - 1] = '��';
		board[height - 1][0] = '��';
		board[height - 1][width - 1] = '��';
		board[height / 2][width / 2] = '��';

		int mapx;
		int mapy;
		int type;
		int count = 0;

		// �ٵ��� ���
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++)
				System.out.printf("%c", board[y][x]);
			System.out.println();
		}

		��ǥ����:
		while (count < width * height) {

			type = count % 2 + 1;

			// ����� �Է��� �޴� ����
			System.out.printf("�� %d. %s�� ���� �α� (x sp y): ", count + 1, type == 1 ? "��" : "��");
			mapx = scan.nextInt();
			mapy = scan.nextInt();
			// ���� ��ȿ�� �˻�
			if (mapx < 1 || mapx > width || mapy < 1 || mapy > height)
				continue ��ǥ����;
			// �ߺ��˻�
			if (board[mapy - 1][mapx - 1] == '��' || board[mapy - 1][mapx - 1] == '��')
				continue;
			// �Է¹��� ��ǥ�� ������ board�迭 ��ü�� üũ�ϴ� ���.

			omokXs[count] = mapx;
			omokYs[count] = mapy;
			types[count] = type;

			if (type == 2)
				board[omokYs[count] - 1][omokXs[count] - 1] = '��';
			else
				board[omokYs[count] - 1][omokXs[count] - 1] = '��';

			// �ٵ��� ���
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++)
					System.out.printf("%c", board[y][x]);
				System.out.println();
			}
			// ���а˻� - ������ ���� �������� ��4 �������� �˻��ϴ� ���.
			int mx = mapx - 1;
			int my = mapy - 1;
			int cnt = 0;

			// X�� �˻�
			for (int x = mx - 4; x < mx + 4; x++) {
				if (x < 0)
					continue;
				else if (x >= width - 1)
					break;
				if (board[my][x] == board[my][x + 1] && (board[my][x] == '��' || board[my][x] == '��'))
					cnt++;
				else
					cnt = 0;
				if (cnt == 4) {
					System.out.printf("���ӳ�! %s �¸�!\n", board[my][mx] == '��' ? "��" : "��");
					break ��ǥ����;
				}
			}

			// Y �� �˻�
			for (int y = my - 4; y < my + 4; y++) {
				if (y < 0)
					continue;
				else if (y >= height - 1)
					break;
				if (board[y][mx] == board[y + 1][mx] && (board[y][mx] == '��' || board[y][mx] == '��'))
					cnt++;
				else
					cnt = 0;
				if (cnt == 4) {
					System.out.printf("���ӳ�! %s �¸�!\n", board[my][mx] == '��' ? "��" : "��");
					break ��ǥ����;
				}
			}

			// �� �밢�� �˻�
			for (int x = mx - 4, y = my - 4; x < mx + 4 && y < my + 4; x++, y++) {
				if (x < 0 || y < 0)
					continue;
				else if (x >= width - 1 || y >= height - 1)
					break;
				if (board[y][x] == board[y + 1][x + 1] && (board[y][x] == '��' || board[y][x] == '��'))
					cnt++;
				else
					cnt = 0;
				if (cnt == 4) {
					System.out.printf("���ӳ�! %s �¸�!\n", board[my][mx] == '��' ? "��" : "��");
					break ��ǥ����;
				}
			}

			// �� �밢�� �˻�
			for (int x = mx - 4, y = my + 4; x < mx + 4 && y > my - 4; x++, y--) {
				if (x < 0 || y > height - 1)
					continue;
				else if (x >= width - 1 || y <= 0)
					break;
				if (board[y][x] == board[y - 1][x + 1] && (board[y][x] == '��' || board[y][x] == '��'))
					cnt++;
				else
					cnt = 0;
				if (cnt == 4) {
					System.out.printf("���ӳ�! %s �¸�!\n", board[my][mx] == '��' ? "��" : "��");
					break ��ǥ����;
				}
			}

			count++;
			if (count == height * width) // ���� �ٵ����� �� ä�������� ���º�
				System.out.println("���� ��! ���º�!");
		}

	}
}
