package com.lec.java.collection02;

import java.util.ArrayList;
import java.util.Iterator;

public class Collection02Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		//TODO:
		// String 타입을 담는 ArrayList를 만들고
		// 5개 이상의 String을 저장하고
		// set(), remove() 등의 메소드 사용하여
		// 임의의 것을 수정, 삭제 도 해보시고
		// 3가지 방식으로 출력해보세요
		//  for, Enhanced-for, Iterator
		ArrayList<String> arrlist = new ArrayList<String>();
		arrlist.add("aaa");
		arrlist.add("bbb");
		arrlist.add("ccc");
		arrlist.add("ddd");
		arrlist.add("eee");
		
		for(String e : arrlist) {
			System.out.println(e);
		}
		System.out.println();
		
		arrlist.set(0, "111");
		for (int i = 0; i < arrlist.size(); i++) {
			System.out.println(arrlist.get(i));
		}
		System.out.println();
		
		arrlist.remove(4);
		
		Iterator<String> itr = arrlist.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}


		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












