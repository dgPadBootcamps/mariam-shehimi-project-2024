package com.example.demo.repository;

import com.example.demo.model.MyPerfumeList;
import com.example.demo.model.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyPerfumeRepository extends JpaRepository<MyPerfumeList,Integer> {

}
