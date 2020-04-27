package com.lec.java.for02;

public class For02Main {

	public static void main(String[] args) {
		System.out.println("For문 - 구구단 출력");
		
		for (int i = 1; i <= 9; i++) {
			System.out.println("2 x " + i + " = " + (2*i));
		}
		for (int i = 1; i <= 9; i++) {
			System.out.println("4 x " + i + " = " + (4*i));
		}
		
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <=9; j++) {
				System.out.println(i + " x " + j + " = " + (i*j));
			}
		}
		
		for (int i = 2; i <= 9; i++) {
			System.out.println(i + " x " + i + " = " + (i*i));
		}
		

	} // end main()

} // end class For02Main












