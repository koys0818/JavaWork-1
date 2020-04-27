package com.lec.java.crawl09;

import java.io.IOException;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//연습
//네이버 '검색어'
//블로그
// - post title
// - post url
// - blog title

//페이징 구현!
public class Crawl09Main {

	public static void main(String[] args) throws IOException {
		System.out.println("네이버 검색, 페이징\n");
		
		for (int i = 1; i <= 10; i++) {
			
			crawlDaumBlog("파이썬", i);
		}
		
		
		
	} // end main()

	
	public static void crawlDaumBlog(String search, int page) throws IOException {
		// https://search.naver.com/search.naver?date_from=&date_option=0&date_to=&dup_remove=1&nso=&post_blogurl=&post_blogurl_without=&query=%ED%8C%8C%EC%9D%B4%EC%8D%AC&sm=tab_pge&srchby=all&st=sim&where=post&start=11
		
		if(search == null || search.trim().length() == 0 || page < 1) return;
		
		System.out.println(page + " 페이지");
		
		String url;
		Document doc;
		Elements elements;
		
		
		url = String.format("https://search.naver.com/search.naver?date_from=&date_option=0&date_to=&dup_remove=1&nso=&post_blogurl=&post_blogurl_without=&query=%s&sm=tab_pge&srchby=all&st=sim&where=post&start=%d", 
				URLEncoder.encode(search, "utf-8") , (page * 10 -9));
		
		doc = Jsoup.connect(url).execute().parse();
		elements = doc.select("#elThumbnailResultArea li");
		
		for(Element e: elements) {
			String postTit = e.selectFirst("dt").text().trim();
			String blogTit = e.select("dd.txt_block .inline a:nth-child(1)").text().trim();
			String postUrl = e.select("dd.txt_block .inline a:nth-child(2)").attr("href").trim();
			
			
			System.out.println(postTit + " : " + blogTit + "\n" + postUrl);
			System.out.println();
		}
		
		
		
		
		
	} // end crawlDaumBlog()
	
	
} // end class
