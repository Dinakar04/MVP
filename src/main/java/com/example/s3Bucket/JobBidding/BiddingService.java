package com.example.s3Bucket.JobBidding;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.s3Bucket.Creator.CreatorDev;
import com.example.s3Bucket.Creator.CreatorRepo;
import com.example.s3Bucket.Job.Job;
import com.example.s3Bucket.Job.JobRepo;

import jakarta.persistence.EntityNotFoundException;


@Service
public class BiddingService {
    

    @Autowired
    CreatorRepo creatorRepo;

    @Autowired
    BiddingRepo biddingRepo;

    @Autowired
    JobRepo jobRepo;

    
    // public  Bidding placeBid(Long creatorId, Long jobId, Bidding bidding){
    //     // Optional<CreatorDev> creatorOptional = creatorRepo.findById(creatorId);
    //     CreatorDev creator = creatorRepo.findById(creatorId).orElseThrow(() -> new EntityNotFoundException("Creator not found"));
        
    //     Job job = jobRepo.findById(jobId).orElseThrow(() -> new EntityNotFoundException("Job not found"));

    //     bidding.setCreatorDev(creator);
    //     bidding.setJob(job);

    //     job.addBid(bidding);

    //     return biddingRepo.save(bidding);

    // }


    public Bidding placeBid(Bidding bid){
        return biddingRepo.save(bid);
    }

    public void deleteBid(Long bidId){
        biddingRepo.deleteById(bidId);
    }


    public List<Bidding> getAllBidForJob(Long jobid){
        return biddingRepo.findByJobid(jobid);
    }

}
