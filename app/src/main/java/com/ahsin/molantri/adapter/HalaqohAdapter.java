package com.ahsin.molantri.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ahsin.molantri.R;
import com.ahsin.molantri.model.Halaqoh;

import java.util.List;

public class HalaqohAdapter extends ArrayAdapter<Halaqoh> {

    public HalaqohAdapter(Context context, List<Halaqoh> listHalaqoh) {
        super(context, R.layout.item_list_santri, listHalaqoh);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_list_santri, null);
        }

        TextView txtNama = (TextView) view.findViewById(R.id.txtNama);
        TextView txtHalaqoh = (TextView) view.findViewById(R.id.txtHalaqoh);

        Halaqoh halaqoh = getItem(position);

        // set data ke view
        txtNama.setText(halaqoh.namaSantri);
        txtHalaqoh.setText(halaqoh.namaHalaqoh);

        return view;
    }


}
