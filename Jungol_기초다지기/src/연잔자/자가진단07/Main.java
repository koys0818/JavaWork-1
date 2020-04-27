package 연잔자.자가진단07;
/*
 * 문제
2개의 정수를 입력 받아서 논리곱과 논리합의 결과를 출력하는 프로그램을 작성하시오.

(수가 0 이 아닌 경우 참으로, 0 인 경우 거짓으로 간주합니다.)

 

[JAVA]

2개의 정수를 입력 받아서 0이 아니면 참(true), 0이면 거짓(false)으로 처리하고

두 값의 논리곱과 논리합의 결과를 출력하는 프로그램을 작성하시오.

​

​hint : 정수 a를 입력받은 후 boolean c = (a != 0);을 실행하면 c에 a의 논리값이 저장된다.

 


입력 예
2 0
출력 예
0 1

[JAVA]
false true

 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		boolean a = sc.nextInt() != 0;
		boolean b = sc.nextInt() != 0;

		sc.close();
		
		
		System.out.print(a + " ");
		System.out.print(b);

	}

}
