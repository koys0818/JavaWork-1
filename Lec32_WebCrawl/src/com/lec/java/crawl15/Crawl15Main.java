package com.lec.java.crawl15;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * XML, JSON 파싱 연습
 * ■서울시 지하철 역사 정보
http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12753&srvType=A&serviceKind=1&currentPageNo=1

샘플url

XML 버젼
http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/xml/stationInfo/1/5/서울

JSON 버젼
http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/json/stationInfo/1/5/서울


 */

public class Crawl15Main {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		
		ObjectMapper mapper = new ObjectMapper();
		URL url = new URL("http://swopenapi.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/json/stationInfo/1/5/%EC%84%9C%EC%9A%B8");
		
		Subway subway = mapper.readValue(url, Subway.class);
		
//		System.out.println(subway.getStationList());
		
		for(int i =0; i < subway.getStationList().size(); i++) {
			
			System.out.println(subway.getStationList().get(i).getRowNum() + ": " +
					subway.getStationList().get(i).getStatnNm()+ "역 " + 
					subway.getStationList().get(i).getSubwayId() + " " + 
					subway.getStationList().get(i).getSubwayNm());
		}

	}

}

@JsonIgnoreProperties(ignoreUnknown = true)
class Subway {
	public List<StationList> stationList;
	
	public Subway() {}

	public Subway(List<StationList> stationList) {
		super();
		this.stationList = stationList;
	}

	public List<StationList> getStationList() {
		return stationList;
	}

	public void setStationList(List<StationList> stationList) {
		this.stationList = stationList;
	}

	
	
}

@JsonIgnoreProperties(ignoreUnknown = true)
class StationList {
	
	int rowNum;
	String statnNm;
	int subwayId;
	String subwayNm;
	
	public StationList() {}
	
	public StationList(int rowNum, String statnNm, int subwayId, String subwayNm) {
		super();
		this.rowNum = rowNum;
		this.statnNm = statnNm;
		this.subwayId = subwayId;
		this.subwayNm = subwayNm;
	}
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	public String getStatnNm() {
		return statnNm;
	}
	public void setStatnNm(String statnNm) {
		this.statnNm = statnNm;
	}
	public int getSubwayId() {
		return subwayId;
	}
	public void setSubwayId(int subwayId) {
		this.subwayId = subwayId;
	}
	public String getSubwayNm() {
		return subwayNm;
	}
	public void setSubwayNm(String subwayNm) {
		this.subwayNm = subwayNm;
	}
	
	
	
}
