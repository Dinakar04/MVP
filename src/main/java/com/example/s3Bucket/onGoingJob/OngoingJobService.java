package com.example.s3Bucket.onGoingJob;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.s3Bucket.Creator.CreatorDev;
import com.example.s3Bucket.Creator.CreatorRepo;
import com.example.s3Bucket.Job.Job;
import com.example.s3Bucket.Job.JobRepo;
import com.example.s3Bucket.User.UserRepo;
import com.example.s3Bucket.onGoingJob.OngoingJobRepo;


@Service
public class OngoingJobService {

    @Autowired
    OngoingJobRepo ongoingJobRepo;

    @Autowired
    CreatorRepo creatorRepo;

    @Autowired
    JobRepo jobRepo;



    public List<OngoingJobs> getAllOngoingJob(){
        return ongoingJobRepo.findAll();

    }

    public OngoingJobs addJob(OngoingJobs ongoingJobs){
        return ongoingJobRepo.save(ongoingJobs);
    }

    public boolean addToOngoigJobs(Long creatoId, Long jobId){
        Optional<CreatorDev> creatorOptional = creatorRepo.findById(jobId);
        Optional<Job> jobOptional = jobRepo.findById(jobId);

        if(creatorOptional.isEmpty() || jobOptional.isEmpty()){
            return false;
        }

        CreatorDev creatorDev = creatorOptional.get();
        Job job = jobOptional.get();

        OngoingJobs ongoingJobs;

        if(creatorDev.getOngoinJobs() == null){
            ongoingJobs = new OngoingJobs();
            ongoingJobs.setCreator(creatorDev);
        }else {
            ongoingJobs = creatorDev.getOngoinJobs();
        }

        List<Job> ongoinJobListNew = ongoingJobs.getJobsList();

        if(ongoinJobListNew == null){
            ongoinJobListNew = new ArrayList<>();
        }

        ongoinJobListNew.add(job);
        ongoingJobs.setJobsList(ongoinJobListNew);

        ongoingJobRepo.save(ongoingJobs);

        return true;
    }

    


}
