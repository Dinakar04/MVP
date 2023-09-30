package com.example.s3Bucket.FileController;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.multipart.MultipartFile;

import com.example.FileNotFoundException.FileNotFoundException;
import com.example.s3Bucket.File.FileDetailsDTO;
import com.example.s3Bucket.File.FileMetadata;
import com.example.s3Bucket.File.VideoDto;
import com.example.s3Bucket.FileRepo.FileMetaDataRepository;
import com.example.s3Bucket.FileService.S3Service;
import com.example.s3Bucket.VideoResponse.VideoResponse;
import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping("/api/v1/file")
@CrossOrigin(origins = "*", allowedHeaders = "*")
// @CrossOrigin(origins ={ "http://localhost:5173","http://15.207.135.113:5173"},allowedHeaders = "*")

public class S3Controller {

	
    @Autowired
    private S3Service service;
    

   
    @Autowired
    FileMetaDataRepository fileMetadataRepository;

	

    // @PostMapping("/upload")
    // public ResponseEntity<String> uploadFile(@RequestParam(value = "file") MultipartFile file) {
    //     return new ResponseEntity<>(service.uploadFile(file), HttpStatus.OK);
    // }
    
    
    @GetMapping("/all/db/models")
    public List<FileMetadata> getAllModels(){
        return service.getAllModel();
    }
    
    

    
    
    
//    
//   @GetMapping("/all/db/models/dto")
//    public List<FileDetailsDTO> getAllDtos(){
//	   List<FileMetadata> filesList = service.getAllModel();
//	  // List<FileDetailsDTO> dtoList = new ArrayList<>();
//	   
//	   
//	   
//	   return filesList.stream()
//               .map(this::convertIntoDetails)
//               .collect(Collectors.toList());
//   }
    
   
   

    
   @GetMapping("/get/{filename}")
   public Optional<FileMetadata> gtefileByname(@PathVariable String filename){
    return service.getByName(filename);
   }

   
   
   
   
//   @PostMapping("/all/db/models/video")
//   public ResponseEntity<String> uploadVideo(@RequestParam("filename") String filename,
//		    @RequestParam("description") String description,
//		    @RequestParam("price") Double price,
//		    @RequestParam("catagory") String catagory,
//		    @RequestParam("date") LocalDate date,
//		    @RequestParam("previewFile1") String  previewFile1,
//		    @RequestParam("previewData1") MultipartFile previewData1,
//		    @RequestParam("previewFile2") String previewFile2,
//		    @RequestParam("previewData2") MultipartFile previewData2,
//		    @RequestParam("previewFile3") String previewFile3,
//		    @RequestParam("previewData3") MultipartFile previewData3 ) {
//	   
//	   
//	   try {
//		   
//		service.saveFiledataPreview(filename, description, price, filename, description, catagory, date, previewFile1, previewData1, previewFile2, previewData2, previewFile3, previewData3);
//		return ResponseEntity.ok("File uploaded successfully");
//		
//	} catch (IOException e) {
//		
//		 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file: " + e.getMessage());
//	}
//	   
//   }
   
   
// new controller for posting models and also video in s3 
   
   
  @PostMapping("/all/db/models/video")
  public ResponseEntity<String> uploadAllinS3(@RequestParam("filename") String filename,@RequestParam("apkFile") MultipartFile apkFile,
			@RequestParam("description") String description, @RequestParam("price") Double price,
			@RequestParam("catagory") String catagory, @RequestParam("date") LocalDate date,
			@RequestParam("videoFile") MultipartFile videoFile, @RequestParam("imgiFile") MultipartFile imgiFile,
			@RequestParam("imgiiFile") MultipartFile imgiiFile
		    ) {
	  
	  try {
		  
		  String s3Link = service.uploadFileToS3(apkFile);

		  
		  List<String> s3Links = new ArrayList<>();
		  
//		  s3Links.add(service.uploadVideoToS3(videoFile));
//		  s3Links.add(service.uploadImageToS3(imgiFile));
//		  s3Links.add(service.uploadImageToS3(imgiiFile));
		  
		  String videoLink = service.uploadVideoToS3(videoFile);
		  String imgiLink = service.uploadImageToS3(imgiFile);
		  String imgiiLink = service.uploadImageToS3(imgiiFile);
		  
		  s3Links.add(videoLink);
		  s3Links.add(imgiLink);
		  s3Links.add(imgiiLink);
		  URL objectKeyAPK = new URL(s3Link);
		  URL  objectKeyVidURL  = new URL(videoLink) ;
		  URL  objectKeyimgiURL  = new URL(imgiLink) ;
		  URL  objectKeyimgiiURL  = new URL(imgiiLink) ;
		  
		  String objectKeyApk = objectKeyAPK.getPath().substring(1);
		  String objectKeyVid = objectKeyVidURL.getPath().substring(1);
		  String objectKeyimgi = objectKeyimgiURL.getPath().substring(1);
		  String objectKeyimgii = objectKeyimgiiURL.getPath().substring(1);
		  
		  
		  
		  service.saveFileMetadata(filename, description, price, s3Link, objectKeyApk, catagory, date, s3Links,objectKeyVid,objectKeyimgi,objectKeyimgii);
          return ResponseEntity.ok("File uploaded successfully");
		  
	  }catch(IOException e) {
		  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file: " + e.getMessage());
	  }

  }
  

  
   //Main controller for uploading all 3d models

