package com.example.s3Bucket.File;

public class VideoDto {

	
	private byte[] videoData;

	
	public byte[] getVideoData() {
		return videoData;
	}

	public void setVideoData(byte[] videoData) {
		this.videoData = videoData;
	}

	public VideoDto(byte[] videoData) {
		super();
		this.videoData = videoData;
	}

	
	
	public VideoDto() {
		super();
	}
	
	
	
}
