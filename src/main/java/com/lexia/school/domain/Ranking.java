package com.lexia.school.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RANKING")
public class Ranking implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rank_id", unique = true, nullable = false)
	private Long rankId;
	
	public Long getRankId() {
		return rankId;
	}
	public void setRankId(Long rankId) {
		this.rankId = rankId;
	}
//	@Column(name = "school_id", unique = true, nullable = false)
//	private String schoolId;
	
	private int rank;
	private int year;
	
	@ManyToOne
    @JoinColumn(name="school_id", nullable=false)
    private School school;
	
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
//	public String getSchoolId() {
//		return schoolId;
//	}
//	public void setSchoolId(String schoolId) {
//		this.schoolId = schoolId;
//	}

}
