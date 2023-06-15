package com.takeo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.takeo.entity.HomeTask;
@Repository
public interface HomeTaskRepository extends JpaRepository<HomeTask, Long> {

}
