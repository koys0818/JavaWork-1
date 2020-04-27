package com.lec.java.input01;

import java.util.Scanner;

public class Input01Main {

	public static void main(String[] args) {

		System.out.println("ǥ���Է� : Scanner ���");

		Scanner sc = new Scanner(System.in);

		int num1, num2;
		System.out.print("숫자 1을 입력하세요: ");
		num1 = sc.nextInt();
		System.out.println("숫자 2를 입력하세요: ");
		num2  = sc.nextInt();

		System.out.println(num1 + " + " + num2 + " = "  + (num1 + num2));
		
//		

		sc.close(); // Scanner ��ü�� ����� �ڿ��� �ݵ�� close()�� ������.

		System.out.println();

		

	}

}
