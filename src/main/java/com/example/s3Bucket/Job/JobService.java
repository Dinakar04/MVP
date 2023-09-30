package com.example.s3Bucket.Job;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.s3Bucket.JobBidding.Bidding;
import com.example.s3Bucket.User.Customer;
import com.example.s3Bucket.User.UserRepo;

@Service
public class JobService {
	
	@Autowired
	JobRepo jobRepo;
	
	@Autowired
	UserRepo userRepo;
	
	public List<Job> getAllJobs(){
		return jobRepo.findAll();
	}

	
	
	public Job creatJob(Long customerId,
		String title, String description,
                            int duration,
                            String catagory,
                            double jobFee,
                            String devType,
                            List<String> keyWordsJob,
                            String forDevices,
                            boolean resell,
                            String postedDate) {

		
		Optional<Customer> customerOptional = userRepo.findById(customerId);

		Customer customer = customerOptional.get();

		Job job = new Job();
		job.setTitle(title);
		job.setDescription(description);
		job.setDuration(duration);
		job.setJobFee(jobFee);
		// job.setDevType(devType);
		// job.setKeyWordsJob(keyWordsJob);
		// job.setForDevices(forDevices);
		job.setResell(resell);
		job.setPostedDate(postedDate);
		job.setCustomer(customer);
		return jobRepo.save(job);
		
	}

	

	public Job createJobBody( Job job){
		return jobRepo.save(job);
	}

	
	public ResponseEntity<?> awardJobToUser(Long jobid,Long creatoId){

		Optional<Job> existingJobOptional = jobRepo.findById(creatoId);

		if (!existingJobOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Job existingJob = existingJobOptional.get();

		existingJob.setAwardedTo(creatoId);

		return ResponseEntity.ok(existingJob);

	}

	// public List<String> addJobType(String jobType)
	

}