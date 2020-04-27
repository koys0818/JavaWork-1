package com.lec.java.crawl02;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl02Main {

	public static void main(String[] args) throws IOException {
		System.out.println("네이트 인기 검색어");
		
		String url;
		Response response;
		Document doc;
		Element element;
		Elements elements;
		
		url = "https://www.nate.com";
		response = Jsoup.connect(url).execute();
		
//		System.out.println(response.statusCode());
		
		doc = response.parse();
//		System.out.println(doc.title());		
		
		elements = doc.select(".search_keyword a");
		System.out.println("인기검색어 " + elements.size() + "개");
		System.out.println();
		
		for(Element e : elements) {		
			
			System.out.println(e.text().trim());
		}
		
			
		System.out.println("\n 프로그램 종료");
	}

}
