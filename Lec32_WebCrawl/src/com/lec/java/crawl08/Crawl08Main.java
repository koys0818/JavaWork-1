package com.lec.java.crawl08;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * - 첫페이지 url
 * - 두번째 페이지부터의 url 변화 확인 : 어떤 방식? 어떤 parameter 사용?
 * - 검색결과페이징의 '마지막 페이지'는 어떻게 처리하는지 확인
 */
public class Crawl08Main {

	public static void main(String[] args) throws IOException {
		System.out.println("페이징 : Pagination");
		
		for (int i = 0; i < 10; i++) {
			crawlDaumBlog("파이썬", i);
			
		}
		
		

		System.out.println("\n프로그램 종료");
	}

	/**
	 * 
	 * @param search 검색어
	 * @param page   검색할 결과 page 번호
	 * @throws IOException 
	 */
	public static void crawlDaumBlog(String search, int page) throws IOException {

		// 목록에서크롤링 할 내용
		// post title
		// post link url
		// blog title
		
		
		// 매개변수 검증
		if (search == null || search.trim().length() == 0 || page < 1)
			return;

		String url;
		Document doc;
		Elements elements;
		Element element;
		
		System.out.println(page + " 페이지");

		url = String.format("https://search.daum.net/search?w=blog&DA=PGD&enc=utf8&q=%s&page=%d",
				URLEncoder.encode(search, "utf-8"), page);
		
		doc = Jsoup.connect(url).execute().parse();
		
		elements = doc.select("#blogColl .list_info li .wrap_cont");
//		System.out.println(elements.size());
		
		for(Element e : elements) {
			String postTitle = e.selectFirst("a").text().trim();
			String blogTitle = e.selectFirst(".info .f_nb").text().trim();
			String postUrl = e.selectFirst("a").attr("href").trim();
			
			System.out.println(postTitle + " : " + blogTitle + "\n" + postUrl);
			System.out.println();
			
		}

	} // end crawlDaumBlog

}
