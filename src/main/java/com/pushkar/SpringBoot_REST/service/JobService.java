package com.pushkar.SpringBoot_REST.service;

import com.pushkar.SpringBoot_REST.model.JobPost;
import com.pushkar.SpringBoot_REST.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    public JobRepository repo;

    // method to add a jobPost
    public void addJobPost(JobPost jobPost) {
        repo.save(jobPost);

    }
    public List<JobPost> getAllJobPosts() {
        return repo.findAll();
    }

    public JobPost getJob(int postId){
        return repo.findById(postId).orElse(new JobPost());
    }

    public void updateJob(JobPost job){
        repo.save(job);
    }

    public void deleteJob(int postId){
        repo.deleteById(postId);
    }

    public List<JobPost> search(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
    }
}
