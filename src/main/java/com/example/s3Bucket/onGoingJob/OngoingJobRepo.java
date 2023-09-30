package com.example.s3Bucket.onGoingJob;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import org.springframework.stereotype.Repository;

@Repository
public interface OngoingJobRepo extends JpaRepository<OngoingJobs, Long>{


}
