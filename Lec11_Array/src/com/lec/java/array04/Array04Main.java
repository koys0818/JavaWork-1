package com.lec.java.array04;

import java.util.Scanner;

/* 연습
 * 길이 5개 int 형 배열을 선언하고
 * 사용자로부터 5개 정수를 입력받아 초기화 한뒤 
 * 
 * 총점, 평균, 최대값, 최소값  출력해보기
 */
public class Array04Main {

	public static void main(String[] args) {
		System.out.println("배열 연습");

		int[] numbers = new int[5];
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < numbers.length; i++) {
			System.out.print("숫자 입력해주세요 : ");
			numbers[i] = sc.nextInt();
			sum += numbers[i];
		}
		sc.close();

		double avg = (double) sum / numbers.length;

		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + avg);

		int max = numbers[0];
		int min = numbers[0];

		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] > max) {
				max = numbers[i];
			}
		}
		System.out.println("최댓값 : " + max);

		for (int i = 1; i < numbers.length; i++) {
//			if(numbers[i] < min) {
//				min = numbers[i];

			min = (numbers[i] < min) ? numbers[i] : min;
		}

		System.out.println("최소값 : " + min);

	} // end main()

} // end class Array04Main
