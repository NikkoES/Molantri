package com.ahsin.molantri.activity.hafalan;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ahsin.molantri.R;
import com.ahsin.molantri.model.Hafalan;
import com.ahsin.molantri.model.Halaqoh;
import com.ahsin.molantri.utils.DialogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TambahHafalanActivity extends AppCompatActivity {

    @BindView(R.id.et_juz)
    EditText etJuz;
    @BindView(R.id.et_tanggal_setoran)
    EditText etTanggalSetoran;
    @BindView(R.id.et_jumlah_setoran)
    EditText etJumlahSetoran;
    @BindView(R.id.btn_tambah)
    Button btnTambah;

    Halaqoh halaqoh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_hafalan);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tambah Hafalan");

        halaqoh = (Halaqoh) getIntent().getSerializableExtra("halaqoh");
    }


    @OnClick({R.id.et_tanggal_setoran, R.id.et_juz, R.id.btn_tambah})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.et_tanggal_setoran:
                DialogUtils.dialogTanggalFormat(this, etTanggalSetoran, "dd MMMM yyyy");
                break;
            case R.id.et_juz:
                final String[] juz = getResources().getStringArray(R.array.alquran);
                DialogUtils.dialogArray(this, juz, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        etJuz.setText(juz[which]);
                    }
                });
                break;
            case R.id.btn_tambah:
                tambahHafalan();
                break;
        }
    }

    private void tambahHafalan() {
        Hafalan hafalan = new Hafalan();
        hafalan.namaSantri = halaqoh.namaSantri;
        hafalan.juz = etJuz.getText().toString();
        hafalan.tanggalSetoran = etTanggalSetoran.getText().toString();
        hafalan.jumlahAyat = etJumlahSetoran.getText().toString();
        hafalan.save();
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
