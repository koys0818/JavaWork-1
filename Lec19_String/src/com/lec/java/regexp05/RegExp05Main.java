package com.lec.java.regexp05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 대표적인 정규 표현식 
 *  구글링 하면 대표적인 정규표현식들이 많이 구할수 있습니다.
 *  각 정규표현식들을 작성해보고
 *	매칭되는 문자열과 그렇지 않은 것들을 출력해봅시다.   
 */
public class RegExp05Main {

	public static void main(String[] args) {
		System.out.println("많이 쓰는 정규표현식");

		String regex, intput, title;
		String [] arrInput;
		
		//─────────────────────────────────────────
		title = "URL";
		regex = "^((http|https)://)?(www.)?([a-zA-Z0-9]+)\\.[a-z]+([a-zA-Z0-9.?#]+)/?$?";
		arrInput = new String[] {
			"https://www.google.com",
			"google.com",
			"www.google.com",
			"https://www.google.com/",
			
			
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		
		//─────────────────────────────────────────
		title = "email";
		regex = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
		arrInput = new String[] {
			"kdash111@gmail.com",
			"kdash111@nate.com"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "주민등록번호";
		regex = "^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))-[1-4][0-9]{6}$";
		arrInput = new String[] {
			"890101-1621564",
			"890101-162154",
			"89011-1621564",
			"89011-1621564111",
			
		};
		System.out.println(title);
		regExpTest(regex, arrInput);
		
		//─────────────────────────────────────────
		title = "날짜 YYYY-MM-DD";
		regex = "^\\d{4}-((0[1-9])|(1[0-2]))-((0[1-9])|([1-2]\\d)|(3[0-1]))$"; // TODO
		arrInput = new String[] {
			"2020-03-23",
			"2020-03-234",
			"2020-3-23",
			"2020-13-21",
			"2020-12-33",
			"1558-12-31"
			
		};
		System.out.println(title);
		regExpTest(regex, arrInput);
		
		//─────────────────────────────────────────
		title = "자연수";
		regex = "^[1-9][0-9]*$"; // TODO
		arrInput = new String[] {
			"1231526651",
			"123",
			"98952615415",
			"1",
			"0",
			"0125",
			"25212363a"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "정수";
		regex = "^(0|-?[1-9][0-9]*)$"; // TODO
		arrInput = new String[] {
			"0123456",
			"4445454545",
			"74465",
			"sdfsdf",
			"3432d"
			
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "소수";
		regex = "^(0|-?[1-9][0-9]*)[.]\\d+$"; // TODO
		arrInput = new String[] {
			"0.54545545",
			"56566.524564",
			".5454554",
			"000.524545",
			"-4552.5456"
			
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "소숫점 둘째자리까지";
		regex = "^(0|-?[1-9][0-9]*)[.]\\d{2}$"; // TODO
		arrInput = new String[] {
				"0.54545545",
				"56566.52",
				"3.54",
				"000.524545",
				"2.22",
				"065.21",
				"448.31",
				"-56.50"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "통화표시 (￦)";
		regex = "^￦(0|[1-9]\\d{0,2}(,\\d{3})*)"; // TODO
		arrInput = new String[] {
			"￦0",
			"￦1",
			"￦10",
			"￦100",
			"￦200,",
			"2,300",
			"544,558",
			"565,6",
			"￦6999,56",
			"￦654,650"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		System.out.println("프로그램 종료");

	} // end main()

	// 도우미 함수
	public static void regExpTest(String regex, String[] arrInput) {
		for (String input : arrInput)
			regExpTest(regex, input);
	}

	public static void regExpTest(String regex, String input) {
		System.out.println("[정규표현식 매칭 테스트]-----------------");
		System.out.println("정규표현식: " + regex);
		System.out.println("입력문자열: " + input);

		if(Pattern.matches(regex, input)) {
			System.out.println("   ●매칭●");
		} else {
			System.out.println("   Ⅹ매칭 없슴Ⅹ");
		}
		
		System.out.println();
	} // end regExpTest()

} // end class
