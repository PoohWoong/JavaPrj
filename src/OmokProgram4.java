/*����4. ���� üũ�� ���������ϴ� ����� ���ؼ� �Ѵ�.
���� �� �� ���� üũ���� �ʴ´�.*/

import java.util.Scanner;

public class OmokProgram4 {

	public static void main(String[] args) {
		
		Scanner scan= new Scanner(System.in);

		int width=21; //�ٵ����� ũ��
		int height=width; //�ٵ����� ��������� �Ǿ�� �Ѵ�.
		char[][] board = new char[height][width]; //�ٵ��� �迭
		int[] omokXs = new int[height*width];
		int[] omokYs = new int[height*width];
		int[] types = new int[height*width];
		
		//��ǥ�� �̿��� �׵θ� �α�
		for(int j=0;j<height;j++)
			for(int i=0; i<width;i++)
				board[j][i]='��';
		for(int i=0;i<width;i++)
		{
			board[0][i]='��';
			board[height-1][i]='��';			
		}
		for(int i=0;i<height;i++)
		{
			board[i][0]='��';
			board[i][width-1]='��';
		}
		board[0][0]='��';
		board[0][width-1]='��';
		board[height-1][0]='��';
		board[height-1][width-1]='��';
		board[height/2][width/2]='��';
		
		
		int mapx;
		int mapy;
		int type;
		int count=0;
		
		//�ٵ��� ���
		for(int y=0; y<height;y++){
			for(int x=0; x<width;x++)
				System.out.printf("%c", board[y][x]);
			System.out.println();
		}
		
		��ǥ����:
		while(count<width*height){
			
			type=count%2+1;
						
			//����� �Է��� �޴� ����
			System.out.printf("�� %d. %s�� ���� �α� (x sp y): ", count+1, type==1?"��":"��");
			mapx=scan.nextInt();
			mapy=scan.nextInt();
			//���� ��ȿ�� �˻�
			if(mapx<1||mapx>width||mapy<1||mapy>height)
				continue ��ǥ����;
			//�ߺ��˻�
			if(board[mapy-1][mapx-1]=='��'||board[mapy-1][mapx-1]=='��')
				continue;
			//�Է¹��� ��ǥ�� ������ board�迭 ��ü�� üũ�ϴ� ���.
			
						
			omokXs[count]=mapx;
			omokYs[count]=mapy;
			types[count]=type;
			
			if(type==2)
				board[omokYs[count]-1][omokXs[count]-1]='��';
			else
				board[omokYs[count]-1][omokXs[count]-1]='��';
			
			//�ٵ��� ���
			for(int y=0; y<height;y++){
				for(int x=0; x<width;x++)
					System.out.printf("%c", board[y][x]);
				System.out.println();
			}
			//���а˻� - ��ǥ����, ���� �������� ����� �˻��ϴ� �������.
			for(int y=0;y<height;y++)
				for(int x=0;x<width;x++)
					//���� if�� �ϳ��� ��� ���� ���� �ִ�. ������ �׷��� �� ��� if���� ������ �Ѵ��� �������� �ʴ´�.
					if(x<width-5&&board[y][x]==board[y][x+1]&&(board[y][x]=='��'||board[y][x]=='��')){
						if(board[y][x]==board[y][x+2])
							if(board[y][x]==board[y][x+3])
								if(board[y][x]==board[y][x+4]){
									System.out.printf("���ӳ�! %s �¸�!\n", board[y][x]=='��'?"��":"��");
									break ��ǥ����;
								}// �� ������ �˻�
					}else if(y<height-5&&board[y][x]==board[y+1][x]&&(board[y][x]=='��'||board[y][x]=='��')){
						if(board[y][x]==board[y+2][x])
							if(board[y][x]==board[y+3][x])
								if(board[y][x]==board[y+4][x]){
									System.out.printf("���ӳ�! %s �¸�!\n", board[y][x]=='��'?"��":"��");
									break ��ǥ����;
								} //������� �˻�
					}else if(y<height-5&&x<width-5&&board[y][x]==board[y+1][x+1]&&(board[y][x]=='��'||board[y][x]=='��')){
						if(board[y][x]==board[y+2][x+2])
							if(board[y][x]==board[y+3][x+3])
								if(board[y][x]==board[y+4][x+4]){
									System.out.printf("���ӳ�! %s �¸�!\n", board[y][x]=='��'?"��":"��");
									break ��ǥ����;
								} //�ٹ����� �˻�
					}else if(y<height-5&&x>=4&&board[y][x]==board[y+1][x-1]&&(board[y][x]=='��'||board[y][x]=='��')){
						if(board[y][x]==board[y+2][x-2])
							if(board[y][x]==board[y+3][x-3])
								if(board[y][x]==board[y+4][x-4]){
									System.out.printf("���ӳ�! %s �¸�!\n", board[y][x]=='��'?"��":"��");
									break ��ǥ����;
								}// �׹����� �˻�
					}
						
			count++;
			if(count==height*width) //���� �ٵ����� �� ä�������� ���º�
				System.out.println("���� ��! ���º�!");
		}
		
	}
}
