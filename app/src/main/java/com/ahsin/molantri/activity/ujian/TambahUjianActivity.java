package com.ahsin.molantri.activity.ujian;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.ahsin.molantri.R;
import com.ahsin.molantri.model.Hafalan;
import com.ahsin.molantri.model.Halaqoh;
import com.ahsin.molantri.model.Ujian;
import com.ahsin.molantri.utils.DialogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TambahUjianActivity extends AppCompatActivity {

    @BindView(R.id.et_juz)
    EditText etJuz;
    @BindView(R.id.et_tanggal_ujian)
    EditText etTanggalUjian;
    @BindView(R.id.et_penilaian)
    EditText etPenilaian;
    @BindView(R.id.et_keterangan)
    EditText etKeterangan;

    Halaqoh halaqoh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_ujian);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tambah Ujian");

        halaqoh = (Halaqoh) getIntent().getSerializableExtra("halaqoh");
    }

    @OnClick({R.id.et_juz, R.id.et_tanggal_ujian, R.id.et_penilaian, R.id.btn_tambah})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.et_juz:
                final String[] juz = getResources().getStringArray(R.array.alquran);
                DialogUtils.dialogArray(this, juz, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        etJuz.setText(juz[which]);
                    }
                });
                break;
            case R.id.et_tanggal_ujian:
                DialogUtils.dialogTanggalFormat(this, etTanggalUjian, "dd MMMM yyyy");
                break;
            case R.id.et_penilaian:
                final String[] nilai = getResources().getStringArray(R.array.nilai);
                DialogUtils.dialogArray(this, nilai, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        etPenilaian.setText(nilai[which]);
                    }
                });
                break;
            case R.id.btn_tambah:
                tambahUjian();
                break;
        }
    }

    private void tambahUjian() {
        Ujian ujian = new Ujian();
        ujian.namaSantri = halaqoh.namaSantri;
        ujian.juz = etJuz.getText().toString();
        ujian.tanggalUjian = etTanggalUjian.getText().toString();
        ujian.penilaian = etPenilaian.getText().toString();
        ujian.keterangan = etKeterangan.getText().toString();
        ujian.save();
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
