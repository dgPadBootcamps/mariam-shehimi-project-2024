package com.example.demo.service;

import com.example.demo.model.MyPerfumeList;
import com.example.demo.repository.MyPerfumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyPerfumeService {
    @Autowired
    private MyPerfumeRepository myPerfumeRepository;
    public  void saveMyPerfumes(MyPerfumeList perfume){
        myPerfumeRepository.save(perfume);
    }
    public List<MyPerfumeList> getAllMyPerfumes(){
        return myPerfumeRepository.findAll();
    }

    public void deleteById(int id){
        myPerfumeRepository.deleteById(id);
    }
}
