package com.example.s3Bucket.onGoingJob;

import java.util.List;

import com.example.s3Bucket.Creator.CreatorDev;
import com.example.s3Bucket.File.FileMetadata;
import com.example.s3Bucket.Job.Job;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class OngoingJobs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ongoingJobId;
	
	@ManyToOne
	private CreatorDev creator;
	
	@ManyToMany
	private List<Job> jobs;

	


	public CreatorDev getCreator() {
		return creator;
	}

	public void setCreator(CreatorDev creator) {
		this.creator = creator;
	}

	public List<Job> getJobsList() {
		return jobs;
	}

	public void setJobsList(List<Job> jobs) {
		this.jobs = jobs;
	}

	public Long getOngoingJobId() {
		return ongoingJobId;
	}

	
	public OngoingJobs(CreatorDev creator, List<Job> jobs) {
		this.creator = creator;
		this.jobs = jobs;
	}


	public OngoingJobs() {
	}
	

}
