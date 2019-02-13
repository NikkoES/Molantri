package com.ahsin.molantri.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.io.Serializable;

@Table(name = "ujian")
public class Ujian extends Model implements Serializable {

    @Column(name = "nama_santri")
    public String namaSantri;

    @Column(name = "juz")
    public String juz;

    @Column(name = "tanggal_setoran")
    public String tanggalUjian;

    @Column(name = "penilaian")
    public String penilaian;

    @Column(name = "keterangan")
    public String keterangan;

}
