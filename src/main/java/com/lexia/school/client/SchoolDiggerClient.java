package com.lexia.school.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.lexia.school.domain.School;

@Service
public class SchoolDiggerClient {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${school.digger.api.host}")
	private String schoolDiggerHost;

	private String rankingListApi = "v1.2/rankings/schools/{st}";

	@Value("${school.digger.appid}")
	private String appID;

	@Value("${school.digger.appkey}")
	private String appKey;

	public SchoolDiggerClient() {

	}

	public List<School> getSchools(String state, int ranking_year) {
		ArrayList<School> schoolList = new ArrayList<School>();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

		// Example API call to get school ranking list:
		// https://api.schooldigger.com/v1.2/rankings/schools/MA?year=2019-2015&appID=a49f5fe5&appKey=4a7599f21913b07fbc9f9c491b4cf84c
		String url = schoolDiggerHost + "/" + rankingListApi;

		// URI (URL) parameters
		Map<String, String> uriParams = new HashMap<String, String>();
		uriParams.put("st", state);

		// Query parameters
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
				// Add query parameter
				.queryParam("year", ranking_year).queryParam("appID", appID).queryParam("appKey", appKey);

		System.out.println(builder.buildAndExpand(uriParams).toUri());

		HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(builder.buildAndExpand(uriParams).toUri(),
				HttpMethod.GET, requestEntity, String.class);
		
		String jsonResponse = response.getBody();
		schoolList = (ArrayList<School>) SchoolDiggerUtil.getSchoolListFromJson(jsonResponse);
		
		System.out.println("Response from school digger service: " + jsonResponse);

		return schoolList;
	}
}
