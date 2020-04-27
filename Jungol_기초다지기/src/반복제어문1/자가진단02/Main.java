package 반복제어문1.자가진단02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int sum = 0;
		sc.close();
		
		while(a > 0 && a <= 100) {
			
			sum += a--;
		
		}
		
		System.out.println(sum);

	}

}
