package com.example.s3Bucket.FileMettadataException;

public class FileNotNotFoundException extends RuntimeException{
    public FileNotNotFoundException(Long fileId) {
        super("file not found with ID: " + fileId);
    }
}