    // @PostMapping("/s3/db/upload")
    // public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,
    //                                          @RequestParam("filename") String filename,
    //                                          @RequestParam("description") String description,
    //                                          @RequestParam("price") String price) {
    //     try {
//             String s3Link = service.uploadFileToS3(file);
//             service.saveFileMetadata(filename, description, price, s3Link);
//             return ResponseEntity.ok("File uploaded successfully");
    //     } catch (Exception e) {
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file: " + e.getMessage());
    //     }
    // }




    // trying 

   
   // method need to be reconstructed
   
//   
//    @PostMapping("/s3/db/upload ")
//    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,
//                                             @RequestParam("filename") String filename,
//                                             @RequestParam("description") String description,
//                                             @RequestParam("price") Double price,
//         
//                                             @RequestParam("catagory") String catagory,
//                                             @RequestParam("date") LocalDate date
//                                            ) {
//        try {
//            String s3Link = service.uploadFileToS3(file);
//            URL objectUrl = new URL(s3Link);
//            String objectKey = objectUrl.getPath().substring(1);
//            service.saveFileMetadata(filename, description, price, s3Link, objectKey,catagory,date);
//            return ResponseEntity.ok("File uploaded successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file: " + e.getMessage());
//        }
//    }


    

//    @PostMapping("/s3/db/upload/preview")
//    public ResponseEntity<String> uploadFilePreview(@RequestParam("file") MultipartFile file,
//    @RequestParam("filename") String filename,
//    @RequestParam("description") String description,
//    @RequestParam("price") Double price,
//   
//    @RequestParam("catagory") String catagory,
//    @RequestParam("date") LocalDate date,
//    @RequestParam("previewFile1") String  previewFile1,
//    @RequestParam("previewData1") MultipartFile previewData1,
//    @RequestParam("previewFile2") String previewFile2,
//    @RequestParam("previewData2") MultipartFile previewData2,
//    @RequestParam("previewFile3") String previewFile3,
//    @RequestParam("previewData3") MultipartFile previewData3
//    ){
//        try{
//        	
//            String s3Link = service.uploadFileToS3(file);
//            URL objectUrl = new URL(s3Link);
//            String objectKey = objectUrl.getPath().substring(1);
//            service.saveFiledataPreview(filename, description, price, s3Link, objectKey, catagory, date, previewFile1, previewData1, previewFile2, previewData2, previewFile3, previewData3);
//            return ResponseEntity.ok("File uploaded successfully");
//        } catch (Exception e){
//            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file: " + e.getMessage());
//        }
//    }

    
    

//    public ResponseEntity<String> uploadFilePreviewAws(@RequestParam("file") MultipartFile file,
//    	    @RequestParam("filename") String filename,
//    	    @RequestParam("description") String description,
//    	    @RequestParam("price") Double price,
//    	   
//    	    @RequestParam("catagory") String catagory,
//    	    @RequestParam("date") LocalDate date,
//    	    @RequestParam("previewFile1") String  previewFile1,
//    	    @RequestParam("previewData1") MultipartFile previewData1,
//    	    @RequestParam("previewFile2") String previewFile2,
//    	    @RequestParam("previewData2") MultipartFile previewData2,
//    	    @RequestParam("previewFile3") String previewFile3,
//    	    @RequestParam("previewData3") MultipartFile previewData3
//    	    ){
//    	        try{
//    	        	
//    	            String s3Link = service.uploadFileToS3(file);
//    	            URL objectUrl = new URL(s3Link);
//    	            String objectKey = objectUrl.getPath().substring(1);
//    	            service.saveFiledataPreview(filename, description, price, s3Link, objectKey, catagory, date, previewFile1, previewData1, previewFile2, previewData2, previewFile3, previewData3);
//    	            return ResponseEntity.ok("File uploaded successfully");
//    	        } catch (Exception e){
//    	            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file: " + e.getMessage());
//    	        }
//    	    }

    
    
    
    
//    @PostMapping("/s3/db/upload/preview/360")
//    public String videoUploader(@RequestParam("filename") String filename,
//    		@RequestParam("previewData1") MultipartFile previewData1
//    		)
//    {
//    	fileMetadataRepository.save();
//    }
    
  
//
  
  
  @GetMapping("/download/{fileName}")
  public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) {
	  
	  String fileNameFol = "APK/" +fileName;
	  
      byte[] data = service.downloadFile(fileNameFol);
      
      ByteArrayResource resource = new ByteArrayResource(data);
      
      return ResponseEntity
              .ok()
              .contentLength(data.length)
              .header("Content-type", "application/octet-stream")
              .header("Content-disposition", "attachment; filename=\"" + fileName + "\"")
              .body(resource);
      
  }
  
  
  
