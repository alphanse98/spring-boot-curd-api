package com.example.springbootcurdapi.Controllers;
import com.example.springbootcurdapi.entity.FeedbackEntity;
import com.example.springbootcurdapi.service.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(
        origins = {
                "http://localhost:3000",
                "*",
        },
        methods = {
                RequestMethod.OPTIONS,
                RequestMethod.GET,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.POST
        })
@AllArgsConstructor
@RestController
public class FeedbackController {

    public   FeedbackService FeedbackService;
    @GetMapping("get/feedback")
    public   ResponseEntity<List<FeedbackEntity>> getFeedbackData (){
        List<FeedbackEntity> res = FeedbackService.getAllFeedback();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

//    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
    @PostMapping("create/feedback")
    public  ResponseEntity<FeedbackEntity> createFeedback(@RequestBody FeedbackEntity RequestData){
        FeedbackEntity res = FeedbackService.createFeedback( RequestData);
        return new ResponseEntity<>(res,HttpStatus.CREATED);
    }

}
