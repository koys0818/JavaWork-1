package practice.cardcompany;

public class Card {
	
	
	// 필요한 변수, 메소드, 생성자 정의하기
	
	private int cardNumber;
	
	public Card(int count) {
		cardNumber += count;
		
	}
	
	public int getCardNumber() {
		return cardNumber;
	}
	
} // end class
