/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kasir.kasirapp.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "keranjang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Keranjang.findAll", query = "SELECT k FROM Keranjang k")
    , @NamedQuery(name = "Keranjang.findByKeranjangId", query = "SELECT k FROM Keranjang k WHERE k.keranjangId = :keranjangId")
    , @NamedQuery(name = "Keranjang.findByKeranjangJumlah", query = "SELECT k FROM Keranjang k WHERE k.keranjangJumlah = :keranjangJumlah")
    , @NamedQuery(name = "Keranjang.findByKeranjangTotalHarga", query = "SELECT k FROM Keranjang k WHERE k.keranjangTotalHarga = :keranjangTotalHarga")})
public class Keranjang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "keranjang_id")
    private Integer keranjangId;
    @Basic(optional = false)
//    @NotNull
    @Column(name = "keranjang_jumlah")
    private int keranjangJumlah;
    @Basic(optional = false)
//    @NotNull
    @Column(name = "keranjang_total_harga")
    private int keranjangTotalHarga;
    @JoinColumn(name = "produk_id", referencedColumnName = "produk_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Produk produkId;

    public Keranjang() {
    }

    public Keranjang(Integer keranjangId) {
        this.keranjangId = keranjangId;
    }

    public Keranjang(Integer keranjangId, int keranjangJumlah, int keranjangTotalHarga) {
        this.keranjangId = keranjangId;
        this.keranjangJumlah = keranjangJumlah;
        this.keranjangTotalHarga = keranjangTotalHarga;
    }

    public Integer getKeranjangId() {
        return keranjangId;
    }

    public void setKeranjangId(Integer keranjangId) {
        this.keranjangId = keranjangId;
    }

    public int getKeranjangJumlah() {
        return keranjangJumlah;
    }

    public void setKeranjangJumlah(int keranjangJumlah) {
        this.keranjangJumlah = keranjangJumlah;
    }

    public int getKeranjangTotalHarga() {
        return keranjangTotalHarga;
    }

    public void setKeranjangTotalHarga(int keranjangTotalHarga) {
        this.keranjangTotalHarga = keranjangTotalHarga;
    }

    public Produk getProdukId() {
        return produkId;
    }

    public void setProdukId(Produk produkId) {
        this.produkId = produkId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (keranjangId != null ? keranjangId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Keranjang)) {
            return false;
        }
        Keranjang other = (Keranjang) object;
        if ((this.keranjangId == null && other.keranjangId != null) || (this.keranjangId != null && !this.keranjangId.equals(other.keranjangId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kasir.kasirapp.entities.Keranjang[ keranjangId=" + keranjangId + " ]";
    }
    
}
