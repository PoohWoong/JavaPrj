
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class FileProgram {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("d:\\prelude.txt");
		Scanner fscan= new Scanner(fis);
		FileOutputStream fos= new FileOutputStream("d:\\modify.txt");
		PrintStream fout= new PrintStream(fos);
		while(fscan.hasNext())
			fout.printf("arr.add(new Rythme(%d,%d));\r\n", fscan.nextInt(), fscan.nextInt());		
		
		fout.close();
		fos.close();
		fscan.close();
		fis.close();
		
		
		
/*		String[] str= "돈슨의 호갱".split(" ");
		System.out.println(str[0]);
		System.out.println(str[1]);
		
		Scanner scan=new Scanner(System.in);
		
		System.out.print("이름1 :");
		String s1= scan.next();
		
		System.out.println(s1);
		System.out.print("이름2 :");
	
		String s2= scan.next();
		System.out.println(s2);
		*/
				
		
	/*	FileOutputStream fos= new FileOutputStream("d:\\Woong\\hello.txt");
		PrintStream fout= new PrintStream(fos);
		
		fout.printf("lotto : %d %d %d", 15, 21, 32);
		
		fout.close();		
		fos.close();
		
		System.out.println("입력 하시지 말입니다.");
		
		FileInputStream fis=new FileInputStream("d:\\Woong\\hello.txt");
		Scanner fscan= new Scanner(fis);
		
		//String str = fscan.nextLine();
		//System.out.println(str);
		fscan.next();
		fscan.next();
		int n1=fscan.nextInt();
		int n2=fscan.nextInt();
		int n3=fscan.nextInt();
		
		System.out.printf("n1: %d, n2: %d, n3: %d\n", n1, n2, n3);
		
		fscan.close();
		fis.close();*/
		
	}

}
