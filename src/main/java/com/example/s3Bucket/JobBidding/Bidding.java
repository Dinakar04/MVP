package com.example.s3Bucket.JobBidding;

import com.example.s3Bucket.Creator.CreatorDev;
import com.example.s3Bucket.Job.Job;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Bidding {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long bidId;
    private Long jobid;
    private Long creatorId;
    @Column(length = 500)
    private String coverLetter;
    private int hours;
    private Double fee;
    private String workType;
    private String level1;
    private String level2;
    private String level3;
    private String bidStatus;
    
    @ManyToOne
    private CreatorDev creatorDev;

    @ManyToOne
    private Job job;

    public Long getBidId() {
        return bidId;
    }

    // public void setBidId(Long bidId) {
    //     this.bidId = bidId;
    // }


    

    // public String getJobTitle() {
    //     return jobTitle;
    // }

    // public void setJobTitle(String jobTitle) {
    //     this.jobTitle = jobTitle;
    // }

    
    


    public String getCoverLetter() {
        return coverLetter;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Long getJobid() {
        return jobid;
    }

    public void setJobid(Long jobid) {
        this.jobid = jobid;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getLevel1() {
        return level1;
    }

    public void setLevel1(String level1) {
        this.level1 = level1;
    }

    public String getLevel2() {
        return level2;
    }

    public void setLevel2(String level2) {
        this.level2 = level2;
    }

    public String getLevel3() {
        return level3;
    }

    public void setLevel3(String level3) {
        this.level3 = level3;
    }

    public String getBidStatus() {
        return bidStatus;
    }

    public void setBidStatus(String bidStatus) {
        this.bidStatus = bidStatus;
    }

    public CreatorDev getCreatorDev() {
        return creatorDev;
    }

    public void setCreatorDev(CreatorDev creatorDev) {
        this.creatorDev = creatorDev;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    // public Bidding( String coverLetter, int hours, Double fee, String workType, String level1,
    //         String level2, String level3, String bidStatus, CreatorDev creatorDev, Job job) {
    //     // this.jobTitle = jobTitle;
    //     this.coverLetter = coverLetter;
    //     this.hours = hours;
    //     this.fee = fee;
    //     this.workType = workType;
    //     this.level1 = level1;
    //     this.level2 = level2;
    //     this.level3 = level3;
    //     this.bidStatus = bidStatus;
    //     this.creatorDev = creatorDev;
    //     this.job = job;
    // }


    
    public Bidding() {

    }



    public Bidding(Long jobid, Long creatorId, String coverLetter, int hours, Double fee, String workType,
            String level1, String level2, String level3, String bidStatus, CreatorDev creatorDev, Job job) {
     
        this.jobid = jobid;
        this.creatorId = creatorId;
        this.coverLetter = coverLetter;
        this.hours = hours;
        this.fee = fee;
        this.workType = workType;
        this.level1 = level1;
        this.level2 = level2;
        this.level3 = level3;
        this.bidStatus = bidStatus;
        this.creatorDev = creatorDev;
        this.job = job;

    }


    public Bidding(Long jobid, String coverLetter, int hours, Double fee, String workType, String level1, String level2,
            String level3, String bidStatus, CreatorDev creatorDev, Job job) {

        this.jobid = jobid;
        this.coverLetter = coverLetter;
        this.hours = hours;
        this.fee = fee;
        this.workType = workType;
        this.level1 = level1;
        this.level2 = level2;
        this.level3 = level3;
        this.bidStatus = bidStatus;
        this.creatorDev = creatorDev;
        this.job = job;

    }


    public Bidding(Long jobid, String coverLetter, int hours, Double fee, String workType, String level1, String level2,
            String level3, String bidStatus) {

        this.jobid = jobid;
        this.coverLetter = coverLetter;
        this.hours = hours;
        this.fee = fee;
        this.workType = workType;
        this.level1 = level1;
        this.level2 = level2;
        this.level3 = level3;
        this.bidStatus = bidStatus;
        
    }

    
    
}
