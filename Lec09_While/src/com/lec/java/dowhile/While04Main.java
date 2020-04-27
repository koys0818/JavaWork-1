package com.lec.java.dowhile;

/*
do {
	...
	...
}while(조건식) 문인 경우에는,

{...} 안에 있는 실행문들을 한번은 실행을 하고 나서
조건식을 검사하게 된다.

*/


public class While04Main {

	public static void main(String[] args) {
		System.out.println("do~while");
		
		int n = 0;
		do {
			System.out.println("카운트다운: " + n);
			n--;
		} while(n > 0);
		
		// 구구단 9단을 do~while로 출력
		
		int count = 1;
		do {
			System.out.println("9 x " + count + " = " + (9*count));
			count++;
		} while (count <= 9);
		
		
	} // end main()

} // end class While04Main









