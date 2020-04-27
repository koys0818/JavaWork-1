package com.lec.java.if07;

/* String 비교, char 비교
 * - 문자열 비교는 절대로 == 를 사용하지 말자
 * - 문자열 비교는 equals(), equalsIgnoreCase() 사용!
 * 
 * - char 는 기본적으로 정수값 (아스키 코드값) 이라 일반 산술 비교 가능 
 */

public class If07Main {

	public static void main(String[] args) {
		System.out.println("String 비교, char 비교");
	
		// TODO
		String str1 = "john";
		String str2 = "john";
		
		System.out.println("Str1 = " + str1);
		System.out.println("Str2 = " + str2);
		
		if(str1 == str2) {
			System.out.println("둘은 같습니다");
		} else {
			System.out.println("둘은 다릅니다");
		}
		
		
		// 문자열 비교는 절대로 == 를 사용하지 말자
		// TODO
		String str3 = "jo";
		String str4 = str3 + "hn";
		System.out.println("str4 = " + str4);
		
		if(str1 == str4) {
			System.out.println("== 둘은 같습니다");
		} else {
			System.out.println("== 둘은 다릅니다");
		}
		
		// 문자열 비교는 equals() 사용!
		// TODO
		if(str1.equals(str4)) {
			System.out.println("equals() 둘은 같습니다");
		} else {
			System.out.println("equals() 둘은 다릅니다");
		}
		
		String str5 = "John";
		
		System.out.println(str1.equals(str5));
		System.out.println(str1.equalsIgnoreCase(str5));
		

		System.out.println();
		// char 는 기본적으로 정수값 (아스키 코드값) 이라
		// 일반 산술 비교가 가능.
		// TODO
		
		char ch = '%';
		if('0' <= ch && ch <= '9') {
			System.out.println("숫자입니다");
		} else if('A' <= ch && ch <= 'Z') {
			System.out.println("대문자 입니다");
		} else if('a' <= ch && ch <= 'z') {
			System.out.println("소문자 입니다");
		} else {
			System.out.println("숫자도 알파벳도 아닙니다");
		}
		

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
