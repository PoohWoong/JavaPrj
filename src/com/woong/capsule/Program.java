package com.woong.capsule;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

			Exam exam = new Exam();

			boolean pc = true;
			while (pc) {
				switch (inputMainMenu()) {
				case 1:
					Exam.inputExam(exam);
					break;
				case 2:
					Exam.printExam(exam);
					break;
				case 3:
					pc = exitProgram();
					break;		
				}
			}
		}

		private static boolean exitProgram() {
			System.out.println("\tGood Bye~");
			return false;
		}


		private static int inputMainMenu() {
			Scanner scan = new Scanner(System.in);
			int menu;

			System.out.println("����������������������������");
			System.out.println("��            ����  �޴�           ��");
			System.out.println("����������������������������");
			System.out.println("\t1. ���� �Է�");
			System.out.println("\t2. ���� ���");
			System.out.println("\t3. ����");
			System.out.print("\t>  ");
			menu = scan.nextInt();

			return menu;

	}

}
