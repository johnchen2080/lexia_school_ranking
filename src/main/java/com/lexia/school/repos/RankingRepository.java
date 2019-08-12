package com.lexia.school.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lexia.school.domain.Ranking;

public interface RankingRepository extends JpaRepository<Ranking, Long> {

}
