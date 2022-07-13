package com.example.myhospital;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class AdminDoctorListView extends ArrayAdapter<String> {


    private String[] dname;
    private String[] dtype;
    private String[] dphone;
    private String[] daddress;
    private String[] demail;
    private Activity context8;


    public AdminDoctorListView(Activity context, String[] dname, String[] dtype, String[] dphone,String[] daddress, String[] demail) {
        super(context, R.layout.layout, dname);
        this.context8 = context;
        this.dname = dname;
        this.dtype = dtype;
        this.dphone = dphone;
        this.daddress = daddress;
        this.demail = demail;
    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        AdminDoctorListView.ViewHolder viewHolder = null;
        if (r == null) {
            LayoutInflater layoutInflater = context8.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.admin_doctor, null, true);
            viewHolder = new AdminDoctorListView.ViewHolder(r);
            r.setTag(viewHolder);
        } else {
            viewHolder = (AdminDoctorListView.ViewHolder) r.getTag();

        }

        viewHolder.tvw1.setText(dname[position]);
        viewHolder.tvw2.setText(dtype[position]);
        viewHolder.tvw3.setText(dphone[position]);
        viewHolder.tvw4.setText(demail[position]);
        viewHolder.tvw5.setText(daddress[position]);

        return r;
    }

    class ViewHolder {

        TextView tvw1;
        TextView tvw2;
        TextView tvw3;
        TextView tvw4;
        TextView tvw5;

        ViewHolder(View v) {
            tvw1 = (TextView) v.findViewById(R.id.dname3);
            tvw2 = (TextView) v.findViewById(R.id.dtype3);
            tvw3= (TextView) v.findViewById(R.id.dphone3);
            tvw4 = (TextView) v.findViewById(R.id.daddress3);
            tvw5= (TextView) v.findViewById(R.id.demail3);
        }

    }

}
