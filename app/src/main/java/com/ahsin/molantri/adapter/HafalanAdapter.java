package com.ahsin.molantri.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ahsin.molantri.R;
import com.ahsin.molantri.model.Hafalan;
import com.ahsin.molantri.model.Halaqoh;

import java.util.List;

public class HafalanAdapter extends ArrayAdapter<Hafalan> {

    private Context context;
    private List<Hafalan> listHafalan;

    public HafalanAdapter(Context context, List<Hafalan> listHafalan) {
        super(context, R.layout.item_list_hafalan, listHafalan);
        this.context = context;
        this.listHafalan = listHafalan;
    }

    @Override
    public int getCount() {
        return listHafalan.size();
    }

    @Override
    public Hafalan getItem(int position) {
        return listHafalan.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_list_hafalan, null);
        }

        TextView txtParaf = (TextView) view.findViewById(R.id.txt_paraf);
        TextView txtJuz = (TextView) view.findViewById(R.id.txt_surah);

        Hafalan hafalan = getItem(position);

        // set data ke view
        txtParaf.setText(hafalan.jumlahAyat+" Ayat");
        txtJuz.setText(hafalan.juz);

        return view;
    }


}
