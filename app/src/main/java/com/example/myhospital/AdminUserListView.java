package com.example.myhospital;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AdminUserListView extends ArrayAdapter<String> {
    private String[] username;
    private String[] email;
    private Activity context7;


    public AdminUserListView(Activity context, String[] username, String[] email) {
        super(context, R.layout.layout, username);
        this.context7 = context;
        this.username = username;
        this.email = email;

    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        com.example.myhospital.AdminUserListView.ViewHolder viewHolder = null;

        if (r == null) {
            LayoutInflater layoutInflater = context7.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.admin_userlist, null, true);
            viewHolder = new AdminUserListView.ViewHolder(r);
            r.setTag(viewHolder);
        }

        else {
            viewHolder = (com.example.myhospital.AdminUserListView.ViewHolder) r.getTag();

        }

        viewHolder.tvw1.setText(username[position]);
        viewHolder.tvw2.setText(email[position]);

        return r;
    }

    class ViewHolder {

        TextView tvw1;
        TextView tvw2;


        ViewHolder(View v) {
            tvw1 = (TextView) v.findViewById(R.id.dusername);
            tvw2 = (TextView) v.findViewById(R.id.demail);

        }

    }

}
