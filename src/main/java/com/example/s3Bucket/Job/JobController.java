package com.example.s3Bucket.Job;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/job")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JobController {
	
	@Autowired
	JobService jobService;
	

	@GetMapping("/all/jobs")
	public List<Job> allJobs(){
		return jobService.getAllJobs();
	}


	@PostMapping("/post/jobs/{customerId}")
	public Job postJob(@PathVariable Long customerId,
		@RequestParam String title,@RequestParam String description,
	@RequestParam int duration,
	@RequestParam String catagory,
	@RequestParam double jobFee,
	@RequestParam String devType,
	@RequestParam List<String> keyWordsJob,
	@RequestParam String forDevices,
	@RequestParam boolean resell,
	@RequestParam String PostedDate)

	{
		return jobService.creatJob(customerId,title, description, duration, catagory, jobFee, devType, keyWordsJob, forDevices, resell, PostedDate);
	}


	@PostMapping("/post/jobs/new")
	public Job postJob(@RequestBody Job job){
		return jobService.createJobBody(job);
	}

	
	@PutMapping("/job/award/creator")
	public ResponseEntity<?> setAwardedJob(@RequestParam Long jobId,@RequestParam Long creatoId){
		return jobService.awardJobToUser(jobId, creatoId);
	}



}
