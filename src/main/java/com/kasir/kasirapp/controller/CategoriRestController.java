/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kasir.kasirapp.controller;

import com.kasir.kasirapp.entities.Categori;
import com.kasir.kasirapp.exception.ResourceNotFoundException;
import com.kasir.kasirapp.repository.CategoriRepo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author asus
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api")
public class CategoriRestController {
    
    @Autowired
    private CategoriRepo categoriRepo;
    
    //mendapat semua data
    @GetMapping("/categori")
    public List<Categori> FindAllCategori() {
        return categoriRepo.findAll();
    }
    
    //mendapat data sesuai id
    @GetMapping("/categori/{id}")
    public ResponseEntity<Categori> FindByIdCategori(@PathVariable Integer id) {
        Categori categori = categoriRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("maaf Id tidak ditemukan" + id));
        return ResponseEntity.ok(categori);
    }
    
    //menyimpan data
    @PostMapping("/categori")
    public Categori SaveCategori(@RequestBody Categori categori) {
        return categoriRepo.save(categori);
    }
    
    
    //updatedata
    @PostMapping("/categori/{id}")
    public ResponseEntity<Categori> UpdateCategori(@PathVariable Integer id, @RequestBody Categori categoridetail){
        Categori categori = categoriRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("maaf Id tidak ditemukan" + id));
        
        categori.setKategoriNama(categoridetail.getKategoriNama());
        categori.setKategoriId(categoridetail.getKategoriId());
        
        Categori update = categoriRepo.save(categori);
        
        return ResponseEntity.ok(update);
    }
    
    
    //delete data
    @DeleteMapping("/categori/{id}")
    public ResponseEntity<Map <String, Boolean>> SaveCategori(@PathVariable Integer id){
        Categori categori = categoriRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("maaf Id tidak ditemukan" + id));
        
        categoriRepo.delete(categori);
        Map<String, Boolean> response = new HashMap<>();
        return ResponseEntity.ok(response);
    }
    
}
