package com.example.myhospital;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdp  extends SliderViewAdapter<SliderAdp.Holder> {
    //initialize variable
    int[] images;

    //constructor
    public SliderAdp(int[] images){
        this.images=images;
    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent) {
        //initialize view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_slider,parent,false);


        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder viewHolder, int position) {
//set image
        viewHolder.imageView.setImageResource(images[position]);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    public class Holder extends SliderViewAdapter.ViewHolder {
        //initialize variable
        ImageView imageView;
        public Holder(View itemView) {
            super(itemView);
            //Assign variable
            imageView =itemView.findViewById(R.id.image_view);
        }
    }
}
