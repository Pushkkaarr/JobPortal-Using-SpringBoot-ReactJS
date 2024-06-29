package com.pushkar.SpringBoot_REST.repository;

import com.pushkar.SpringBoot_REST.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JobRepository extends JpaRepository<JobPost,Integer> {

  List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);
}