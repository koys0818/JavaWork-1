package com.lec.java.crawl04;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Scanner;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl04Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("네이버 연관 검색어");
		
		String url;
		Document doc;
		Response response;
		Elements elements;
		
		String searchKeyword;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색어를 입력하세요: ");
		searchKeyword = sc.nextLine();		
		sc.close();
		
		String encoded = URLEncoder.encode(searchKeyword, "utf-8"); //네이버 검색페이지는 utf-8로 url encode
		
		url = "https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=" + encoded;
		
//		System.out.println(url); // 생성된 url 확인
		
		doc = Jsoup.connect(url).execute().parse();
		
		elements = doc.select("._related_keyword_ul li");
		System.out.println("관련 검색어 : " + elements.size() + "개");
		
		for(Element e : elements) {
			System.out.println(e.text().trim());
		}
		
	}

}
