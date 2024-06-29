package com.pushkar.SpringBoot_REST.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

//     This are all annotations of LomBok , which helps to reduce code
//     by which we have not to create getter and setters for all the below variables by mentioning @Data class
@Data
@NoArgsConstructor
@AllArgsConstructor

@Component
@Entity
public class JobPost {

    @Id
    private int postId;
    private String postProfile;
    private String postDesc;
    private Integer reqExperience;
    private List<String> postTechStack;

}
