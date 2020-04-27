package practice.maxwords;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/* MaxWrod
	여러문장으로 구성된 문자열을 입력받은뒤 
	문자열에서 가장 단어의 개수가 많은 문장을 찾아서, 
	그 문장과 문장의 단어의 개수를 출력
	'문장'의 구분은  .(마침표) !(느낌표) ?(물음표) 로 한다.
	'단어'구분은 '공백' 으로 한다
	
	입력예]
	We test coders. Give us a try. Can you make it out? It's awesome.
	
	출력예]
	5개
	Can you make it out
 */
public class MaxWord {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 유저로부터 문장을 입력 받는다.
		String sentence = sc.nextLine();
		sc.close();
		
		// 입력된 문장을 보여준다.
		System.out.println(sentence);

		// 문장을 ".!?" 을 기준으로 쪼개어 배열에 입력.
		String[] spltsent = splitSentence(sentence);

		// 단어가 가장 많은 문장과 단어 수를 찾아 출력
		findMaxword(spltsent);

	} // end main

	/**
	 * 문장을 ".!?" 을 기준으로 쪼개어 배열에 입력 후 리턴.
	 * 
	 * @param sentence 문장
	 * @return 쪼갠 문자열
	 */
	public static String[] splitSentence(String sentence) {
		StringTokenizer tokenizer = new StringTokenizer(sentence, ".!?");
		String[] sepSent = new String[tokenizer.countTokens()];

		while (tokenizer.hasMoreTokens()) {

			for (int i = 0; i < sepSent.length; i++) {
				sepSent[i] = tokenizer.nextToken().trim();
			}

		}

		return sepSent;

	}

	/**
	 * 배열원소 중 단어 수가 가장 많은 것을 찾아 문자열과 단어 수를 알려준다.
	 * 
	 * @param arr 문장들이 입력되어 있는 배열
	 */
	public static void findMaxword(String[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j].split("\\s+").length < arr[j + 1].split("\\s+").length) {
					String temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		System.out.println(arr[0].split("\\s+").length + "개");
		System.out.println(arr[0]);

	}

} // end class
