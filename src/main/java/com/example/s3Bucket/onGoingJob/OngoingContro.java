package com.example.s3Bucket.onGoingJob;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/onjob")
public class OngoingContro {


    @Autowired
    OngoingJobService onJobService;

    @GetMapping("/get/alljob")
    public List<OngoingJobs> getAlljob(){
       return  onJobService.getAllOngoingJob();
    }

    @PostMapping("/post/onjob")
    public OngoingJobs newOnjob(OngoingJobs ongoingJobs){
        return onJobService.addJob(ongoingJobs);
    }
}
