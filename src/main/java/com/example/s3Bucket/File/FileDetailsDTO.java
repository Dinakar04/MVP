package com.example.s3Bucket.File;

import java.time.LocalDate;

import jakarta.persistence.Column;

public class FileDetailsDTO {

	
	private Long id;
    private String filename;
    private String description;
    private Double price;
    private String s3Link;
    private String objectKey;
    private int likes = 0;
    private String catagory;
    private LocalDate date;
    private String previewFile1;
    private String previewFile2;
    private String previewFile3;
    private byte[] previewData2;
    private byte[] previewData3;
    
	public byte[] getPreviewData2() {
		return previewData2;
	}


	public void setPreviewData2(byte[] previewData2) {
		this.previewData2 = previewData2;
	}


	public byte[] getPreviewData3() {
		return previewData3;
	}


	public void setPreviewData3(byte[] previewData3) {
		this.previewData3 = previewData3;
	}


	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getFilename() {
		return filename;
	}
	
	
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
	public String getDescription() {
		return description;
	}
	
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public Double getPrice() {
		return price;
	}
	
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	public String getS3Link() {
		return s3Link;
	}
	
	
	public void setS3Link(String s3Link) {
		this.s3Link = s3Link;
	}
	
	
	public String getObjectKey() {
		return objectKey;
	}
	
	
	public void setObjectKey(String objectKey) {
		this.objectKey = objectKey;
	}
	
	
	public int getLikes() {
		return likes;
	}
	
	
	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	
	public String getCatagory() {
		return catagory;
	}
	
	
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	
	
	public LocalDate getDate() {
		return date;
	}
	
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	public String getPreviewFile1() {
		return previewFile1;
	}
	
	
	public void setPreviewFile1(String previewFile1) {
		this.previewFile1 = previewFile1;
	}
	
	
	public String getPreviewFile2() {
		return previewFile2;
	}
	
	
	public void setPreviewFile2(String previewFile2) {
		this.previewFile2 = previewFile2;
	}
	
	
	public String getPreviewFile3() {
		return previewFile3;
	}
	
	
	public void setPreviewFile3(String previewFile3) {
		this.previewFile3 = previewFile3;
	}
	
	
	public FileDetailsDTO(Long id, String filename, String description, Double price, String s3Link, String objectKey,
			int likes, String catagory, LocalDate date, String previewFile1, String previewFile2, String previewFile3, byte[] previewData2, byte[] previewData3) {
		super();
		this.id = id;
		this.filename = filename;
		this.description = description;
		this.price = price;
		this.s3Link = s3Link;
		this.objectKey = objectKey;
		this.likes = likes;
		this.catagory = catagory;
		this.date = date;
		this.previewFile1 = previewFile1;
		this.previewFile2 = previewFile2;
		this.previewFile3 = previewFile3;
		this.previewData2 = previewData2;
		this.previewData3 = previewData3;
	}
	
	
	public FileDetailsDTO() {
		super();
	}

	
//	 public static FileDetailsDTO convertIntoDetailsStat(FileMetadata fileMetadata) {
//     	
//     	
//     	FileDetailsDTO fileDetails = new FileDetailsDTO();
//     	
//     	
//     	fileDetails.setId(fileMetadata.getId());
//     	fileDetails.setFilename(fileMetadata.getFilename());
//     	fileDetails.setDescription(fileMetadata.getDescription());
//     	fileDetails.setPrice(fileMetadata.getPrice());
//     	fileDetails.setS3Link(fileMetadata.getS3Link());
//     	fileDetails.setObjectKey(fileMetadata.getObjectKey());
//     	fileDetails.setLikes(fileMetadata.getLikes());
//     	fileDetails.setCatagory(fileMetadata.getCatagory());
//     	fileDetails.setDate(fileMetadata.getDate());
//     	fileDetails.setPreviewFile1(fileMetadata.getPreviewFile1());
//     	fileDetails.setPreviewFile2(fileMetadata.getPreviewFile2());
//     	fileDetails.setPreviewFile3(fileMetadata.getPreviewFile3());
//     	fileDetails.setPreviewData2(fileMetadata.getPreviewData2());
//     	fileDetails.setPreviewData3(fileMetadata.getPreviewData3());
//     	
//     	
//     	return fileDetails;
//     	
//     }
	
}
