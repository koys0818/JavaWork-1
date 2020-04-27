package 반복제어문3.형성평가03;

import java.util.Scanner;

/*
 * 문제
자연수 n을 입력받아 "출력 예"와 같이 출력되는 프로그램을 작성하시오.
주의! '*'과 '*'사이에 공백이 없고 줄사이에도 빈줄이 없다.


입력 예
3
출력 예
*
**
***
**
*

 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.close();

		if (n > 0) {

			int i = 0;
			for (i = 1; i <= n; i++) {
				for (int j = 0; j < i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}

			for (int p = i; p > 0; p--) {
				for (int k = (p - 2); k > 0; k--) {
					System.out.print("*");
				}
				System.out.println();
			}

		}
	}

}
