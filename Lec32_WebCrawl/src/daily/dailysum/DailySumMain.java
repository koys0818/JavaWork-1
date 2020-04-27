package daily.dailysum;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * 연습 : 자치구단위 서울 생활인구 일별 집계표
 * ■자치구단위 서울 생활인구 일별 집계표
 * 	http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-15379&srvType=S&serviceKind=1&currentPageNo=1
 * 	http://openapi.seoul.go.kr:8088/(인증키)/(요청파일타입)/SPOP_DAILYSUM_JACHI/(요청시작INDEX)/(요청종료INDEX)/(기준일ID)/(시군구코드)
 * 
 * 샘플url
 * 	XML 버젼
 * 	http://openapi.seoul.go.kr:8088/(인증키)/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * 	JSON 버젼
 * 	http://openapi.seoul.go.kr:8088/66647253736c65653935736e764b47/json/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/	
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * ※ 한번에 1000개 까지의 데이터만 볼수 있슴
 * 
 */

/*  입력예]
 *  날짜입력: 20190101
 *  시작Index : 1
 *  끝Index: 5
 *  
 *  [XML]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490
 *   
 *  [JSON]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490 
 * 
 */

// ★ 주목 ★
// XML 은 Jsoup 를 활용하여 파싱하세요
// JSON 은  jackson 을 활용하여 파싱하세요

public class DailySumMain {

	public static final String API_KEY = "66647253736c65653935736e764b47";

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("날짜입력: ");
		String date = sc.nextLine();
		System.out.print("시작Index: ");
		int startIndex = sc.nextInt();
		System.out.print("끝Index: ");
		int endIndex = sc.nextInt();
		

		parseXml(startIndex, endIndex, date);
		parseJson(startIndex, endIndex, date);

	} // end main

	public static String buildUrlAddress(String reqType, int startIndex, int endIndex, String date) {
		String url_address = String.format("http://openapi.seoul.go.kr:8088/%s/%s/SPOP_DAILYSUM_JACHI/%d/%d/%s", 
				API_KEY, reqType, startIndex, endIndex, date);

		return url_address;
	} // end buildUrlAddress

	public static void parseXml(int startIndex, int endIndex, String date) throws IOException {
		String url = buildUrlAddress("xml", startIndex, endIndex, date);
		
		Document doc = Jsoup.connect(url).parser(Parser.xmlParser()).get();
		Elements elements = doc.select("row");
		
		System.out.println("[XML]");
		System.out.printf("%-16s\t\t%-16s\t\t%-16s\t%-16s\n", "날짜", "구ID", "총생활인구수", "일최대이동인구수");
		System.out.println("----------------------------------------------------------------------");
		
		
		for(Element e : elements) {
			
			String dateId = e.selectFirst("STDR_DE_ID").text().trim();
			String guId = e.selectFirst("SIGNGU_CODE_SE").text().trim();
			String totLvpop = e.selectFirst("TOT_LVPOP_CO").text().trim();
			String dailMaxm = e.selectFirst("DAIL_MXMM_MVMN_LVPOP_CO").text().trim();
			
			System.out.printf("%-16s\t%-16s\t%-16s\t%-16s\n", 
					dateId, guId, totLvpop, dailMaxm);
			
			
		}	
		
		System.out.println();
		
	}
	
	public static void parseJson(int startIndex, int endIndex, String date) throws IOException {
		String url_addr = buildUrlAddress("json", startIndex, endIndex, date);
		URL url = new URL(url_addr);
		ObjectMapper mapper = new ObjectMapper();
		
		Jachi jachi = mapper.readValue(url, Jachi.class);
		
		System.out.println("[JSON]");
		System.out.printf("%-16s\t\t%-16s\t\t%-16s\t%-16s\n", "날짜", "구ID", "총생활인구수", "일최대이동인구수");
		System.out.println("----------------------------------------------------------------------");
		
		for (int i = 0; i < jachi.getSPOP_DAILYSUM_JACHI().getRow().size(); i++) {
			
			String dateId = jachi.getSPOP_DAILYSUM_JACHI().getRow().get(i).getSTDR_DE_ID();
			String guId = jachi.getSPOP_DAILYSUM_JACHI().getRow().get(i).getSIGNGU_CODE_SE();
			String totLvpop = jachi.getSPOP_DAILYSUM_JACHI().getRow().get(i).getTOT_LVPOP_CO();
			String dailMaxm = jachi.getSPOP_DAILYSUM_JACHI().getRow().get(i).getDAIL_MXMM_MVMN_LVPOP_CO();
			System.out.printf("%-16s\t%-16s\t%-16s\t%-16s\n", 
					dateId, guId, totLvpop, dailMaxm);
			
		}		
		
		System.out.println();
	}

} // end class	
	

