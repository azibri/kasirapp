/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kasir.kasirapp.repository;

import com.kasir.kasirapp.entities.Produk;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author asus
 */
@Repository
public interface ProdukRepo extends CrudRepository<Produk, Integer> {
    @Query(value = "SELECT * FROM produk INNER JOIN categori ON "
            + "produk.kategori_id = categori.kategori_id WHERE kategori_nama = ?1", nativeQuery = true)
    public Iterable<Produk> tampil(String namakategori);
    
    @Query(value = "SELECT * FROM produk where produk_id = ", nativeQuery = true)
    public Iterable<Produk> tampil(Integer id);
}
