package com.example.springbootcurdapi.repository;

import com.example.springbootcurdapi.entity.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepo extends JpaRepository<FeedbackEntity, Long> {

}