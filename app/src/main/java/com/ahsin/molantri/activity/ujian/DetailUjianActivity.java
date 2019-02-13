package com.ahsin.molantri.activity.ujian;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;

import com.ahsin.molantri.R;
import com.ahsin.molantri.model.Hafalan;
import com.ahsin.molantri.model.Halaqoh;
import com.ahsin.molantri.model.Ujian;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailUjianActivity extends AppCompatActivity {

    @BindView(R.id.et_halaqoh)
    EditText etHalaqoh;
    @BindView(R.id.et_nama_santri)
    EditText etNamaSantri;
    @BindView(R.id.et_jumlah_juz)
    EditText etJumlahJuz;
    @BindView(R.id.et_nilai)
    EditText etNilai;
    @BindView(R.id.et_isi_pesan)
    EditText etIsiPesan;

    Halaqoh halaqoh;
    Ujian ujian;

    String isiPesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ujian);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detail Ujian");

        halaqoh = (Halaqoh) getIntent().getSerializableExtra("halaqoh");
        ujian = (Ujian) getIntent().getSerializableExtra("ujian");

        initView();
    }

    private void initView() {
        etHalaqoh.setText(halaqoh.namaHalaqoh);
        etNamaSantri.setText(halaqoh.namaSantri);
        etJumlahJuz.setText(ujian.juz);
        etNilai.setText(ujian.penilaian);
        etIsiPesan.setText("Assalamu'alaikum Bapak/Ibu Wali" + "\n" +
                "Alhamduliilah anak bapak " + halaqoh.namaSantri + " telah menyelesaikan hafalan juz " + ujian.juz + " " +
                "dengan nilai " + ujian.penilaian + "\n" +
                "Semoga anak bapak bisa mengamalkan hafalan Qur'annya serta dapat menjaga hafalannya, Aamiin..");
    }

    @OnClick(R.id.btn_kirim)
    public void onViewClicked() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_SUBJECT, halaqoh.nomorHP);
        intent.putExtra(Intent.EXTRA_TEXT, isiPesan);
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent, "Kirim Pesan"));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
