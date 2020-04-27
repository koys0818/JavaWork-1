package exer;

import java.util.Scanner;

public class Number4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int maxNum =0;
		int minNum =0;

		while (true) {
			int number = sc.nextInt();

			if (number == 0) {
				break;
			}

			if (number > maxNum || maxNum == 0)
				maxNum = number;
			if (number < minNum || minNum == 0)
				minNum = number;

		}
		System.out.print(maxNum + " " + minNum);

	}

}
