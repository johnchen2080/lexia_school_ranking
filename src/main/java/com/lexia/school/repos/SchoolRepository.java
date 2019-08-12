package com.lexia.school.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lexia.school.domain.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {

}
