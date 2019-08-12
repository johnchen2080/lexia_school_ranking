package com.lexia.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lexia.school.client.SchoolDiggerClient;
import com.lexia.school.domain.School;
import com.lexia.school.repos.RankingRepository;
import com.lexia.school.repos.SchoolRepository;

/**
 * school ranking app controller to request
 * 
 * @author jchen
 *
 */
@RestController
public class SchoolDiggerController {
	@Autowired
	SchoolDiggerClient schoolDiggerClient;
	@Autowired
	SchoolRepository schoolRepo;
	@Autowired
	RankingRepository rankingRepo;
	

	@RequestMapping("/schoolranking/getSchoolRankings/{year}")
	public ResponseEntity<String> getSchoolRankings(@PathVariable("year") int ranking_year) {
		String response = "";
		HttpHeaders headers = new HttpHeaders();
		String state = "MA";
		// int ranking_year = 2018;

		List<School> schoolList = schoolDiggerClient.getSchools(state, ranking_year);

		if (!schoolList.isEmpty()) {
			schoolRepo.saveAll(schoolList);
			
			for(School school:schoolList) {
				rankingRepo.saveAll(school.getRankingList());
			}
			
			response = schoolList.size()
					+ " schools and rankings saved to the database.  Please see the tables for details.";
		} else {
			response = "Operation has been executed but no schools and rankings are available.";
			return new ResponseEntity<String>(response, headers, HttpStatus.OK);
		}
		return new ResponseEntity<String>(response, headers, HttpStatus.OK);
	}
}
