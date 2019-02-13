package com.ahsin.molantri.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ahsin.molantri.R;
import com.ahsin.molantri.activity.hafalan.KelolaHafalanActivity;
import com.ahsin.molantri.activity.halaqoh.KelolaHalaqohActivity;
import com.ahsin.molantri.activity.ujian.KelolaUjianActivity;
import com.ahsin.molantri.data.Session;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        session = new Session(this);
    }

    @OnClick({R.id.btn_halaqoh, R.id.btn_hafalan, R.id.btn_ujian, R.id.btn_logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_halaqoh:
                startActivity(new Intent(this, KelolaHalaqohActivity.class));
                break;
            case R.id.btn_hafalan:
                startActivity(new Intent(this, KelolaHafalanActivity.class));
                break;
            case R.id.btn_ujian:
                startActivity(new Intent(this, KelolaUjianActivity.class));
                break;
            case R.id.btn_logout:
                session.logoutUser();
                break;
        }
    }
}
