package com.lec.java.collection04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Collection04Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		
		// Member 타입을 담는 ArrayList를 만드고
		// 사용자로부터 2개의 Member 데이터 을 입력받아서
		//       (id, passwd)
		// 3가지 방법으로 출력해보세요. 
		// for, Enhanced-for, Iterator

		ArrayList<MemberModel> list = new ArrayList<MemberModel>();
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i <2; i++) {
			System.out.print("ID를 입력하세요");
			String id = sc.nextLine();
			System.out.print("비밀번호를 입력하세요");
			String passwd = sc.nextLine();
			
			MemberModel member = new MemberModel(id,passwd);
			list.add(member);
						
		}
		sc.close();
		
		System.out.println();
		//출력
		for(MemberModel x : list) {
			x.displayInfo();
		}
		
		System.out.println();
		Iterator<MemberModel> itr = list.iterator();
		while(itr.hasNext()) {
			itr.next().displayInfo();
		}
		
		
		
		
		
		
		

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












