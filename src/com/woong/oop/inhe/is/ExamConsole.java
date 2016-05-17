package com.woong.oop.inhe.is;

import java.util.Scanner;

public class ExamConsole {
	
	private Exam exam;
	
	public ExamConsole(Exam exam){
		this.exam = exam;
	//	exam=new Exam();
	}
	
	public ExamConsole(){
		exam= new Exam();
		
	}
	
	
	public void print() {
		System.out.println("┌────────────┐");
		System.out.println("│            성적  출력           │");
		System.out.println("└────────────┘");
		System.out.printf("\t국어 : %3d\n", exam.getKor());
		System.out.printf("\t영어 : %3d\n", exam.getEng());
		System.out.printf("\t수학 : %3d\n", exam.getMath());
		onPrint();
		System.out.printf("\t총점 : %3d\n", exam.total());
		System.out.printf("\t평균 : %.2f\n", exam.avg());
		System.out.println("──────────────");
	}

	public void input() {
		System.out.println("┌────────────┐");
		System.out.println("│            성적  입력           │");
		System.out.println("└────────────┘");
		
		// 입력 함수화
		exam.setKor(inputScore("국어"));
		exam.setEng(inputScore("영어"));
		exam.setMath(inputScore("수학"));
	}

	public int inputScore(String string) {
		Scanner scan = new Scanner(System.in);
		int score;
		System.out.printf("\t%s : ", string);
		score = scan.nextInt();
		while (score > 100 || score < 0) {
			System.out.print("입력 범위 오류. 재입력: ");
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
	
	protected void onPrint(){
		
	}
	

}
