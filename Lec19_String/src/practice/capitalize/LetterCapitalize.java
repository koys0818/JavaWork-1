package practice.capitalize;

import java.util.Arrays;
import java.util.Scanner;

/* LetterCapitalize
 * 	문장을 입력하고,  단어의 앞 문자를 대문자로 만들어 출력하기를 반복하다가
 *  quit 을 입력 받으면 종료하기
 * 
 * 	[입력예]
 * 		hello my world
 *  [출력예]
 * 		Hello My World  
 */

public class LetterCapitalize {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String line;
		String[] words;

		while (true) {
			line = sc.nextLine();
			if (line.trim().equals("quit"))
				break;

			line = line.toLowerCase(); // 일단 소문자로 변환
			words = line.split("\\s+"); // 공백 기준단어 쪼개기

			for (String word : words) {
				if (word.length() > 0) {

					// 아글자 떼어내기
					String firstLetter = word.substring(0, 1).toUpperCase();
					String rest = word.substring(1); // 나머지 문자열
					System.out.print(firstLetter + rest + " "); // 최종 출력
				}
			}
			System.out.println();
		}

		sc.close();

	} // end main()
} // end class
