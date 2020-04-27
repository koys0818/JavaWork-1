package practice.wordcount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

/* 1] 문서(문자열) 안의 단어의 빈도수를 계수해서 출력하기
 * 	- 대소문자 구분하지 않기 :   The 와 the 는 같은 단어
 *  - 2글자 이상만 계수하기
 *  - 구두점/기호 ",.\"\'`!?;:-()" 잘라내기
 *  - 공백 짤라내기
 * ex)
 * 	an : 234
 * 	the : 314
 * ...
 * 
 * hint]
 * 	split("\\s+")  --> String[]   
 * 	--> StringTokenizer  (혹은 정규표현식)
 *  	  --> HashMap<String, Integer>   <단어, 빈도수>  사용
 * ───────────────────────────────────────────────────────────    
 * 2] 빈도수 내림차순으로 정렬하여 출력하기
 * 	ex)
 *	1 the:113개
 *	2 she:95개
 *	3 to:85개
 *	...   
 *
 * hint]
 * 	Comparable<> 이나 Comparator<> 적용
 */

// TODO : 필요한 객체들 작성
// hint> 빈도수 담을 객체, Comparator<> ..

class WordFreq implements Comparable<WordFreq> {
	
	String word; // 발생단어
	int freq; // 빈도수
	
	public WordFreq(String word, int freq) {
		super();
		this.word = word;
		this.freq = freq;
	}

	
	// 정렬을 위해 compareTo() 오버라이딩
	@Override
	public int compareTo(WordFreq o) {
		
		if(this.freq > o.freq)
			return -1;
		
		else if(this.freq < o.freq)
			return 1;
		
		else
			return 0;
		
	}
	
	// 출력을 위해 toString() 오버라이딩
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return (this.word + ": " + this.freq + "개");
	}	
		
}

public class AliceInWonderland {
	
	public static void main(String[] args) {			
		
		System.out.println("실습: 단어 발생 빈도");
		
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		StringTokenizer sTokenizer;
		LinkedList<String> wordList = new LinkedList<String>();
		ArrayList<WordFreq> finalList = new ArrayList<WordFreq>();
		
		
		// 공백을 기준으로 하여 문장을 나눈다.
		String [] words = C.ALICE30.trim().toLowerCase().split("\\s+");
		
		// 구두점/기호를 기준으로 하여 단어를 나눈다.
		// 이를 wordList에 추가
		for (int i = 0; i < words.length; i++) {
			sTokenizer = new StringTokenizer(words[i], ",.\"\'`!?;:-()_");
				
			while(sTokenizer.hasMoreTokens()) {
				
			wordList.add(sTokenizer.nextToken());								
								
			}
		}
		
		// 발생빈도 작성
		// wordList의 요소들을 hmap에 복사
		// 두 글자 미만은 건너뛴다
		// 단어가 중복되면 빈도수를 +1 한다.
		for(String x : wordList) {
			
			if(x.length() < 2)
				continue;
			
			if(!hmap.containsKey(x)) {
				hmap.put(x, 1);
				
			} else {
				hmap.put(x, hmap.get(x) + 1);
			}
			
		}
		
		// hmap의 요소들을 이용해 WordFreq 객체를 생성하여  finalList에 복사		
		for(Map.Entry<String, Integer> e : hmap.entrySet()) {
			
			finalList.add(new WordFreq(e.getKey(), e.getValue()));			
			
		}		
		
		// 빈도수 내림차순 정렬
		Collections.sort(finalList);
		
		// 결과 출력
		for(int i = 0; i < finalList.size(); i++) {
			System.out.print((i + 1) + " ");
			System.out.println(finalList.get(i));
			
		}
				
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class




