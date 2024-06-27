package com.pushkar.SpringBoot_REST;

import com.pushkar.SpringBoot_REST.model.JobPost;
import com.pushkar.SpringBoot_REST.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins  ="https://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService service;


    @GetMapping("jobPost/{postId}")
    @ResponseBody
    //for returning actual data and not the view pages // we also use @RestController for all if no JSP pages
    public JobPost getJob(@PathVariable("postId") int postId) {
        return service.getJob(postId);
    }

    @GetMapping("jobPosts")
    @ResponseBody
    public List<JobPost> getAlljobs() {
        return service.getAllJobPosts();
    }

    @PostMapping("/addjob")
    public String addjob() {
        return "addjob";
    }

    //    this explicilty tell this method uses POST , takes data from addjob Page and saves it .
    @PostMapping("/handleForm")
    public String handleForm(JobPost jobPost) {
        service.addJobPost(jobPost);
        return "success";
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost job) {
        service.updateJob(job);
        return service.getJob(job.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    @ResponseBody
    public String deleteJob(@PathVariable("postId") int postId) {
        service.deleteJob(postId);
        return "Deleted";
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    @ResponseBody // needs to mention here cause not using RESTController
    public String searchByKeyword(@PathVariable("keyword") String keyword, Model model) {
        List<JobPost> jobPosts = service.search(keyword);
        model.addAttribute("jobPosts", jobPosts);
        return "jobpostlist";
    }

    @GetMapping("/viewalljobs")
    public String viewJobs(Model model) {
        List<JobPost> jobPosts = service.getAllJobPosts();
        model.addAttribute("jobPosts", jobPosts);
        return "viewalljobs";
    }
}


