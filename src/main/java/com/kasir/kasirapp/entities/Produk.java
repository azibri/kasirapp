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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "produk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produk.findAll", query = "SELECT p FROM Produk p")
    , @NamedQuery(name = "Produk.findByProdukId", query = "SELECT p FROM Produk p WHERE p.produkId = :produkId")
    , @NamedQuery(name = "Produk.findByProdukKode", query = "SELECT p FROM Produk p WHERE p.produkKode = :produkKode")
    , @NamedQuery(name = "Produk.findByProdukNama", query = "SELECT p FROM Produk p WHERE p.produkNama = :produkNama")
    , @NamedQuery(name = "Produk.findByProdukHarga", query = "SELECT p FROM Produk p WHERE p.produkHarga = :produkHarga")
    , @NamedQuery(name = "Produk.findByProdukIsready", query = "SELECT p FROM Produk p WHERE p.produkIsready = :produkIsready")
    , @NamedQuery(name = "Produk.findByProdukGambar", query = "SELECT p FROM Produk p WHERE p.produkGambar = :produkGambar")})
public class Produk implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "produk_id")
    private Integer produkId;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "produk_kode")
    private String produkKode;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "produk_nama")
    private String produkNama;
    @Basic(optional = false)
//    @NotNull
    @Column(name = "produk_harga")
    private int produkHarga;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "produk_isready")
    private String produkIsready;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "produk_gambar")
    private String produkGambar;
    @JoinColumn(name = "kategori_id", referencedColumnName = "kategori_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Categori kategoriId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produkId", fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Keranjang> keranjangList;

    public Produk() {
    }

    public Produk(Integer produkId) {
        this.produkId = produkId;
    }

    public Produk(Integer produkId, String produkKode, String produkNama, int produkHarga, String produkIsready, String produkGambar) {
        this.produkId = produkId;
        this.produkKode = produkKode;
        this.produkNama = produkNama;
        this.produkHarga = produkHarga;
        this.produkIsready = produkIsready;
        this.produkGambar = produkGambar;
    }

    public Integer getProdukId() {
        return produkId;
    }

    public void setProdukId(Integer produkId) {
        this.produkId = produkId;
    }

    public String getProdukKode() {
        return produkKode;
    }

    public void setProdukKode(String produkKode) {
        this.produkKode = produkKode;
    }

    public String getProdukNama() {
        return produkNama;
    }

    public void setProdukNama(String produkNama) {
        this.produkNama = produkNama;
    }

    public int getProdukHarga() {
        return produkHarga;
    }

    public void setProdukHarga(int produkHarga) {
        this.produkHarga = produkHarga;
    }

    public String getProdukIsready() {
        return produkIsready;
    }

    public void setProdukIsready(String produkIsready) {
        this.produkIsready = produkIsready;
    }

    public String getProdukGambar() {
        return produkGambar;
    }

    public void setProdukGambar(String produkGambar) {
        this.produkGambar = produkGambar;
    }

    public Categori getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(Categori kategoriId) {
        this.kategoriId = kategoriId;
    }

    @XmlTransient
    public List<Keranjang> getKeranjangList() {
        return keranjangList;
    }

    public void setKeranjangList(List<Keranjang> keranjangList) {
        this.keranjangList = keranjangList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produkId != null ? produkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produk)) {
            return false;
        }
        Produk other = (Produk) object;
        if ((this.produkId == null && other.produkId != null) || (this.produkId != null && !this.produkId.equals(other.produkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kasir.kasirapp.entities.Produk[ produkId=" + produkId + " ]";
    }
    
}
