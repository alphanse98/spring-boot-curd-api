package com.example.springbootcurdapi.service.impl;

import com.example.springbootcurdapi.entity.FeedbackEntity;
import com.example.springbootcurdapi.repository.FeedbackRepo;
import com.example.springbootcurdapi.service.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    public final FeedbackRepo feedbackRepo;
    @Override
    public List<FeedbackEntity> getAllFeedback() {
        return feedbackRepo.findAll();
    }

    @Override
    public FeedbackEntity createFeedback( FeedbackEntity FeedbackEntity) {
        return feedbackRepo.save(FeedbackEntity);
    }
}
