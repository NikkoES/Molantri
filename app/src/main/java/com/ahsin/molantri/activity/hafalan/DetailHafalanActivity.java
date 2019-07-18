package com.ahsin.molantri.activity.hafalan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;

import com.ahsin.molantri.R;
import com.ahsin.molantri.model.Hafalan;
import com.ahsin.molantri.model.Halaqoh;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailHafalanActivity extends AppCompatActivity {

    @BindView(R.id.et_halaqoh)
    EditText etHalaqoh;
    @BindView(R.id.et_nama_santri)
    EditText etNamaSantri;
    @BindView(R.id.et_jumlah_juz)
    EditText etJumlahJuz;
    @BindView(R.id.et_isi_pesan)
    EditText etIsiPesan;

    Halaqoh halaqoh;
    Hafalan hafalan;

    String isiPesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hafalan);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detail Hafalan");

        halaqoh = (Halaqoh) getIntent().getSerializableExtra("halaqoh");
        hafalan = (Hafalan) getIntent().getSerializableExtra("hafalan");

        initView();
    }

    private void initView() {
        etHalaqoh.setText(halaqoh.namaHalaqoh);
        etNamaSantri.setText(halaqoh.namaSantri);
        etJumlahJuz.setText(hafalan.juz);
        isiPesan = "Assalamu'alaikum Bapak/Ibu Wali" + "\n" +
                "Alhamduliilah anak bapak " + halaqoh.namaSantri + " telah menyelesaikan hafalan juz " + hafalan.juz + "\n" +
                "Semoga anak bapak bisa mengamalkan hafalan Qur'annya serta dapat menjaga hafalannya, Aamiin..";
        etIsiPesan.setText(isiPesan);
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
