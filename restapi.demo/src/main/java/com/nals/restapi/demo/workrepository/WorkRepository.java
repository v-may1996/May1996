package com.nals.restapi.demo.workrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nals.restapi.demo.workmodel.Work;

@Repository
public interface WorkRepository extends JpaRepository<Work, Long> {

}
