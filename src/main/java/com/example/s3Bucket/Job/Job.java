package com.example.s3Bucket.Job;




import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.s3Bucket.JobBidding.Bidding;
import com.example.s3Bucket.User.Customer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Job {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long jobId;

	private Long customeId;

	private String title;

	@Column(length = 500)
	private String description;

	private int duration;

	private String catagory;

	private double jobFee;

	private String devType;

	private List<String> keyWordsJob;

	private String forDevices;

	private boolean resell;

	private Long awardedTo;

	private String PostedDate;

	private boolean level1;
	private boolean level2;
	private boolean level3;
	private boolean userContract;
	private boolean contract;


	// @ManyToOne
	// private Customer customer;

	public Job(Long customeId, String title, String description, int duration, String catagory, double jobFee,
			String devType, List<String> keyWordsJob, String forDevices, boolean resell, Long awardedTo,
			String postedDate, boolean level1, boolean level2, boolean level3, boolean userContract, boolean contract) {
		this.customeId = customeId;
		this.title = title;
		this.description = description;
		this.duration = duration;
		this.catagory = catagory;
		this.jobFee = jobFee;
		this.devType = devType;
		this.keyWordsJob = keyWordsJob;
		this.forDevices = forDevices;
		this.resell = resell;
		this.awardedTo = awardedTo;
		PostedDate = postedDate;
		this.level1 = level1;
		this.level2 = level2;
		this.level3 = level3;
		this.userContract = userContract;
		this.contract = contract;
	}

	public boolean isUserContract() {
		return userContract;
	}

	public void setUserContract(boolean userContract) {
		this.userContract = userContract;
	}

	@ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;




	@OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
    private List<Bidding> bids = new ArrayList<>();

	public void addBid(Bidding bidding) {
        bids.add(bidding);
        bidding.setJob(this);
    }

	// public void addBid(Bidding bid){
	// 	bids.add(bid);
	// }

	


	public List<Bidding> getBids() {
		return bids;
	}

	public boolean isContract() {
		return contract;
	}

	public void setContract(boolean contract) {
		this.contract = contract;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Long getCustomeId() {
		return customeId;
	}

	public void setCustomeId(Long customeId) {
		this.customeId = customeId;
	}

	public void setBids(List<Bidding> bids) {
		this.bids = bids;
	}

	public String getPostedDate() {
		return PostedDate;
	}

	public void setPostedDate(String postedDate) {
		PostedDate = postedDate;
	}

	public boolean isLevel1() {
		return level1;
	}

	public void setLevel1(boolean level1) {
		this.level1 = level1;
	}

	public boolean isLevel2() {
		return level2;
	}

	public void setLevel2(boolean level2) {
		this.level2 = level2;
	}

	public boolean isLevel3() {
		return level3;
	}

	public void setLevel3(boolean level3) {
		this.level3 = level3;
	}

	public String getDate() {
		return PostedDate;
	}

	// public Customer getCustomer() {
	// 	return customer;
	// }

	// public void setCustomer(Customer customer) {
	// 	this.customer = customer;
	// }

	public Long getAwardedTo() {
		return awardedTo;
	}

	public void setAwardedTo(Long awardedTo) {
		this.awardedTo = awardedTo;
	}

	

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public String getForDevices() {
		return forDevices;
	}

	public void setForDevices(String forDevices) {
		this.forDevices = forDevices;
	}

	public boolean isResell() {
		return resell;
	}

	public void setResell(boolean resell) {
		this.resell = resell;
	}

	public Job(String title, String description, int durationDays, String catagory, double jobFee, String devType,
			List<String> keyWordsJob, String forDevices, boolean resell, String postedDate, boolean level1,
			boolean level2, boolean level3) {
		super();
		this.title = title;
		this.description = description;
		this.duration = durationDays;
		this.catagory = catagory;
		this.jobFee = jobFee;
		this.devType = devType;
		this.keyWordsJob = keyWordsJob;
		this.forDevices = forDevices;
		this.resell = resell;
		this.PostedDate = postedDate;
		this.level1 = level1;
		this.level2 = level2;
		this.level3 = level3;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDuration(int durationDays) {
		this.duration = durationDays;
	}

	public void setJobFee(double jobFee) {
		this.jobFee = jobFee;
	}

	public void setDevType(String devType) {
		this.devType = devType;
	}

	public void setKeyWordsJob(List<String> keyWordsJob) {
		this.keyWordsJob = keyWordsJob;
	}

	public Long getId() {
		return jobId;
	}

	// public void setId(long id) {
	// this.jobId = id;
	// }

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public int getDuration() {
		return duration;
	}

	public double getJobFee() {
		return jobFee;
	}

	public String getDevType() {
		return devType;
	}

	public List<String> getKeyWordsJob() {
		return keyWordsJob;
	}

	public Job(String title, String description, int durationDays, double jobFee, String devType,
			List<String> keyWordsJob) {
		super();
		this.title = title;
		this.description = description;
		this.duration = durationDays;
		this.jobFee = jobFee;
		this.devType = devType;
		this.keyWordsJob = keyWordsJob;
	}

	

	public Job(Long customeId, String title, String description, int duration, String catagory, double jobFee,
			String devType, List<String> keyWordsJob, String forDevices, boolean resell, Long awardedTo,
			String postedDate, boolean level1, boolean level2, boolean level3, 
			List<Bidding> bids) {
		this.customeId = customeId;
		this.title = title;
		this.description = description;
		this.duration = duration;
		this.catagory = catagory;
		this.jobFee = jobFee;
		this.devType = devType;
		this.keyWordsJob = keyWordsJob;
		this.forDevices = forDevices;
		this.resell = resell;
		this.awardedTo = awardedTo;
		PostedDate = postedDate;
		this.level1 = level1;
		this.level2 = level2;
		this.level3 = level3;
		// this.customer = customer;
		this.bids = bids;
	}

	

	public Job(Long customeId, String title, String description, int duration, String catagory, double jobFee,
			String devType, List<String> keyWordsJob, String forDevices, boolean resell, Long awardedTo,
			String postedDate, boolean level1, boolean level2, boolean level3, boolean contract) {
		this.customeId = customeId;
		this.title = title;
		this.description = description;
		this.duration = duration;
		this.catagory = catagory;
		this.jobFee = jobFee;
		this.devType = devType;
		this.keyWordsJob = keyWordsJob;
		this.forDevices = forDevices;
		this.resell = resell;
		this.awardedTo = awardedTo;
		PostedDate = postedDate;
		this.level1 = level1;
		this.level2 = level2;
		this.level3 = level3;
		this.contract = contract;
	}

	
	public Job() {
		super();
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

}
