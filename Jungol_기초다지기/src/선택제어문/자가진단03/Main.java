package 선택제어문.자가진단03;

import java.util.Scanner;

/*
 * 문제
나이를 입력받아 20살 이상이면 "adult"라고 출력하고 그렇지 않으면 몇 년후에 성인이 되는지를 "○ years later"라는 메시지를 출력하는 프로그램을 작성하시오.

입력 예
18
출력 예
2 years later

 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int age = sc.nextInt();
		sc.close();
		
		if(age >= 20) {
			System.out.println("adult");
		}else {
			System.out.println(20-age + " years later");
		}

	}

}
