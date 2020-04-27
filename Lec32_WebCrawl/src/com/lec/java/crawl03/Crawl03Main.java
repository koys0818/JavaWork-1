package com.lec.java.crawl03;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl03Main {

	public static void main(String[] args) throws IOException {
		System.out.println("Daum 실시간 검색어");
		
		String url;
		Response response;
		Document doc;
		Element element;
		Elements elements;
		
		url = "https://www.daum.net";
		response = Jsoup.connect(url).execute();
		
//		System.out.println(response.statusCode());
		
		doc = response.parse();
			
		elements = doc.select(".list_favorsch li");
		System.out.println("총 검색어 개수" + elements.size() + "개");
		System.out.println();
		for(Element e : elements) {			
			
			System.out.println(e.text().trim());
		}
		
		
		//15개
		System.out.println("\n 프로그램 종료");

	}

}
