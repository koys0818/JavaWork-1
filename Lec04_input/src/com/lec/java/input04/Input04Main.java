package com.lec.java.input04;

import java.util.Scanner;

public class Input04Main {

	public static void main(String[] args) {
		
		System.out.println("입력: 문자열 -> 숫자 변환");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자 3개(int, int, int)를 입력받으세요>");
		String in1 = sc.next();
		int i1 = Integer.parseInt(in1);
		
		int i2 = Integer.parseInt(sc.next());
		int i3 = Integer.parseInt(sc.next());
		
		System.out.println("합: " + (i1 + i2 + i3));
		
		System.out.println("숫자 3개(double, double, double)를 입력받으세요>");
		
					
		String d1 = sc.next();
		double db1 = Double.parseDouble(d1);
		
		double db2 = Double.parseDouble(sc.next());
		double db3 = Double.parseDouble(sc.next());
		
		System.out.println("곱: " + (db1 * db2 * db3));
		
		sc.close();

	}

}
