package com.example.myhospital;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;



public class AppointmentListView extends ArrayAdapter<String> {

    private String[] doctor_name;
    private String[] appointments_date;
    private String[] appointments_time;
    private String[] username;
    private Activity context5;


    public AppointmentListView(Activity context, String[] doctor_name, String[] appointments_date, String[] appointments_time, String[] username) {
        super(context, R.layout.layout, doctor_name);
        this.context5 = context;
        this.doctor_name = doctor_name;
        this.appointments_date= appointments_date;
        this.appointments_time = appointments_time;
        this.username = username;
    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        ViewHolder viewHolder = null;
        if (r == null) {
            LayoutInflater layoutInflater = context5.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.appointment_view_layout, null, true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) r.getTag();

        }

        viewHolder.tvw1.setText(doctor_name[position]);
        viewHolder.tvw2.setText(appointments_date[position]);
        viewHolder.tvw3.setText(appointments_time[position]);
        viewHolder.tvw4.setText(username[position]);

        return r;
    }

    class ViewHolder {

        TextView tvw1;
        TextView tvw2;
        TextView tvw3;
        TextView tvw4;

        ViewHolder(View v) {
            tvw1 = (TextView) v.findViewById(R.id.doctorname);
            tvw2 = (TextView) v.findViewById(R.id.date);
            tvw3= (TextView) v.findViewById(R.id.time);
            tvw4= (TextView) v.findViewById(R.id.username);
        }

    }

}