package com.example.myhospital;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;



public class DoctorListView extends ArrayAdapter<String> {


    private String[] dname;
    private String[] dtype;
    private String[] dphone;
    private Activity context3;


    public DoctorListView(Activity context, String[] dname, String[] dtype, String[] dphone) {
        super(context, R.layout.layout, dname);
        this.context3 = context;
        this.dname = dname;
        this.dtype = dtype;
        this.dphone = dphone;
    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        DoctorListView.ViewHolder viewHolder = null;
        if (r == null) {
            LayoutInflater layoutInflater = context3.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.layout3, null, true);
            viewHolder = new DoctorListView.ViewHolder(r);
            r.setTag(viewHolder);
        } else {
            viewHolder = (DoctorListView.ViewHolder) r.getTag();

        }

        viewHolder.tvw1.setText(dname[position]);
        viewHolder.tvw2.setText(dtype[position]);
        viewHolder.tvw3.setText(dphone[position]);

        return r;
    }

    class ViewHolder {

        TextView tvw1;
        TextView tvw2;
        TextView tvw3;

        ViewHolder(View v) {
            tvw1 = (TextView) v.findViewById(R.id.dname3);
            tvw2 = (TextView) v.findViewById(R.id.dtype3);
            tvw3= (TextView) v.findViewById(R.id.dphone3);
        }

    }

}
