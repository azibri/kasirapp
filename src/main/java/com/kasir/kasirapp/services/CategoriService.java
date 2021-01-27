/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kasir.kasirapp.services;

import com.kasir.kasirapp.entities.Categori;

/**
 *
 * @author asus
 */
public interface CategoriService {
    
    Iterable<Categori> FindAll();
    
    void FindById(Integer id);
    
    void Save(Categori id);
    
    void Delete(Integer id);
    
}
