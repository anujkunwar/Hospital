package com.example.myhospital;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AdminMedicineListView extends ArrayAdapter<String> {

    private String[] medicine;
    private String[] type;
    private String[] volume;
    private Activity context6;


    public AdminMedicineListView(Activity context, String[] medicine, String[] type, String[] volume) {
        super(context, R.layout.layout, medicine);
        this.context6 = context;
        this.medicine = medicine;
        this.type = type;
        this.volume = volume;
    }


    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        com.example.myhospital.AdminMedicineListView.ViewHolder viewHolder = null;

        if (r == null) {
            LayoutInflater layoutInflater = context6.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.layout2, null, true);
            viewHolder = new AdminMedicineListView.ViewHolder(r);
            r.setTag(viewHolder);
        }

        else {
            viewHolder = (com.example.myhospital.AdminMedicineListView.ViewHolder) r.getTag();

        }

        viewHolder.tvw1.setText(medicine[position]);
        viewHolder.tvw2.setText(type[position]);
        viewHolder.tvw3.setText(volume[position]);

        return r;
    }

    class ViewHolder {

        TextView tvw1;
        TextView tvw2;
        TextView tvw3;

        ViewHolder(View v) {
            tvw1 = (TextView) v.findViewById(R.id.dmedicine);
            tvw2 = (TextView) v.findViewById(R.id.dtype);
            tvw3= (TextView) v.findViewById(R.id.dvolume);
        }

    }

}
