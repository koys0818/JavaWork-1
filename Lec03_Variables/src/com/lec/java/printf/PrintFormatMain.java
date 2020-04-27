package com.lec.java.printf;

public class PrintFormatMain {

	public static void main(String[] args) {
		System.out.println("서식화된 출력: printf(), String.format()");
		
		double pi = Math.PI; // 원주율 값
		System.out.println(pi);
		
		// printf : print with format
		// printf("서식문자열", 값1, 값2, ...)
		// '서식문자열' 안에는 %로 시작하는 서식지정자들
		
		System.out.printf("원주율 %f\n", pi);
		System.out.printf("원주율 %.4f\n", pi);
		
		int age = 10;
		short grade = 3;
		
		System.out.printf("제 나이는 %d살입니다. 학년은 %d학년입니다\n", age, grade);
		
		//소숫점 이하 제한
		double height = 182.3;
		System.out.printf("저는 %d살입니다. 키는 %.1fcm입니다.\n", age, height);
		
		//출력폭 지정, 좌우 정렬
		System.out.printf("|%d|%d|%d|\n", 100, 200, 300);
		System.out.printf("|%5d|%5d|%5d|\n", 100, 200, 300); // 출력폭 5칸, 우측정렬(기본)
		System.out.printf("|%-5d|%-5d|%-5d|\n", 100, 200, 300); // 출력폭 5칸, 우측정렬(기본)

		System.out.printf("제 이름은 [%10s]입니다. 혈액형은 %c 형입니다.\n", "봉준호", 'B');
		
		double rate = 134423.0 / 345678.0;
		System.out.printf("합격율은 %.1f%%입니다", rate);
		
		System.out.printf("|%05d|%05d|%05d|\n", 100, 200, 300);
		
		String fmt = "주소 : %s, 우편번호[%05d]";
		System.out.printf(fmt + "\n", "서울", 12345);
		System.out.printf(fmt + "\n", "광주", 44);
		System.out.printf(fmt + "\n", "대구", 776);
		
		String.format("합격율은 %.1f%% 입니다", rate);
		String result = String.format("합격율은 %.1f%% 입니다", rate);
		System.out.println(result);
	}

}
