package com.lec.beans;

public class CountBean {
	private int cntNumber;
	
	public CountBean(){
		System.out.println("CountBean 생성!!");
	}
	
	public void setCount(int n) {
		cntNumber += n;
	}
	
	public int getCount() {
		return cntNumber;
	}

}
