package com.ahsin.molantri.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.io.Serializable;

@Table(name = "halaqoh")
public class Halaqoh extends Model implements Serializable {

    @Column(name = "nama_halaqoh")
    public String namaHalaqoh;

    @Column(name = "nama_santri")
    public String namaSantri;

    @Column(name = "tanggal_lahir")
    public String tanggalLahir;

    @Column(name = "kelas")
    public String kelas;

    @Column(name = "asal")
    public String asal;

    @Column(name = "nomor_hp")
    public String nomorHP;

    @Column(name = "jenis_kelamin")
    public String jenisKelamin;

    @Column(name = "alamat")
    public String alamat;
}
