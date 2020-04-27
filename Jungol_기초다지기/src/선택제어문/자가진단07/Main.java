package 선택제어문.자가진단07;

import java.util.Scanner;

/*
 * 문제
영문 대문자를 입력받아 

'A'이면 “Excellent”, 

'B'이면 “Good”, 

'C'이면 “Usually”, 

'D'이면 “Effort”, 

'F'이면 “Failure”, 

그 외 문자이면 “error” 라고 출력하는 프로그램을 작성하시오.


입력 예
B
출력 예
Good

Hint!

문자열 입력시 앞뒤에 공백이 포함될 경우가 있는데 strip() 함수를 사용하여 문제를 해결할 수 있다.

 

예) str = input().strip()​



 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		String grade = sc.next();
		sc.close();
						
		switch(grade) {
		case "A":
			System.out.println("Excellent");
			break;
		case "B":
			System.out.println("Good");
			break;
		case "C":
			System.out.println("Usually");
			break;
		case "D":
			System.out.println("Effort");
			break;
		case "F":
			System.out.println("Failure");
			break;
		default:
			System.out.println("error");
		}

	}

}
