package com.ahsin.molantri.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.ahsin.molantri.R;
import com.ahsin.molantri.data.Session;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.et_nip)
    EditText etNip;

    String nip, kode;

    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        session = new Session(this);
    }

    @OnClick(R.id.login)
    public void onViewClicked() {
        if (!TextUtils.isEmpty(etNip.getText().toString())) {
            kode = "12345";
            nip = etNip.getText().toString();

            if (nip.equalsIgnoreCase(kode)) {
                session.createLoginSession(nip);
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                finish();
            }
        } else {
            Toast.makeText(this, "NIP belum diisi !", Toast.LENGTH_SHORT).show();
        }
    }
}
