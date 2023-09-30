package com.example.s3Bucket.VideoResponse;

import org.springframework.stereotype.Service;

@Service
public class VideoResponse {
    
    private byte[] videoData;

    public byte[] getBytefromVideo(){
        return videoData;
    }


    public void setbyteVideo(byte[] videodata){
         this.videoData = videodata;
    }


}
