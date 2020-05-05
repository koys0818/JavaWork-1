package com.lec.programmers;
/*
 * 문자열 다루기 기본
문제 설명
문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 예를 들어 s가 a234이면 False를 리턴하고 1234라면 True를 리턴하면 됩니다.

제한 사항
s는 길이 1 이상, 길이 8 이하인 문자열입니다.
입출력 예
s	return
a234	false
1234	true
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringBoolean {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solution("900130"));

	}
	
	public static boolean solution(String s) {
        boolean answer = false;
        String regex; // 정규표현식
		Pattern pat;
		Matcher matcher;
		
		regex = "^\\d+$";
		pat = Pattern.compile(regex);
		matcher = pat.matcher(s);
		
		if(matcher.find() && (s.length() == 4 || s.length() == 6)) answer = true;
        
        return answer;
    }

}

/*
 * 

import java.util.*;

class Solution {
  public boolean solution(String s) {
        if (s.length() == 4 || s.length() == 6) return s.matches("(^[0-9]*$)");
        return false;
  }
}

*/

