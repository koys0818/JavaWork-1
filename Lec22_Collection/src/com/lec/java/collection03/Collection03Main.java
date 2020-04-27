package com.lec.java.collection03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Collection03Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		
		//TODO:
		// Student 타입을 담는 ArrayList를 만드고
		// 사용자로부터 3개의 Student 데이터 을 입력받아서
		//       (id, name, kor, eng, math)
		// 3가지 방법으로 출력해보세요. 
		// for, Enhanced-for, Iterator
		
		ArrayList<Student> stdList = new ArrayList<Student>();
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 3; i++) {
			System.out.print("id: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("name: ");
			String name = sc.nextLine();
			System.out.print("국어, 영어, 수학: ");
			int kor = sc.nextInt();
			int eng = sc.nextInt();
			int math = sc.nextInt();
			Student stu = new Student(id, name, new Score(kor, eng, math));
			stdList.add(stu);
		}
		
		sc.close();
			
			
/*		
		Student std1 = new Student(1, "홍길동", new Score(100, 100, 100));
		Student std2 = new Student(2, "김철수", new Score(90, 95, 45));
		Student std3 = new Student(3, "이영희", new Score(70, 30, 50));
			
		
		stdList.add(std1);
		stdList.add(std2);
		stdList.add(std3);
*/		
		System.out.println();
		System.out.println("for문 사용");
		for (int i = 0; i < stdList.size(); i++) {
			System.out.println(stdList.get(i));
		}
		
		System.out.println();
		System.out.println("Enhanced for문 사용");
		for(Student x : stdList) {
			System.out.println(x);
		}
		
		System.out.println();
		System.out.println("Iterator 사용");
		Iterator itr = stdList.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class









