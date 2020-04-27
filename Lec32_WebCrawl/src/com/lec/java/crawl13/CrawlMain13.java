package com.lec.java.crawl13;
/*
 * Jackson 라이브러리
 * 	Java Object를 JSON으로 변환하거나 JSON을 Java Object로 변환하는데 사용할 수 있는 Java 라이브러리입니다.
 * 		Jackson Github - https://github.com/FasterXML/jackson
 * 
 * Jackson 특징
 * 	1.Stream API : 스트림 형식으로 데이터를 분석하고 생성하기 때문에 성능이 좋습니다.
 * 	2.Tree Model : XML의 DOM 처럼 Node 형태로 데이터를 다룰 수 있기 때문에 유연성이 좋습니다.
 * 	3.Data Binding : POJO 기반의 자바 객체들을 JSON으로 변환시킬 수 있습니다.
 * 
 * Maven 설정
 * 	jackson-databind 라이브러리는 jackson-core 및 jackson-annotation 라이브러리의 의존성을 포함하기 때문에 메이븐을 사용하는 경우 jackson-databind 라이브러리만 추가해주시면 됩니다.
 * 
 * MVNrepository :
 * 	https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
 * 	https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core
 * 	https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations
 * 
 * JS의 배열 <-> Java의 List<>
 * JS의 object <-> Java의 객체(Class)
 * 
 */

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CrawlMain13 {

	public static void main(String[] args) {
		System.out.println("jackson-databind 사용");
		
		User user = new User();
		user.setName("제이슨");
		user.setAge(10);
		user.setScore1(new Score(100, 80, 75));
		List<String> list = new ArrayList<String>();
		list.add("JSON은 Javascript Object Notation의 약자입니다.");
		list.add("JSON은 데이터 교환 포맷으로 인기 짱입니다.");
		list.add("JSON은 배열이 있습니다.(XML보다 장점!)");
		list.add("JSON은 타입 검증에 대해선 XML보다 약합니다.");
		user.setMessages(list);
		
		javaToJson(user);
		
		jsonToJava();
		
		
		
		System.out.println("\n프로그램 종료");
	}// end main()
	
	//Java 객체 --> JSON 변환
	public static void javaToJson(User user) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File("data/user.json"), user);
			
			// Java 객체 ---> JSON 문자열
			System.out.println(mapper.writeValueAsString(user));
			
			//JSON 문자열 변환시 이쁜 포맷?(prety format)
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user));
			
			//이쁜 포맷으로 JSON 파일 저장
			mapper.writerWithDefaultPrettyPrinter().writeValue(
					new File("data/user2.json"), user);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // end javatoJson()
	
	//JSON --> Java객체로 변환
	public static void jsonToJava() {
		ObjectMapper mapper = new ObjectMapper();
		
		// JSON 파일 ---> Java 객체
		
		try {
			User user1 = mapper.readValue(new File("data/myuser.json"), User.class);
			System.out.println(user1);
						
			
			URL url = new URL("http://openapi.seoul.go.kr:8088/66647253736c65653935736e764b47/json/CardSubwayStatsNew/1/5/20181001");
			
			Subway subway= mapper.readValue(url, Subway.class);
			System.out.println(subway.CardSubwayStatsNew.list_total_count);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

} // end class

@JsonIgnoreProperties(ignoreUnknown = true)
class Subway {
	Stats CardSubwayStatsNew;

	public Stats getCardSubwayStatsNew() {
		return CardSubwayStatsNew;
	}

	public void setCardSubwayStatsNew(Stats cardSubwayStatsNew) {
		CardSubwayStatsNew = cardSubwayStatsNew;
	}
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Stats {
	int list_total_count;

	public int getList_total_count() {
		return list_total_count;
	}

	public void setList_total_count(int list_total_count) {
		this.list_total_count = list_total_count;
	}
	
	
}


