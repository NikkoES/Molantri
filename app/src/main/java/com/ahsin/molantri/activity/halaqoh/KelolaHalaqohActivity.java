package com.ahsin.molantri.activity.halaqoh;

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
import com.ahsin.molantri.adapter.HalaqohAdapter;
import com.ahsin.molantri.model.Halaqoh;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class KelolaHalaqohActivity extends AppCompatActivity {

    @BindView(R.id.list_view)
    ListView listView;

    HalaqohAdapter adapter;

    List<Halaqoh> listHalaqoh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelola_halaqoh);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Kelola Halaqoh");
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

                Intent intent = new Intent(KelolaHalaqohActivity.this, DetailHalaqohActivity.class);
                intent.putExtra("halaqoh", halaqoh);
                startActivity(intent);
            }
        });

        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.list_view) {
            ListView lv = (ListView) v;
            AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) menuInfo;

            menu.add(Menu.NONE, 1, Menu.NONE, "Delete");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)
                item.getMenuInfo();
        Halaqoh halaqoh = adapter.getItem(info.position);

        if (item.getItemId() == 1) { // kondisi hapus
            adapter.remove(halaqoh);

            new Delete().from(Halaqoh.class).where("id=?", halaqoh.getId()).execute();

            adapter.notifyDataSetChanged();
        }

        return super.onContextItemSelected(item);
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
        startActivity(new Intent(this, TambahHalaqohActivity.class));
    }
}
