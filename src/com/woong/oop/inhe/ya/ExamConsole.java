package com.woong.oop.inhe.ya;

import java.util.Scanner;

public class ExamConsole {
	
	private Exam exam;
	private PrintListener printListener;
	private TitlePrintListener titlePrintListener;
	
	
	public ExamConsole(Exam exam){
		this.exam = exam;
	}
		
	public ExamConsole(){
		exam=new Exam();
	}
		
	public void setPrintListener(PrintListener printListener) {
		this.printListener = printListener;
	}

	public void setTitlePrintListener(TitlePrintListener titlePrintListener) {
		this.titlePrintListener = titlePrintListener;
	}

	public void print() {
		
		if(titlePrintListener != null)
			titlePrintListener.onTitlePrint();
		else{
			System.out.println("����������������������������");
			System.out.println("��            ����  ���           ��");
			System.out.println("����������������������������");
		}
	
		System.out.printf("\t���� : %3d\n", exam.getKor());
		System.out.printf("\t���� : %3d\n", exam.getEng());
		System.out.printf("\t���� : %3d\n", exam.getMath());
		if(printListener != null)
			printListener.onPrint();
		
		System.out.printf("\t���� : %3d\n", exam.total());
		System.out.printf("\t��� : %.2f\n", exam.avg());
		System.out.println("����������������������������");
	}

	public void input() {
		System.out.println("����������������������������");
		System.out.println("��            ����  �Է�           ��");
		System.out.println("����������������������������");
		
		// �Է� �Լ�ȭ
		exam.setKor(inputScore("����"));
		exam.setEng(inputScore("����"));
		exam.setMath(inputScore("����"));
	}

	public int inputScore(String string) {
		Scanner scan = new Scanner(System.in);
		int score;
		System.out.printf("\t%s : ", string);
		score = scan.nextInt();
		while (score > 100 || score < 0) {
			System.out.print("�Է� ���� ����. ���Է�: ");
			score = scan.nextInt();
		}
		return score;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
//	protected abstract void onPrint();
	

}