//    @GetMapping("/download/{fileName}")
//    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) {
//        byte[] data = service.downloadFile(fileName);
//        ByteArrayResource resource = new ByteArrayResource(data);
//        return ResponseEntity
//                .ok()
//                .contentLength(data.length)
//                .header("Content-type", "application/octet-stream")
//                .header("Content-disposition", "attachment; filename=\"" + fileName + "\"")
//                .body(resource);
//    }
//    
    
  
//    @GetMapping("/files/download/{fileName}")
//    public byte[] downloadFileS3(@PathVariable String fileName) throws IOException {
//        return service.downloadFileS3(fileName);
//    }
    
    
//    @GetMapping("/files/{fileName:.+}")
//    public ResponseEntity<byte[]> downloadFileS3(@PathVariable String fileName) {
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        service.downloadFile(fileName, outputStream);
//
//        byte[] fileContent = outputStream.toByteArray();
//
//        if (fileContent.length > 0) {
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//            headers.setContentDispositionFormData("attachment", fileName);
//            return ResponseEntity.ok().headers(headers).body(fileContent);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//
//    }
    
    
    // @DeleteMapping("/delete/{fileName}")
    // public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
    //     return new ResponseEntity<>(service.deleteFile(fileName), HttpStatus.OK);
    // }



    @DeleteMapping("/delete/{filename}")
    public String deleteModel(@PathVariable String filename){
        return service.deleteFileMetadataByFilename(filename);
    }

    
    
    
    @GetMapping("/search")
    public ResponseEntity<List<String>> searchS3(@RequestParam("query") String query, @RequestParam("bucket") String bucket) {
        List<String> results = service.searchS3(query, bucket);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }


    
    
    // @GetMapping("/filter/date")
    // public List<FileMetadata> getByDate(@RequestParam Date date){
    //     return service.getbyDate(date);
    // }

    
    


    @GetMapping("/filter/catagory")
    public List<FileMetadata> getbyCatagory(@RequestParam String catagory){
        return service.getByCatagory(catagory);
    }



    

    // @GetMapping("/files")
    // public ResponseEntity<List<FileMetadata>> getAllFiles() {
    //     List<FileMetadata> files = service.getAllFiles();
    //     return ResponseEntity.ok(files);
    // }

    
    


    @GetMapping("/filter/date")
    public List<FileMetadata> getbyDate(@RequestParam LocalDate date){
        return service.getbyDate(date);
    }
 

    
    
    // @GetMapping("/files/{filename}")
    // public ResponseEntity<FileMetadata> getFileByFilename(@PathVariable("filename") String filename) {
    //     FileMetadata file = service.getFileByFilename(filename);
    //     if (file != null) {
    //         return ResponseEntity.ok(file);
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }
    
    
    
    
    @GetMapping("/get/id/{id}")
    public FileMetadata getFileById(@PathVariable Long id ) {
		return service.getFileById(id);
    	
    }

    

    // @PostMapping("/get/video/arr")
    // public VideoResponse VideoDto(@RequestParam Long fileId){
    //     return service.convertVideo(fileId);
    // }

    


    
    //this method is created for first video is stored in db so it returns the byte[] , so the response is long and
    // to handlein react js .so i conver the byte array to video
    
    
    
    
//    @GetMapping("/video/converter/{id}")
//    public ResponseEntity<ByteArrayResource> getVideo(@PathVariable Long id) {
//    
//    	FileMetadata file = fileMetadataRepository.findById(id).orElse(null);
//    	
//    	if (file == null) {
//            return ResponseEntity.notFound().build();
//        }
//    	
//    	byte[] videoData = file.getPreviewData1();
//        ByteArrayResource resource = new ByteArrayResource(videoData);
//
////        HttpHeaders headers = new HttpHeaders();
////        headers.setContentType(MediaType.parseMediaType("video/mp4"));
////        headers.setContentLength(videoData.length);
////        headers.setContentDispositionFormData("attachment", "video.mp4");
////
////        return ResponseEntity.ok()
////                .headers(headers)
////                .body(resource);
//        
//        return ResponseEntity.ok()
//        		.header(HttpHeaders.CONTENT_DISPOSITION,  "attachment;filename=video.mp4")
//        		.contentType(MediaType.parseMediaType("video/mp4"))
//                .contentLength(videoData.length)
//                .body(resource);
//        		
//    }
    

    
    // Because of long or heavy response i created dto for limit data to reduce the response payload
    