@JsonIgnoreProperties(ignoreUnknown = true)
class Jachi {
	public Spop SPOP_DAILYSUM_JACHI;
	
	public Jachi() {}

	public Jachi(Spop sPOP_DAILYSUM_JACHI) {
		super();
		SPOP_DAILYSUM_JACHI = sPOP_DAILYSUM_JACHI;
	}

	public Spop getSPOP_DAILYSUM_JACHI() {
		return SPOP_DAILYSUM_JACHI;
	}

	public void setSPOP_DAILYSUM_JACHI(Spop sPOP_DAILYSUM_JACHI) {
		SPOP_DAILYSUM_JACHI = sPOP_DAILYSUM_JACHI;
	}
	
	
	
}


@JsonIgnoreProperties(ignoreUnknown = true)
class Spop {
	public List<SpopInfo> row;
	
	public Spop() {}
	
	

	public Spop(List<SpopInfo> row) {
		super();
		this.row = row;
	}



	public List<SpopInfo> getRow() {
		return row;
	}

	public void setRow(List<SpopInfo> row) {
		this.row = row;
	}
	
	
	
}


@JsonIgnoreProperties(ignoreUnknown = true)
class SpopInfo {
	public String STDR_DE_ID;
	public String SIGNGU_CODE_SE;
	public String TOT_LVPOP_CO;
	public String DAIL_MXMM_MVMN_LVPOP_CO;
	
	public SpopInfo() {}
	
	

	public SpopInfo(String sTDR_DE_ID, String sIGNGU_CODE_SE, String tOT_LVPOP_CO, String dAIL_MXMM_MVMN_LVPOP_CO) {
		super();
		STDR_DE_ID = sTDR_DE_ID;
		SIGNGU_CODE_SE = sIGNGU_CODE_SE;
		TOT_LVPOP_CO = tOT_LVPOP_CO;
		DAIL_MXMM_MVMN_LVPOP_CO = dAIL_MXMM_MVMN_LVPOP_CO;
	}



	public String getSTDR_DE_ID() {
		return STDR_DE_ID;
	}

	public void setSTDR_DE_ID(String sTDR_DE_ID) {
		STDR_DE_ID = sTDR_DE_ID;
	}

	public String getSIGNGU_CODE_SE() {
		return SIGNGU_CODE_SE;
	}

	public void setSIGNGU_CODE_SE(String sIGNGU_CODE_SE) {
		SIGNGU_CODE_SE = sIGNGU_CODE_SE;
	}

	public String getTOT_LVPOP_CO() {
		return TOT_LVPOP_CO;
	}

	public void setTOT_LVPOP_CO(String tOT_LVPOP_CO) {
		TOT_LVPOP_CO = tOT_LVPOP_CO;
	}

	public String getDAIL_MXMM_MVMN_LVPOP_CO() {
		return DAIL_MXMM_MVMN_LVPOP_CO;
	}

	public void setDAIL_MXMM_MVMN_LVPOP_CO(String dAIL_MXMM_MVMN_LVPOP_CO) {
		DAIL_MXMM_MVMN_LVPOP_CO = dAIL_MXMM_MVMN_LVPOP_CO;
	}	

	
	
	
		
} // end class