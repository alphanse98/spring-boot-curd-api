package com.example.springbootcurdapi.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.IdentityHashMap;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Feedback")
public class FeedbackEntity {

    @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false)
private  String name;
    @Column(nullable=false)
private  String BookName;
    @Column(nullable = false)
private  String feedback;
}
