package exer;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Number9 {

	public static void main(String[] args) throws IOException {

		String url;
		Document doc;
		Response response;
		Elements elements;

		url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn";
		doc = Jsoup.connect(url).execute().parse();
		
		elements = doc.select("#old_content").select(".tit3");

		for (int i=0; i <5; i++) {
			System.out.println((i+1) + elements.get(i).text().trim());
		}

	}

}
