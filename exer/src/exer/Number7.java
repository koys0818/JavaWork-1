package exer;

public class Number7 {

	public static void parse(String str) {

		float f;

		try {

			f = Float.parseFloat(str);

		} catch (NumberFormatException nfe) {

			f = 0;

			System.out.println(f);

		}

	}

	public static void main(String[] args) {

		parse("invalid");

	}

}
