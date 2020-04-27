package practice.gugu2;

public class Gugu2 {

	public static void main(String[] args) {

		int col = 3;
		int startDan = 2;
		int endDan = 9;
		for (int k = startDan; k <= endDan; k += col) {
			for (int i = 1; i <= endDan; i++) {
				for (int j = 0; j < col; j++) {
					if ((k + j) <= endDan) {
						System.out.print((k + j) + " x " + i + " = " + ((k + j) * i));
						if (j > col) continue;
						System.out.print("\t");
											}
				}
				System.out.println();
			}
		}

	}

}
