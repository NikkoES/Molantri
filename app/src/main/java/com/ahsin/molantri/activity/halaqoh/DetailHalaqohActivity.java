package com.ahsin.molantri.activity.halaqoh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.ahsin.molantri.R;
import com.ahsin.molantri.model.Halaqoh;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailHalaqohActivity extends AppCompatActivity {

    @BindView(R.id.txt_nama_halaqoh)
    TextView txtNamaHalaqoh;
    @BindView(R.id.txt_nama_santri)
    TextView txtNamaSantri;
    @BindView(R.id.txt_tanggal_lahir)
    TextView txtTanggalLahir;
    @BindView(R.id.txt_kelas)
    TextView txtKelas;
    @BindView(R.id.txt_asal)
    TextView txtAsal;
    @BindView(R.id.txt_nomor_hp)
    TextView txtNomorHp;
    @BindView(R.id.txt_jenis_kelamin)
    TextView txtJenisKelamin;
    @BindView(R.id.txt_alamat)
    TextView txtAlamat;

    Halaqoh halaqoh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_halaqoh);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detail Halaqoh");

        halaqoh = (Halaqoh) getIntent().getSerializableExtra("halaqoh");

        initView();
    }

    private void initView() {
        txtNamaHalaqoh.setText(halaqoh.namaHalaqoh);
        txtNamaSantri.setText(halaqoh.namaSantri);
        txtTanggalLahir.setText(halaqoh.tanggalLahir);
        txtKelas.setText(halaqoh.kelas);
        txtAsal.setText(halaqoh.asal);
        txtNomorHp.setText(halaqoh.nomorHP);
        txtJenisKelamin.setText(halaqoh.jenisKelamin);
        txtAlamat.setText(halaqoh.alamat);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
