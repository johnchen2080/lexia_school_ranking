package com.lexia.school.client;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.lexia.school.domain.Ranking;
import com.lexia.school.domain.School;

public class SchoolDiggerUtil {
	public static List<School> getSchoolListFromJson(String schoolRankingListJson) {
		ArrayList<School> schoolList = new ArrayList<School>();
		JSONObject schoolRankingListJsonObj = new JSONObject(schoolRankingListJson);
		
		JSONArray schoolListJsonArray = schoolRankingListJsonObj.getJSONArray("schoolList");
		for(int i=0; i<schoolListJsonArray.length(); i++) {
			JSONObject schoolJsonObj = schoolListJsonArray.getJSONObject(i);
			JSONArray rankingHistoryJsonArray = schoolJsonObj.getJSONArray("rankHistory");
			School school = new School();
			school.setName(schoolJsonObj.getString("schoolName"));
			school.setSchoolId(schoolJsonObj.getString("schoolid"));
			for(int j=0; j<rankingHistoryJsonArray.length(); j++) {
				JSONObject rankingJsonObj = rankingHistoryJsonArray.getJSONObject(j);
				Ranking ranking = new Ranking();
				ranking.setRank(rankingJsonObj.getInt("rank"));
				ranking.setYear(rankingJsonObj.getInt("year"));
				ranking.setSchool(school);
				school.getRankingList().add(ranking);
			}
			schoolList.add(school)	;
			
		}

		return schoolList;
		
	}
}
