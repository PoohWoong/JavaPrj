//���� ����� �ڵ� ����

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;


public class LottoProgram3 {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis= new FileInputStream("d:\\Woong\\lotto.txt");
		Scanner fscan= new Scanner(fis);
		
		Scanner scan = new Scanner(System.in);
		int[] lotto = new int[6];

		Random rand = new Random();
		

		/*int cnt = 0;
		��������: while (cnt < 6) {
			lotto[cnt] = rand.nextInt(45) + 1;
			for (int j = 0; j < cnt; j++)
				if (lotto[cnt] == lotto[j])
					continue ��������;
			cnt++;
		}*/
		for(int i=0; i<6;i++)
			lotto[i]=fscan.nextInt();
		
		fscan.close();
		fis.close();

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

		FileOutputStream fos= new FileOutputStream("d:\\Woong\\lotto.txt");
		PrintStream fout=new PrintStream(fos);
		
		for (int i = 0; i < 6; i++){
			System.out.printf("\t%d", lotto[i]);
			fout.printf("\t%d", lotto[i]);
		}
		System.out.println();
		fout.close();
		fos.close();
		String name1= "Hello how are you.txt";
		//String name2=new String("������");
		
		int idx=name1.indexOf("o");
		System.out.println(idx);
		idx=name1.indexOf("o", idx+1);
		System.out.println(idx);
		
		idx=name1.lastIndexOf(".");
		System.out.println(name1.substring(idx+1));
		
		String path="d:\\Woong\\lotto.txt";
		idx=path.lastIndexOf("\\");
		System.out.println(path.substring(idx+1));
		
		int kor=Integer.parseInt("23");
		System.out.println(kor);
		
		//String s=String.valueOf(kor);
		String s=""+kor;
		System.out.println(s+"��");
				
		String s1 = new String(s);
		System.out.println(s1);
		s1= new String("������");
		System.out.println(s1);
		
	
	}

}
