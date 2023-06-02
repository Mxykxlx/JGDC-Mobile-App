package com.example.finalproject;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class li extends RecyclerView.Adapter<li.ViewHolder>{

    Context context;
    int layout;
    ArrayList<Accounts> acc ;
    OnItemClickListener listener;

    public li(Context context, int layout, ArrayList<Accounts> acc) {
        this.context = context;
        this.layout = layout;
        this.acc = acc;
    }

    @NonNull
    @Override
    public li.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater infltr = LayoutInflater.from(context);
        View conView = infltr.inflate(layout,parent,false);
        ViewHolder vh = new ViewHolder(conView);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder vh, int position) {

        vh.img.setImageBitmap(acc.get(position).getImg());
        vh.ttl.setText(acc.get(position).getTtl());
        vh.rmrks.setText(acc.get(position).getRmrks());
        vh.bday.setText(acc.get(position).getBday());
        vh.gndr.setText(acc.get(position).getGndr());
        vh.hbbs.setText(acc.get(position).getHbbs());
    }

    public interface OnItemClickListener{
        void OnItemClick(int position);

        void OnItemDelete(int position);

        void OnItemEdit(int position);

    }

    public void setOnItemClickListener(OnItemClickListener listenerActivity) {
        listener = listenerActivity;
    }



    @Override
    public int getItemCount() {
        return acc.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img, btnDelete;
        TextView ttl, rmrks, bday, gndr, hbbs;
        Button btnEdit, add;


        public ViewHolder(@NonNull View conView) {
            super(conView);
            this.img = conView.findViewById(R.id.imgVxml);
            this.ttl = conView.findViewById(R.id.nameListXML);
            this.rmrks = conView.findViewById(R.id.remarksListXML);
            this.bday = conView.findViewById(R.id.fordaBday);
            this.gndr = conView.findViewById(R.id.fordaGndr);
            this.hbbs = conView.findViewById(R.id.fordaHbbs);
            this.btnEdit = conView.findViewById(R.id.btnEdit);
            this.btnDelete = conView.findViewById(R.id.btnDelete);
            this.add = conView.findViewById(R.id.add);

            conView.setOnClickListener(view -> {
                if(listener != null){
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION){
                        listener.OnItemClick(position);
                    }
                }
            });

            btnEdit.setOnClickListener(view -> {
                if(listener != null){
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION){
                        listener.OnItemEdit(position);
                    }
                }
            });

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.OnItemDelete(position);
                        }
                    }
                }
            });

        }
    }
}
