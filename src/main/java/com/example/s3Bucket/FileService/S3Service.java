package com.example.s3Bucket.FileService;


import com.amazonaws.services.kms.model.NotFoundException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.util.IOUtils;
import com.example.FileNotFoundException.FileNotFoundException;
import com.example.s3Bucket.File.FileDetailsDTO;
import com.example.s3Bucket.File.FileMetadata;
import com.example.s3Bucket.File.VideoDto;
import com.example.s3Bucket.FileRepo.FileMetaDataRepository;
import com.example.s3Bucket.VideoResponse.VideoResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;
import lombok.extern.slf4j.Slf4j;


// import java.io.File;
// import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
// import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import java.io.InputStream;

@Service
@Slf4j
public class S3Service {


    @Value("${application.bucket.name}")
    private String bucketName;


    @Autowired
    private AmazonS3 s3Client;


    @Autowired
    FileMetaDataRepository fileMetadataRepository;

    @Autowired
    VideoResponse videoResponse;

    // public String uploadFile(MultipartFile file) {
    //     File fileObj = convertMultiPartFileToFile(file);
    //     // System.currentTimeMillis() + "_" +
    //     String fileName =  file.getOriginalFilename();
    //     s3Client.putObject(new PutObjectRequest(bucketName, fileName, fileObj));
    //     fileObj.delete();
    //     return "File uploaded : " + fileName;
    // }



    public List<FileMetadata> getAllModel(){
        return fileMetadataRepository.findAll();
    }


    public Optional<FileMetadata> getModel(Long id){
       return  fileMetadataRepository.findById(id);
    }

    public  Optional<FileMetadata> getByName(String filename){
        return fileMetadataRepository.findByFilename(filename);
    }

    
    
    public String uploadFileToS3(MultipartFile file) throws IOException {
        String fileName = "APK/"+ UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
//        String fileName = file.getOriginalFilename();
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());
        s3Client.putObject(bucketName, fileName, file.getInputStream(), metadata);
        return s3Client.getUrl(bucketName, fileName).toString();
    }
    
    
    
    
    // upload file in Video/
    public String uploadVideoToS3(MultipartFile file) throws IOException {
        String fileName = "Video/" + UUID.randomUUID().toString() + "-" + file.getOriginalFilename();

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());

        PutObjectRequest request = new PutObjectRequest(bucketName, fileName, file.getInputStream(), metadata);
        PutObjectResult result = s3Client.putObject(request);

        return s3Client.getUrl(bucketName, fileName).toString();
    }
    
    
    
    
    //upload file in Image/ in s3 bucket 
    
    public String uploadImageToS3(MultipartFile file) throws IOException {
        String fileName = "Image/" + UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
       
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());

        PutObjectRequest request = new PutObjectRequest(bucketName, fileName, file.getInputStream(), null);
        PutObjectResult result = s3Client.putObject(request);

        return s3Client.getUrl(bucketName, fileName).toString();
    }
    
    
    
    
    
    
    public void saveFileMetadata(String filename, String description,Double  price, String s3Link,String objectKey, String catagory, LocalDate date, List<String> s3Links,String objectKeyVid, String objectKeyimgi, String objectKeyimgii ) {
        FileMetadata fileMetadata = new FileMetadata();
        fileMetadata.setFilename(filename);
        fileMetadata.setDescription(description);
        fileMetadata.setPrice(price);
        fileMetadata.setS3Link(s3Link);
        fileMetadata.setObjectKey(objectKey);
        fileMetadata.setLikes(fileMetadata.getLikes());
       // fileMetadata.setPolycounts(polycounts);
        fileMetadata.setCatagory(catagory);
        fileMetadata.setDate(date);
        fileMetadata.setS3Links(s3Links);
        fileMetadata.setObjectKeyVid(objectKeyVid);
        fileMetadata.setObjectKeyimgi(objectKeyimgi);
        fileMetadata.setObjectKeyimgii(objectKeyimgii);
        fileMetadataRepository.save(fileMetadata);
    }

   
    
    
