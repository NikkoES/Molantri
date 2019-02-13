package com.ahsin.molantri.activity.halaqoh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.ahsin.molantri.R;
import com.ahsin.molantri.model.Halaqoh;
import com.ahsin.molantri.utils.CommonUtil;
import com.ahsin.molantri.utils.DialogUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TambahHalaqohActivity extends AppCompatActivity {

    @BindView(R.id.et_halaqoh)
    EditText etHalaqoh;
    @BindView(R.id.et_nama_santri)
    EditText etNamaSantri;
    @BindView(R.id.et_tanggal_lahir)
    EditText etTanggalLahir;
    @BindView(R.id.et_kelas)
    EditText etKelas;
    @BindView(R.id.et_asal)
    EditText etAsal;
    @BindView(R.id.et_hp)
    EditText etHp;
    @BindView(R.id.rg_gender)
    RadioGroup rgGender;
    @BindView(R.id.et_alamat)
    EditText etAlamat;

    ArrayList<View> viewList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_halaqoh);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tambah Halaqoh");
    }

    private void checkValidate() {
        viewList.add(etHalaqoh);
        viewList.add(etNamaSantri);
        viewList.add(etTanggalLahir);
        viewList.add(etKelas);
        viewList.add(etAsal);
        viewList.add(etHp);
        viewList.add(etAlamat);
        if (CommonUtil.validateEmptyEntries(viewList)) {
            addHalaqoh();
        }
    }

    private void addHalaqoh() {
        Halaqoh halaqoh = new Halaqoh();
        halaqoh.namaHalaqoh = etHalaqoh.getText().toString();
        halaqoh.namaSantri = etNamaSantri.getText().toString();
        halaqoh.tanggalLahir = etTanggalLahir.getText().toString();
        halaqoh.kelas = etKelas.getText().toString();
        halaqoh.asal = etAsal.getText().toString();
        halaqoh.nomorHP = etHp.getText().toString();
        halaqoh.alamat = etAlamat.getText().toString();
        if (rgGender.getCheckedRadioButtonId() == R.id.ikhwan) {
            halaqoh.jenisKelamin = "Ikhwan";
        } else {
            halaqoh.jenisKelamin = "Akhwat";
        }
        halaqoh.save();
        finish();
    }

    @OnClick({R.id.et_tanggal_lahir, R.id.button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.et_tanggal_lahir:
                DialogUtils.dialogTanggalFormat(this, etTanggalLahir, "dd MMMM yyyy");
                break;
            case R.id.button:
                checkValidate();
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
