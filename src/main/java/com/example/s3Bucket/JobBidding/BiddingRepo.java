package com.example.s3Bucket.JobBidding;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.s3Bucket.Job.Job;

@Repository
public interface BiddingRepo extends JpaRepository<Bidding,Long>{

    List<Bidding> findByJob(Job job);
    List<Bidding> findByJobid(Long jobid);
}
