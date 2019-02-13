package com.ahsin.molantri.activity.ujian;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.activeandroid.query.Select;
import com.ahsin.molantri.R;
import com.ahsin.molantri.activity.hafalan.DetailHafalanActivity;
import com.ahsin.molantri.activity.hafalan.ListHafalanActivity;
import com.ahsin.molantri.activity.hafalan.TambahHafalanActivity;
import com.ahsin.molantri.adapter.HafalanAdapter;
import com.ahsin.molantri.adapter.UjianAdapter;
import com.ahsin.molantri.model.Hafalan;
import com.ahsin.molantri.model.Halaqoh;
import com.ahsin.molantri.model.Ujian;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListUjianActivity extends AppCompatActivity {

    @BindView(R.id.txtNama)
    TextView txtNama;
    @BindView(R.id.txtHalaqoh)
    TextView txtHalaqoh;
    @BindView(R.id.grid_view)
    GridView gridView;

    UjianAdapter adapter;

    Halaqoh halaqoh;
    List<Ujian> listUjian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ujian);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Daftar Ujian Santri");

        halaqoh = (Halaqoh) getIntent().getSerializableExtra("halaqoh");
    }

    @Override
    protected void onResume() {
        super.onResume();
        initList();
    }

    private void initList() {
        txtNama.setText(halaqoh.namaSantri);
        txtHalaqoh.setText(halaqoh.namaHalaqoh);
        listUjian = new Select().from(Ujian.class).where("nama_santri = ?", halaqoh.namaSantri).execute();

        adapter = new UjianAdapter(this, listUjian);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Ujian ujian = adapter.getItem(position);

                Intent intent = new Intent(ListUjianActivity.this, DetailUjianActivity.class);
                intent.putExtra("ujian", ujian);
                intent.putExtra("halaqoh", halaqoh);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.btn_tambah)
    public void onViewClicked() {
        Intent intent = new Intent(this, TambahUjianActivity.class);
        intent.putExtra("halaqoh", halaqoh);
        startActivity(intent);
    }
}
