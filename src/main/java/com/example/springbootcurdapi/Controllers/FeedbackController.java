package com.example.springbootcurdapi.Controllers;
import com.example.springbootcurdapi.entity.FeedbackEntity;
import com.example.springbootcurdapi.service.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@AllArgsConstructor
@RestController
public class FeedbackController {

    public   FeedbackService FeedbackService;
    @GetMapping("get/feedback")
    public   ResponseEntity<List<FeedbackEntity>> getFeedbackData (){
        List<FeedbackEntity> res = FeedbackService.getAllFeedback();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("create/feedback")
    public  ResponseEntity<FeedbackEntity> createFeedback(@RequestBody FeedbackEntity RequestData){
        FeedbackEntity res = FeedbackService.createFeedback( RequestData);
        return new ResponseEntity<>(res,HttpStatus.CREATED);
    }

}
