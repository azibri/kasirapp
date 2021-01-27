/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kasir.kasirapp.controller;

import com.kasir.kasirapp.entities.Keranjang;
import com.kasir.kasirapp.entities.Produk;
import com.kasir.kasirapp.exception.ResourceNotFoundException;
import com.kasir.kasirapp.repository.KeranjangRepo;
import com.kasir.kasirapp.repository.ProdukRepo;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author asus
 */
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
@RestController
public class KeranjangRestController {
    
    @Autowired
    private KeranjangRepo keranjangRepo;
    
    @Autowired
    private ProdukRepo produkRepo;
    
    //menampilkan data
    @GetMapping("/keranjang")
    public Iterable<Keranjang> FindAllKeranjang() {
        return keranjangRepo.findAll();
    }
    
    //menampilkan data berdasarkan id
    @GetMapping("/keranjang/{id}")
    public ResponseEntity<Keranjang> FindKeranjangById(@PathVariable Integer id) {
        Keranjang keranjang = keranjangRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("maaf id tidak ditemukan " + id));
        return ResponseEntity.ok(keranjang);
    }
    
    //menyimpan data
    @PostMapping("/keranjang")
    public Keranjang SaveKeranjang(@RequestBody Keranjang keranjang) {
        return keranjangRepo.save(keranjang);
    }
    
    //update keranjang
    @PutMapping("keranjang/{id}")
    public ResponseEntity<Keranjang> UpdateKeranjang(@PathVariable Integer id, @RequestBody Keranjang keranjangdetails) {
        Keranjang keranjang = keranjangRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("maaf id tidak ditemukan " + id));
        
        keranjang.setKeranjangId(keranjangdetails.getKeranjangId());
        keranjang.setKeranjangJumlah(keranjangdetails.getKeranjangJumlah());
        keranjang.setKeranjangTotalHarga(keranjangdetails.getKeranjangTotalHarga());
        keranjang.setProdukId(keranjangdetails.getProdukId());
        
        Keranjang update = keranjangRepo.save(keranjang);
        return ResponseEntity.ok(update);
    }
    
    //menghapus keranjang
    @DeleteMapping("keranjang/{id}")
    public ResponseEntity<Map <String, Boolean>> DeleteKeranjang(@PathVariable Integer id) {
        Keranjang keranjang = keranjangRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("maaf id tidak ditemukan " + id));
        
        keranjangRepo.delete(keranjang);
        Map<String, Boolean> response = new HashMap<>();
        return ResponseEntity.ok(response);
    }
    
    //
    @GetMapping("keranjang/pilih/{id}")
    public ResponseEntity<Produk> GetProduk(@PathVariable Integer id) {
        Produk keranjang = produkRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("maaf id tidak ditemukan " +id));
        return ResponseEntity.ok(keranjang);
    }
    
}
