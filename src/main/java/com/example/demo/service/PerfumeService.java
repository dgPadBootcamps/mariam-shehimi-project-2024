package com.example.demo.service;

import com.example.demo.model.Perfume;
import com.example.demo.repository.PerfumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfumeService {
    @Autowired
    private PerfumeRepository perfumeRepository;
    public  void save(Perfume p){
        perfumeRepository.save(p);
    }

    public List<Perfume> getAllPerfume(){
        return perfumeRepository.findAll();
    }
    public Perfume getPerfumeById(int id){
        return perfumeRepository.findById(id).get();
    }

    public  void deleteById(int id){
        perfumeRepository.deleteById(id);
    }
    public List<Perfume> searchByName(String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            return perfumeRepository.findByNameContainingIgnoreCase(keyword);
        }
        return perfumeRepository.findAll();  // Return all products if no search keyword is entered
    }
}
