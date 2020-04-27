package 선택제어문.자가진단05;

import java.util.Scanner;

/*
 * 문제
두 개의 실수를 입력받아 모두 4.0 이상이면 "A", 모두 3.0 이상이면 "B", 아니면 "C" 라고 출력하는 프로그램을 작성하시오.


입력 예
4.3 3.5
출력 예
B

입력 예
4.0 2.9
출력 예
C

 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		float grade1 = sc.nextFloat();
		float grade2 = sc.nextFloat();
		sc.close();
		
		if(grade1 >= 4.0 && grade2 >= 4.0) {
			System.out.println("A");
		} else if(grade1 >= 3.0 && grade2 >= 3.0) {
			System.out.println("B");
		} else {
			System.out.println("C");
		}

	}

}
