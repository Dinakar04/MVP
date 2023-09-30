package com.example.s3Bucket.FileRepo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.s3Bucket.File.FileMetadata;


@Repository
public interface FileMetaDataRepository extends JpaRepository<FileMetadata, Long> {

    // Custom query method to retrieve FileMetadata entity by filename
    Optional<FileMetadata> findByFilename(String filename);


    // Other custom query methods based on your requirements
   List<FileMetadata> findByDate(LocalDate date);


   //Custom query method to retrieve FileMetadata entity by catagory
   List<FileMetadata> findByCatagory(String catagory);

   
   //custom query method for retrieving the FileMetadata entity by keywords
   List<FileMetadata> findByFilenameContainingIgnoreCase(String searchKey);
   
   
   
    // Custom query method to retrieve FileMetadata entity by Likes
    // List<FileMetadata> findByLikes();
   
   
}
