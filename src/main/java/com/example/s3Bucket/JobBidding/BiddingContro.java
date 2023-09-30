package com.example.s3Bucket.JobBidding;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;


@RestController
@RequestMapping("/api/v1/bid")
public class BiddingContro {
    
    @Autowired
    BiddingService bidService;

    // @PostMapping("/add/bid/{jobId}/{creatoId}")
    // public Bidding addBid(@PathVariable Long jobId, @PathVariable Long creatoId, @RequestBody Bidding bidding){
    //     return bidService.placeBid(creatoId, jobId, bidding);
    // }

    @PostMapping("/add/bid/")
    public Bidding placeBidding(@RequestBody Bidding bid){
        return bidService.placeBid(bid);
    }

    @GetMapping("/get/bids")
    public List<Bidding> getAllBid(Long jobid){
        return bidService.getAllBidForJob(jobid);
    }

    

}
