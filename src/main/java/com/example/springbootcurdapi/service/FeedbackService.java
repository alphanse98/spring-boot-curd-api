package com.example.springbootcurdapi.service;

import com.example.springbootcurdapi.entity.FeedbackEntity;

import java.util.List;

public interface FeedbackService {
    List<FeedbackEntity> getAllFeedback();


    FeedbackEntity createFeedback(FeedbackEntity FeedbackEntity);
}