//    @GetMapping("/video/dto/{fileid}")
//    public VideoDto getVideoDTO(@PathVariable Long fileid) throws FileNotFoundException{
//    	
//    	FileMetadata file = fileMetadataRepository.findById(fileid).orElseThrow(() -> new FileNotFoundException("Product not found " + fileid));
//    	
//    	return service.convertIntoVideo(file);
//
//    }
//    
//    
//    
//    
//    

    
    
    //same thing happened before method
//    
//    @GetMapping("/filedatails/dto/{fileid}")
//    public FileDetailsDTO getDetailsDTO(@PathVariable Long fileid) throws FileNotFoundException {
//	FileMetadata file = fileMetadataRepository.findById(fileid).orElseThrow(() -> new FileNotFoundException("Product not found " + fileid));
//    	
//    	return service.convertIntoDetails(file);
//    }
//    
//    
//    
//    
    

    
//    
//    @GetMapping("/video/stream/{fileid}")
//    public ResponseEntity<ByteArrayResource> getByteToVid(@PathVariable Long fileid) {
//    	FileMetadata file = fileMetadataRepository.findById(fileid).orElseThrow(() -> new FileNotFoundException("Product not found " + fileid));
//    	
//    	byte[] videoData =  service.retrieveVideoBytes(file);
//    	ByteArrayResource resource = new ByteArrayResource(videoData);
//    	
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=video.mp4");
//
//        // Return the video as a ResponseEntity
//        return ResponseEntity.ok()
//                .headers(headers)
//                .contentType(MediaType.parseMediaType("video/mp4"))
//                .body(resource);
//    }
//    
//    
//    
//    
//    @GetMapping("/image/stream/{fileid}")
//    public ResponseEntity<ByteArrayResource> getByteimage(@PathVariable Long fileid){
//    	FileMetadata file = fileMetadataRepository.findById(fileid).orElseThrow(() -> new FileNotFoundException("product not found " + fileid));
//    	
//		byte[]  imageData = service.retrieveImageBytes(file);
//		ByteArrayResource resource = new ByteArrayResource(imageData);
//		
//		
//		  HttpHeaders headers = new HttpHeaders();
//		  headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=");
//		 
//		  
//		  return  ResponseEntity.ok()
//				  .headers(headers)
//				  .contentType(MediaType.IMAGE_PNG)
//				  .body(resource);
//		
//    }
    

    
    
//   public FileDetailsDTO convertIntoDetails(FileMetadata fileMetadata) {
//    	
//    	
//    	FileDetailsDTO fileDetails = new FileDetailsDTO();
//    	
//    	
//    	fileDetails.setId(fileMetadata.getId());
//    	fileDetails.setFilename(fileMetadata.getFilename());
//    	fileDetails.setDescription(fileMetadata.getDescription());
//    	fileDetails.setPrice(fileMetadata.getPrice());
//    	fileDetails.setS3Link(fileMetadata.getS3Link());
//    	fileDetails.setObjectKey(fileMetadata.getObjectKey());
//    	fileDetails.setLikes(fileMetadata.getLikes());
//    	fileDetails.setCatagory(fileMetadata.getCatagory());
//    	fileDetails.setDate(fileMetadata.getDate());
//    	fileDetails.setPreviewFile1(fileMetadata.getPreviewFile1());
//    	fileDetails.setPreviewFile2(fileMetadata.getPreviewFile2());
//    	fileDetails.setPreviewFile3(fileMetadata.getPreviewFile3());
//    	fileDetails.setPreviewData2(fileMetadata.getPreviewData2());
//    	fileDetails.setPreviewData3(fileMetadata.getPreviewData3());
//    	
//    	
//    	return fileDetails;
//    	
//    }

  
    //after all changing the video stored in DB to S3 for website optimization
    
    @DeleteMapping("/delete/all/model")
    public String deleteModels() {
    	fileMetadataRepository.deleteAll();
    	return "files deleted";
    }
    
    
    
    @GetMapping("/search/{searchKey}")
    public List<FileMetadata> getSearchKey(@PathVariable String searchKey){
    	
    	return service.searchOpt(searchKey);
    	
    }

    
}