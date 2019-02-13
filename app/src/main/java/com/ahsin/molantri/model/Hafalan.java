package com.ahsin.molantri.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.io.Serializable;

@Table(name = "hafalan")
public class Hafalan extends Model implements Serializable {

    @Column(name = "nama_santri")
    public String namaSantri;

    @Column(name = "juz")
    public String juz;

    @Column(name = "jumlah_ayat")
    public String jumlahAyat;

    @Column(name = "tanggal_setoran")
    public String tanggalSetoran;

}
