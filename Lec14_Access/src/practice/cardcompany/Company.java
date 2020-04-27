package practice.cardcompany;

public class Company {

	
	// 필요한 변수, 메소드, 생성자 정의하기
	private static Company instance = null;
	private int count = 10000; //인스턴스는 하나만 있기 떄문에 static으로 안해도 이 값은 보전된다.
	
	private Company() {}
	
	public static Company getInstance() {
		if(instance == null) {
			instance = new Company();
		}
		return instance;
	}
	
	public Card createCard() {
		count++;
		return new Card(count);
	}
		
} // end class
