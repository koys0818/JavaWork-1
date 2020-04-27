package practice.game369;

public class Game369 {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				int number = (i - 1) * 10 + j;

				if (number / 10 == 3 || number / 10 == 6 || number / 10 == 9) {
					System.out.print("*\t");

				} else if (number % 10 == 3 || number % 10 == 6 || number % 10 == 9) {
					System.out.print("*\t");
					
				} else {

					System.out.print(number + "\t");
				}
			}
			System.out.println();
		}

	}
}
