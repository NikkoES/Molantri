package com.ahsin.molantri.activity.hafalan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.ahsin.molantri.R;
import com.ahsin.molantri.activity.halaqoh.DetailHalaqohActivity;
import com.ahsin.molantri.activity.halaqoh.KelolaHalaqohActivity;
import com.ahsin.molantri.adapter.HalaqohAdapter;
import com.ahsin.molantri.model.Halaqoh;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KelolaHafalanActivity extends AppCompatActivity {

    @BindView(R.id.list_view)
    ListView listView;

    HalaqohAdapter adapter;

    List<Halaqoh> listHalaqoh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelola_hafalan);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Kelola Hafalan");
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

                Intent intent = new Intent(KelolaHafalanActivity.this, ListHafalanActivity.class);
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
