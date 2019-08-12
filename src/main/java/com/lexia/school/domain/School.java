package com.lexia.school.domain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "SCHOOL")
public class School implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="school_name")
    private String name;
	
	@Column(name="school_id")
    private String schoolId;
    
    @OneToMany(mappedBy="school")
    private List<Ranking> rankingList = new ArrayList<Ranking>();
    
   
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Ranking> getRankingList() {
		return rankingList;
	}
	public void setRankingList(List<Ranking> rankingList) {
		this.rankingList = rankingList;
	}
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
    
}
