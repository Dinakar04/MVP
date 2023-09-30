package com.example.s3Bucket.File;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class FileMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filename;

    @Column(length = 500)
    private String description;

    private Double price;

    private String s3Link;

    private String objectKey;

    private int likes = 0;

    private String catagory;

    //@DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    
    private List<String> s3Links;
    private String objectKeyVid;
    private String objectKeyimgi;
    private String objectKeyimgii;
    
    
//    private String previewFile1;
//    private String previewFile2;
//    private String previewFile3;

//    private byte[] previewData1;
//    private byte[] previewData2;
//    private byte[] previewData3;
   
    
    
    // constructers
    
    public FileMetadata(String filename, String description, Double price, String s3Link, int likes, String catagory,LocalDate date,List<String> s3Links,String objectKeyVid, String objectKeyimgi, String objectKeyimgii) {
        
        this.filename = filename;
        this.description = description;
        this.price = price;
        this.s3Link = s3Link;
        this.likes = likes;
        
        this.catagory = catagory;
        this.date = date;
        this.s3Links = s3Links;
        this.objectKeyVid = objectKeyVid;
        this.objectKeyimgi = objectKeyimgi;
        this.objectKeyimgii = objectKeyimgii;
        
    }



// public FileMetadata(String filename, String description, Double price, String s3Link, int likes, String catagory,LocalDate date, String previewFile1, byte[] previewData1,String previewFile2, byte[] previewData2,String previewFile3,byte[] previewData3) {
//        
//        this.filename = filename;
//        this.description = description;
//        this.price = price;
//        this.s3Link = s3Link;
//        this.likes = likes;
//        
//        this.catagory = catagory;
//        this.date = date;
//        this.previewFile1 = previewFile1;
//        this.previewData1 = previewData1;
//        this.previewFile2 = previewFile2;
//        this.previewData2 = previewData2;
//        this.previewFile3 = previewFile3;
//        this.previewData3 = previewData3;
//        
//    }


    
    
    public FileMetadata() {
    	
    }

    
    
    
    // getters and setters
    
//    public String getPreviewFile1() {
//        return previewFile1;
//    }
//
//
//    public void setPreviewFile1(String previewFile1) {
//        this.previewFile1 = previewFile1;
//    }
//
//    
//    
//    public String getPreviewFile2() {
//        return previewFile2;
//    }
//
//   
//   
//    public void setPreviewFile2(String previewFile2) {
//        this.previewFile2 = previewFile2;
//    }
//
//   
//    
//    public String getPreviewFile3() {
//        return previewFile3;
//    }
//
//    
//    public void setPreviewFile3(String previewFile3) {
//        this.previewFile3 = previewFile3;
//   }
//
//    
//    public byte[] getPreviewData1() {
//        return previewData1;
//    }
//
//    
//    
//    public void setPreviewData1(byte[] previewData1) {
//        this.previewData1 = previewData1;
//    }
//
//    
//    
//    public byte[] getPreviewData2() {
//        return previewData2;
//    }
//
//    
//    
//    public void setPreviewData2(byte[] previewData2) {
//        this.previewData2 = previewData2;
//    }
//
//    
//    
//    public byte[] getPreviewData3() {
//        return previewData3;
//    }
//
//    
//    
//    public void setPreviewData3(byte[] previewData3) {
//        this.previewData3 = previewData3;
//    }

    
    
    public int getLikes() {
        return likes;
    }


    
    public void setLikes(int likes) {
        this.likes = likes;
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

    
    
    public String getCatagory() {
        return catagory;
    }

    
    
    public void setCatagory(String catagory) {
        this.catagory = catagory;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }



	public List<String> getS3Links() {
		return s3Links;
	}



	public void setS3Links(List<String> s3Links) {
		this.s3Links = s3Links;
	}



	public String getObjectKeyVid() {
		return objectKeyVid;
	}



	public void setObjectKeyVid(String objectKeyVid) {
		this.objectKeyVid = objectKeyVid;
	}



	public String getObjectKeyimgi() {
		return objectKeyimgi;
	}



	public void setObjectKeyimgi(String objectKeyimgi) {
		this.objectKeyimgi = objectKeyimgi;
	}



	public String getObjectKeyimgii() {
		return objectKeyimgii;
	}



	public void setObjectKeyimgii(String objectKeyimgii) {
		this.objectKeyimgii = objectKeyimgii;
	}
    
	
    
}