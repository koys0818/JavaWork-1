package com.lec.java.inner09;

public class Button {

	String name;
	
	public Button(String name) {
		this.name = name;
	}
	
	// 클릭시 수행하는 리스너  제공
	// 리스너 인터페이스 : OnClickListener
	//         - 를릭시 동작 메소드 : onClick();
	// 장착 메소드 : setOnClickListener
	//---------------------------------------------------
	// 리스너 인터페이스
	public static interface OnClickListner {
		void onClick(); //클릭했을 때 동작, 추상메소드
	}
	
	// 장착 리스너
	private OnClickListner clickListner = null;
	
	
	// 리스너 장착 메소드
	public Button setOnClickListener(OnClickListner clickListner) {
		this.clickListner = clickListner;
		return this;
	}
	
	//----------------------------------------------
	public void actionClick() {
		System.out.println(name + " 버튼 클릭! (시스템 기본동작)");
		
		if(clickListner != null)
			clickListner.onClick(); // 장착된 리스너 수행
		
	}
	
	
	// TODO
	// 더블클릭시 수행하는 리스너를  제공해보세요
	// 리스너 인터페이스 : OnDblClickListener
	//         - 더블를릭시 동작 메소드 : onDblClick();
	// 장착 메소드 : setOnDBlClickListener
	
	//---------------------------------------------------
	// 리스너 인터페이스
	public static interface OnDblClickListener {
		void onDblClick();
	}
	
	// 장착 리스너
	private OnDblClickListener dblClickListner;
	
	// 리스너 장착 메소드
	public Button setOnDblClickListner(OnDblClickListener dblClickListener) {
		this.dblClickListner = dblClickListener;
		return this;		
	}
	
	//----------------------------------------------
	public void actionDblClick() {
		System.out.println(name + " 버튼 더블 클릭!");
		
		if(dblClickListner != null) {
			dblClickListner.onDblClick(); // 장착된 리스너 수행!
		}
		
	}
	
	
	
	
} // end class
