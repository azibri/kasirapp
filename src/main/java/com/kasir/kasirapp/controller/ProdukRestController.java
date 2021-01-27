/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kasir.kasirapp.controller;

import com.kasir.kasirapp.entities.Produk;
import com.kasir.kasirapp.exception.ResourceNotFoundException;
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
public class ProdukRestController {
    
    @Autowired
    private ProdukRepo produkRepo;
    
    //mendapatkan semua data produk
    @GetMapping("/produk")
    public Iterable<Produk> FindAllProduk() {
        return produkRepo.findAll();
    }
    
    //mendapatkan data berdasarkan id
    @GetMapping("produk/{id}")
    public ResponseEntity<Produk> FindProdukById(@PathVariable Integer id) {
        Produk produk = produkRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("maaf Id tidak ditemukan" + id));
        return ResponseEntity.ok(produk);
    }
    
    //menyimpan data
    @PostMapping("produk")
    public Produk SaveProduk(@RequestBody Produk produk) {
        return produkRepo.save(produk);
    }
    
    //update data sesuai id
    @PostMapping("produk/{id}")
    public ResponseEntity<Produk> SaveProdukById(@PathVariable Integer id, @RequestBody Produk produkdetails) {
        Produk produk = produkRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("maaf id tidak ditemukan" + id));
        produk.setProdukId(produkdetails.getProdukId());
        produk.setProdukKode(produkdetails.getProdukKode());
        produk.setProdukNama(produkdetails.getProdukNama());
        produk.setProdukHarga(produkdetails.getProdukHarga());
        produk.setProdukIsready(produkdetails.getProdukIsready());
        produk.setProdukGambar(produkdetails.getProdukGambar());
        produk.setKategoriId(produkdetails.getKategoriId());
        
        Produk update = produkRepo.save(produk);
        
        return ResponseEntity.ok(update);
    }
    
    //menghapus data sesuai id
    @DeleteMapping("produk/{id}")
    public ResponseEntity<Map<String, Boolean>> DeleteProduk(@PathVariable Integer id) {
        Produk produk = produkRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("maaf id tidak didemukan" + id));
        
        produkRepo.delete(produk);
        Map<String, Boolean> response = new HashMap<>();
        return ResponseEntity.ok(response);
    }
    
    //tampil data produk sesuai nama kategori
    @GetMapping("produk/pilih/{nama}")
    public ResponseEntity<Iterable<Produk>> FindProdukByNama(@PathVariable String nama) {
        Iterable<Produk> produk = produkRepo.tampil(nama);
        return ResponseEntity.ok(produk);
    }
    
    
}
