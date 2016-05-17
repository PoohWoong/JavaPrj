package com.woong.capsule;

import java.util.Scanner;

public class Exam {
	private int kor;
	private int eng;
	private int math;
	
	public void setKor(int kor){
		this.kor= kor;
	}
	public static void setEng(Exam exam, int eng){
		exam.eng= eng;
	}
	public static void setMath(Exam exam, int math){
		exam.math= math;
	}
	public static int getKor(Exam exam){
		return exam.kor;
	}
	public static int getEng(Exam exam){
		return exam.eng;
	}
	public static int getMath(Exam exam){
		return exam.math;
	}
	
	
	public static void printExam(Exam exam) {
		int total = exam.kor + exam.eng + exam.math;
		double avg = total / 3.0;

		System.out.println("┌────────────┐");
		System.out.println("│            성적  출력           │");
		System.out.println("└────────────┘");
		System.out.printf("\t국어 : %3d\n", exam.kor);
		System.out.printf("\t영어 : %3d\n", exam.eng);
		System.out.printf("\t수학 : %3d\n", exam.math);
		System.out.printf("\t총점 : %3d\n", total);
		System.out.printf("\t평균 : %.2f\n", avg);
		System.out.println("──────────────");
	}

	public static void inputExam(Exam exam) {
		System.out.println("┌────────────┐");
		System.out.println("│            성적  입력           │");
		System.out.println("└────────────┘");
		
		// 입력 함수화
		exam.kor = inputScore("국어");
		exam.eng = inputScore("영어");
		exam.math = inputScore("수학");
		
	}

	public static int inputScore(String string) {
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

}
