package com.pushkar.SpringBoot_REST.controller;

import com.pushkar.SpringBoot_REST.model.JobPost;
import com.pushkar.SpringBoot_REST.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") //this allows request's from the 3000 port number (React Port)
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobPost/{postId}")
    //for returning actual data and not the view pages // we also use @RestController for all if no JSP pages
    public JobPost getJob(@PathVariable("postId") int postId) {
        return service.getJob(postId);
    }

    @GetMapping("jobPosts")
    public List<JobPost> getAlljobs() {
        return service.getAllJobPosts();
    }

    @PostMapping("jobPost")
    public void addjob(@RequestBody JobPost job) {
        service.addJobPost(job);
    }


    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost job) {
        service.updateJob(job);
        return service.getJob(job.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable("postId") int postId) {
        service.deleteJob(postId);
        return "Deleted";
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword) {
        return service.search(keyword);
    }

}