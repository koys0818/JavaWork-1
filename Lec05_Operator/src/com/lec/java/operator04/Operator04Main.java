package com.lec.java.operator04;

/* 증감 연산자(++, --) Increment / Decrement Operator
 *  	++변수: 변수의 값을 1 증가시켜서 저장
 *   	--변수: 변수의 값을 1 감소시켜서 저장
 *  
 *   증감연산자: prefix(접두사), postfix(접미사)
 *   	접두사(prefix)인 경우에는, 증감(++, --)이 먼저 된 후 다른 연산자가 동작
 *   	접미사(postfix)인 경우에는, 다른 연산자 먼저 실행된 후 증감(++, --)가 동작
 */
public class Operator04Main {

	public static void main(String[] args) {
		System.out.println("연산자 4 - 증감 연산자(++, --) Increment / Decrement Operator");
		
		int num1 = 100;
		System.out.println("num1 = " + num1);
		
//		++ : 변수값 1 증가
		++num1;
		System.out.println("num1 = " + num1);
		
		System.out.println("\n\n======================");
		System.out.println("증감연산자: prefix(접두사), postfix(접미사)");
		
		// TODO
		
		System.out.printf("아직 %d를 넘지%n못했습니다%n", 100);
		
		int num10 = 100;
		int num11 = num10-- + 200;
		System.out.println("num10 = " + num10 + " num11 = " + num11);
		
		
		System.out.println("\n프로그램 종료");
	} // end main

} // end class












