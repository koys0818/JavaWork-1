package practice.stddev;

public class StdDev {

	public static void main(String[] args) {

		// TODO
		// 임의정수 5개로 초기화한 정수로
		// 평균, 분산, 표준편차 구하기
		int [] ranArray = new int[5];
		
		for (int i = 0; i < ranArray.length; i++) {
			ranArray[i] = (int)(Math.random() * 100 + 1);
		}
		
		for(int x : ranArray) {
			System.out.print(x + " ");
		}
		System.out.println();
		
		System.out.println("평균: " + calcAvg(ranArray));
		System.out.println("분산: " + calcVariance(ranArray));
		System.out.println("표준편차: " + calcStdDev(ranArray));

	} // end main
	
	
	/**
	 * 메소드 이름 : calcAvg
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '평균값' 리턴
	 */
	public static double calcAvg(int [] arr) {
		int sum = 0;
		double avg;
		
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		avg = (double)sum / arr.length;
		
//		System.out.println("합계: " + sum);
		
		return avg;
		
	}
	
	
	/**
	 * 메소드 이름 : calcVariance
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '분산값' 리턴
	 */
	public static double calcVariance(int [] arr) {
		double sqrDevSum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			double dev = (calcAvg(arr) - arr[i]);
			sqrDevSum += dev*dev;
		}
		
		double var = sqrDevSum / arr.length;
		
		return var;
	}
	
	/**
	 * 메소드 이름 : calcStdDev
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '표준편차' 리턴
	 */
	public static double calcStdDev(int [] arr) {
		double stdDev;
		
		stdDev = Math.sqrt(calcVariance(arr));
		
		
		return stdDev;
	}

} // end class
