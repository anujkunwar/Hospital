package com.example.myhospital;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BloodListView extends ArrayAdapter<String> {
    private String[] blood;
    private Activity context1;
    public BloodListView(Activity context, String[] blood) {
        super(context, R.layout.layout, blood);
        this.context1 = context;
        this.blood = blood;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r1 = convertView;
        ViewHolder viewHolder1 = null;
        if (r1 == null) {
            LayoutInflater layoutInflater1 = context1.getLayoutInflater();
            r1 = layoutInflater1.inflate(R.layout.layout1, null, true);
            viewHolder1 = new ViewHolder(r1);
            r1.setTag(viewHolder1);
        } else {
            viewHolder1 = (ViewHolder) r1.getTag();
        }
        viewHolder1.tvw0.setText(blood[position]);
        return r1;
    }
    class ViewHolder {
        TextView tvw0;
        ViewHolder(View v) {
            tvw0 = (TextView) v.findViewById(R.id.dblood);
        }

    }


}