//    public void saveFiledataPreview(String filename, String description, Double price, String s3Link, String objectKey,String catagory,LocalDate date, String previewFile1, MultipartFile previewData1,String previewFile2, MultipartFile previewData2,String previewFile3,MultipartFile previewData3) throws IOException{
//        FileMetadata fileMetadata = new FileMetadata();
//        fileMetadata.setFilename(filename);
//        fileMetadata.setDescription(description);
//        fileMetadata.setPrice(price);
//        fileMetadata.setS3Link(s3Link);
//        fileMetadata.setObjectKey(objectKey);
//        fileMetadata.setLikes(fileMetadata.getLikes());
//        
//        fileMetadata.setCatagory(catagory);
//        fileMetadata.setDate(date);
//
//        fileMetadata.setPreviewFile1(previewFile1);
//    
//        fileMetadata.setPreviewData1(getBytesFromFile(previewData1));
//
//        fileMetadata.setPreviewFile2(previewFile2);
//
//        fileMetadata.setPreviewData2(getBytesFromFile(previewData2));
//
//        fileMetadata.setPreviewFile3(previewFile3);
//
//        fileMetadata.setPreviewData3(getBytesFromFile(previewData3));
//
//        fileMetadataRepository.save(fileMetadata);
//
//
//    }



    public FileMetadata getFileById(Long id) {
        return fileMetadataRepository.findById(id).orElseThrow(() -> new FileNotFoundException("File not found with ID: " + id));
    }


    
    
    public  byte[] getBytesFromFile(MultipartFile file) throws IOException {
       return file.getBytes();
    }



    
    
    public byte[] downloadFile(String fileName) {
        S3Object s3Object = s3Client.getObject(bucketName, fileName);
        S3ObjectInputStream inputStream = s3Object.getObjectContent();
        try {
            byte[] content = IOUtils.toByteArray(inputStream);
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    
    
    
//    public void downloadFileS3(String fileName, OutputStream outputStream) {
//        try {
//            S3Object s3Object = s3Client.getObject(bucketName, fileName);
//            InputStream inputStream = s3Object.getObjectContent();
//
//            byte[] buffer = new byte[4096];
//            int bytesRead;
//            while ((bytesRead = inputStream.read(buffer)) != -1) {
//                outputStream.write(buffer, 0, bytesRead);
//            }
//
//            inputStream.close();
//            outputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    
    

    
    

    public String deleteFile(String fileName) {
        s3Client.deleteObject(bucketName, fileName);
        return fileName + " removed ...";
    }



    
    // private File convertMultiPartFileToFile(MultipartFile file) {
        
    //     File convertedFile = new File(file.getOriginalFilename());

    //     try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
    //         fos.write(file.getBytes());
    //     } catch (IOException e) {
    //         log.error("Error converting multipartFile to file", e);
    //     }
    //     return convertedFile;
    // }


    

    public List<String> searchS3(String query, String bucket) {
        List<String> results = new ArrayList<>();
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest().withBucketName(bucket);
        for (S3ObjectSummary summary : s3Client.listObjects(listObjectsRequest).getObjectSummaries()) {
            String key = summary.getKey();
            String filename = key.substring(key.lastIndexOf('/') + 1);
            if (filename.contains(query)) {
                results.add(key);
            }
        }
        return results;
    }

    


        // delete the file in both s3 and postgresql


        // public String  deleteFileMetadataByFilename(String filename) {
        //     // Get the FileMetadata entity to delete
        //     FileMetadata fileMetadata = fileMetadataRepository.findByFilename(filename)
        //         .orElseThrow(() -> new NotFoundException("FileMetadata not found"));
    
        //     // Get the S3 link of the file
        //     String s3Link = fileMetadata.getS3Link();
    
        //     // Delete the file from S3 using the link
        //     try {
        //         URL url = new URL(s3Link);
        //         s3Client.deleteObject(new DeleteObjectRequest(url.getHost(), url.getPath().substring(1)));
        //     } catch (MalformedURLException e) {
        //         throw new RuntimeException("Invalid S3 link", e);
        //     }
    

        //     // Delete the entity from the database
        //     fileMetadataRepository.delete(fileMetadata);
    
        //     return "3d model sucessfully deleted";
        // }




        public String deleteFileMetadataByFilename(String filename) {
            Optional<FileMetadata> optionalFileMetadata = fileMetadataRepository.findByFilename(filename);
            if (optionalFileMetadata.isPresent()) {
                FileMetadata fileMetadata = optionalFileMetadata.get();
               // String s3Link = fileMetadata.getS3Link();
                //String key = s3Link.substring(s3Link.lastIndexOf("/") + 1);
                String objectKey = fileMetadata.getObjectKey();
                s3Client.deleteObject(bucketName, objectKey);
                fileMetadataRepository.delete(fileMetadata);
                return "File is deleted successfully.";
            } else {
                return "File not found.";
            }
        }

        
        
        
        
        
        public List<FileMetadata> getbyDate(LocalDate date){
            return fileMetadataRepository.findByDate(date);
        }

        
        
        
        
        public List<FileMetadata> getByCatagory(String catagory){
            return fileMetadataRepository.findByCatagory(catagory);
        }

        
        
        
        
        
        public Optional<FileMetadata> getFileMeta(Long id) {
        	return fileMetadataRepository.findById(id);
        }

        
        
        public List<FileMetadata> searchOpt(String searchKey){
        	return fileMetadataRepository.findByFilenameContainingIgnoreCase(searchKey);
        }
        
        

        // public VideoResponse convertVideo(Long fileId){

        //     FileMetadata fileMetadata = fileMetadataRepository.findById(fileId).orElse(null);
            
        //     byte[] videoData = fileMetadata.getPreviewData1();

        //     videoResponse.setbyteVideo(videoData);

        //     return videoResponse;
        // }

        
        
        
        
        // convert into video DTO
//        public VideoDto convertIntoVideo(FileMetadata fileMetadata) {
//        
//        	VideoDto videoDto = new VideoDto();
//        	
//        	videoDto.setVideoData(fileMetadata.getPreviewData1());
//        	
//        	return videoDto;
//        }
        
        
        
        //convert into video Details DTO
//        public FileDetailsDTO convertIntoDetails(FileMetadata fileMetadata) {
//        	
//        	
//        	FileDetailsDTO fileDetails = new FileDetailsDTO();
//        	
//        	
//        	fileDetails.setId(fileMetadata.getId());
//        	fileDetails.setFilename(fileMetadata.getFilename());
//        	fileDetails.setDescription(fileMetadata.getDescription());
//        	fileDetails.setPrice(fileMetadata.getPrice());
//        	fileDetails.setS3Link(fileMetadata.getS3Link());
//        	fileDetails.setObjectKey(fileMetadata.getObjectKey());
//        	fileDetails.setLikes(fileMetadata.getLikes());
//        	fileDetails.setCatagory(fileMetadata.getCatagory());
//        	fileDetails.setDate(fileMetadata.getDate());
//        	fileDetails.setPreviewFile1(fileMetadata.getPreviewFile1());
//        	fileDetails.setPreviewFile2(fileMetadata.getPreviewFile2());
//        	fileDetails.setPreviewFile3(fileMetadata.getPreviewFile3());
//        	fileDetails.setPreviewData2(fileMetadata.getPreviewData2());
//        	fileDetails.setPreviewData3(fileMetadata.getPreviewData3());
//        	
//        	
//        	return fileDetails;
//        	
//        }
        
        
        
//        public byte[] retrieveVideoBytes(FileMetadata fileMetadata) {
//			return fileMetadata.getPreviewData1();
//        }
        
        
        
   
//        public byte[] retrieveImageBytes(FileMetadata fileMetadata) {
//        	return fileMetadata.getPreviewData2();
//        }
        
        
        
        
        
}

