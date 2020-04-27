package 반복제어문1.자가진단06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1. Korea");
			System.out.println("2. USA");
			System.out.println("3. Japan");
			System.out.println("4. China");
			System.out.print("number? ");
			int choice = sc.nextInt();
			System.out.println();

			if (choice >= 1 && choice <= 4) {

				switch (choice) {
				case 1:
					System.out.println("Seoul");
					System.out.println();
					break;

				case 2:
					System.out.println("Washington");
					System.out.println();
					break;

				case 3:
					System.out.println("Tokyo");
					System.out.println();
					break;

				case 4:
					System.out.println("Beijing");
					System.out.println();
					break;

				}
			} else {
				System.out.println("none");
				System.out.println();
				break;

			}

		}
		sc.close();

	}

}
