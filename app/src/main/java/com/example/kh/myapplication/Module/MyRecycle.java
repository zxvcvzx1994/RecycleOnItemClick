package com.example.kh.myapplication.Module;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kh.myapplication.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by kh on 5/18/2017.
 */

public class MyRecycle extends RecyclerView.Adapter<MyRecycle.MyView_Holder>  {
    public static  Context context;
    List<Comunicater> list = Collections.emptyList();
    int resource;
    public  MyRecycle(Context context,int resource, List<Comunicater> list){
        this.context  =context;
        this.list = list;
        this.resource = resource;
    }

    @Override
    public MyView_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent, false );
        MyView_Holder holder = new MyView_Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyView_Holder holder, int position) {
        Comunicater  comunicater =  list.get(position);
            holder.txt.setText(comunicater.title);
        holder.im.setImageResource(comunicater.icon);
    }

    public void delete(int positon){
            list.remove(positon);
        notifyItemRemoved(positon);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class MyView_Holder extends RecyclerView.ViewHolder implements RecyclerView.OnClickListener  {
        ImageView im;
        TextView txt;
        public MyView_Holder(View itemView) {
            super(itemView);
            im  = (ImageView) itemView.findViewById(R.id.imIcon);
            txt = (TextView) itemView.findViewById(R.id.txtTittle);
        itemView.setOnClickListener(this);



        }


        @Override
        public void onClick(View v) {
            Toast.makeText(context, ""+getAdapterPosition(), Toast.LENGTH_SHORT).show();
        }
    }


}

