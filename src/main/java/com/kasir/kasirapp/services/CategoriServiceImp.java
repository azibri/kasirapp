/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kasir.kasirapp.services;

import com.kasir.kasirapp.entities.Categori;
import com.kasir.kasirapp.repository.CategoriRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service
public class CategoriServiceImp implements CategoriService{

    @Autowired
    private CategoriRepo categoriRepo;
    
    @Override
    public Iterable<Categori> FindAll() {
        return categoriRepo.findAll();
    }

    @Override
    public void FindById(Integer id) {
        categoriRepo.findById(id);
    }

    @Override
    public void Save(Categori id) {
        categoriRepo.save(id);
    }

    @Override
    public void Delete(Integer id) {
        categoriRepo.deleteById(id);
    }
    
}
