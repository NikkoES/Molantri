package com.ahsin.molantri.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ahsin.molantri.R;
import com.ahsin.molantri.model.Hafalan;
import com.ahsin.molantri.model.Ujian;

import java.util.List;

public class UjianAdapter extends ArrayAdapter<Ujian> {

    private Context context;
    private List<Ujian> listUjian;

    public UjianAdapter(Context context, List<Ujian> listUjian) {
        super(context, R.layout.item_list_ujian, listUjian);
        this.context = context;
        this.listUjian = listUjian;
    }

    @Override
    public int getCount() {
        return listUjian.size();
    }

    @Override
    public Ujian getItem(int position) {
        return listUjian.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_list_ujian, null);
        }

        TextView txtTanggal = (TextView) view.findViewById(R.id.txt_tanggal);
        TextView txtJuz = (TextView) view.findViewById(R.id.txt_surah);

        Ujian ujian = getItem(position);

        // set data ke view
        txtTanggal.setText(ujian.tanggalUjian);
        txtJuz.setText(ujian.juz);

        return view;
    }


}
