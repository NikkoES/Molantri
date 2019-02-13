package com.ahsin.molantri.activity.ujian;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.activeandroid.query.Select;
import com.ahsin.molantri.R;
import com.ahsin.molantri.activity.hafalan.KelolaHafalanActivity;
import com.ahsin.molantri.activity.hafalan.ListHafalanActivity;
import com.ahsin.molantri.adapter.HalaqohAdapter;
import com.ahsin.molantri.model.Halaqoh;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KelolaUjianActivity extends AppCompatActivity {

    @BindView(R.id.list_view)
    ListView listView;

    HalaqohAdapter adapter;

    List<Halaqoh> listHalaqoh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelola_ujian);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Kelola Ujian");
    }

    @Override
    protected void onResume() {
        super.onResume();
        initList();
    }

    private void initList() {
        listHalaqoh = new Select().from(Halaqoh.class).execute();

        adapter = new HalaqohAdapter(this, listHalaqoh);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Halaqoh halaqoh = adapter.getItem(position);

                Intent intent = new Intent(KelolaUjianActivity.this, ListUjianActivity.class);
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
}
