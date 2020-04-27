package com.lec.java.static03;

import java.util.Calendar;

public class Static03Main {

	public static void main(String[] args) {
		System.out.println("Singleton 디자인 패턴");
		
//		Test t1 = new Test();
//		Test t2 = new Test();
		
		Test t1 = Test.getInstance();
		System.out.println("t1: num = " + t1.getNum());
		t1.setNum(123);
		System.out.println("t1: num = " + t1.getNum());
		
		Test t2 = Test.getInstance();
		System.out.println("t2: num = " + t2.getNum());
		
		t2.setNum(500);
		System.out.println("t1: num = " + t1.getNum());
		
		// Sigleton 사용예
		//Calendar c = new Calendar();
		Calendar c = Calendar.getInstance();
		

	} // end main()

} // end class Static03Main











