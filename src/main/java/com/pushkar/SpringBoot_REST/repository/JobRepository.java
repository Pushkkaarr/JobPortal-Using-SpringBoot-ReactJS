package com.pushkar.SpringBoot_REST.repository;

import com.pushkar.SpringBoot_REST.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JobRepository extends JpaRepository<JobPost,Integer> {

   List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);
}
//List<JobPost> jobs = new ArrayList<>();
//
//public JobRepository() {
//
//    // Java Developer Job Post
//    jobs.add(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
//            List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));
//
//    // Frontend Developer Job Post
//    jobs.add(new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
//            3, List.of("HTML", "CSS", "JavaScript", "React")));
//
//    // Data Scientist Job Post
//    jobs.add(new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
//            List.of("Python", "Machine Learning", "Data Analysis")));
//
//    // Network Engineer Job Post
//    jobs.add(new JobPost(4, "Network Engineer",
//            "Design and implement computer networks for efficient data communication", 5,
//            List.of("Networking", "Cisco", "Routing", "Switching")));
//
//    // Cybersecurity Analyst Job Post
//    jobs.add(new JobPost(8, "Cybersecurity Analyst", "Protect computer systems and networks from cyber threats",
//            4, List.of("Cybersecurity", "Network Security", "Incident Response")));
//}
//
//
//public List<JobPost> returnAllJobPosts() {
//    return jobs;
//}
//
//// method to save a job post object into arrayList
//public void addJobPost(JobPost job) {
//    jobs.add(job);
//}
