package com.ahsin.molantri.activity.hafalan;

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
import com.ahsin.molantri.adapter.HafalanAdapter;
import com.ahsin.molantri.model.Hafalan;
import com.ahsin.molantri.model.Halaqoh;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListHafalanActivity extends AppCompatActivity {

    @BindView(R.id.txtNama)
    TextView txtNama;
    @BindView(R.id.txtHalaqoh)
    TextView txtHalaqoh;
    @BindView(R.id.grid_view)
    GridView gridView;

    HafalanAdapter adapter;

    Halaqoh halaqoh;
    List<Hafalan> listHafalan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hafalan);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Daftar Hafalan Santri");

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
        listHafalan = new Select().from(Hafalan.class).where("nama_santri = ?", halaqoh.namaSantri).execute();

        adapter = new HafalanAdapter(this, listHafalan);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Hafalan hafalan = adapter.getItem(position);

                Intent intent = new Intent(ListHafalanActivity.this, DetailHafalanActivity.class);
                intent.putExtra("hafalan", hafalan);
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
        Intent intent = new Intent(this, TambahHafalanActivity.class);
        intent.putExtra("halaqoh", halaqoh);
        startActivity(intent);
    }
}
