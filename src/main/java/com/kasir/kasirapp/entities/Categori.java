/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kasir.kasirapp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "categori")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categori.findAll", query = "SELECT c FROM Categori c")
    , @NamedQuery(name = "Categori.findByKategoriId", query = "SELECT c FROM Categori c WHERE c.kategoriId = :kategoriId")
    , @NamedQuery(name = "Categori.findByKategoriNama", query = "SELECT c FROM Categori c WHERE c.kategoriNama = :kategoriNama")})
public class Categori implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kategori_id")
    private Integer kategoriId;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "kategori_nama")
    private String kategoriNama;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kategoriId", fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Produk> produkList;

    public Categori() {
    }

    public Categori(Integer kategoriId) {
        this.kategoriId = kategoriId;
    }

    public Categori(Integer kategoriId, String kategoriNama) {
        this.kategoriId = kategoriId;
        this.kategoriNama = kategoriNama;
    }

    public Integer getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(Integer kategoriId) {
        this.kategoriId = kategoriId;
    }

    public String getKategoriNama() {
        return kategoriNama;
    }

    public void setKategoriNama(String kategoriNama) {
        this.kategoriNama = kategoriNama;
    }

    @XmlTransient
    public List<Produk> getProdukList() {
        return produkList;
    }

    public void setProdukList(List<Produk> produkList) {
        this.produkList = produkList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kategoriId != null ? kategoriId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categori)) {
            return false;
        }
        Categori other = (Categori) object;
        if ((this.kategoriId == null && other.kategoriId != null) || (this.kategoriId != null && !this.kategoriId.equals(other.kategoriId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kasir.kasirapp.entities.Categori[ kategoriId=" + kategoriId + " ]";
    }
    
}
