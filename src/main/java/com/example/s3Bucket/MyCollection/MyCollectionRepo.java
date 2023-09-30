package com.example.s3Bucket.MyCollection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyCollectionRepo extends JpaRepository<MyCollection, Long>{

}
