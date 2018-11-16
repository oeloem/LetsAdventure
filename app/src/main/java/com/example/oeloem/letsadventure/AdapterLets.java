package com.example.oeloem.letsadventure;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdapterLets extends RecyclerView.Adapter<AdapterLets.ViewHolder> {
    Context context;
    int[] gambar;
    String[] daftar,isi;

    public AdapterLets(Context context, int[] gambar, String[] daftar, String[] isi) {
        this.context = context;
        this.gambar = gambar;
        this.daftar = daftar;
        this.isi = isi;
    }

    @NonNull
    @Override
    public AdapterLets.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_list_destinasi,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLets.ViewHolder viewHolder, final int i) {
        viewHolder.txtDaftar.setText(daftar[i]);
        Glide.with(context).load(gambar[i]).into(viewHolder.imgGambar);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("dn", daftar[i]);
                intent.putExtra("in", isi[i]);
                intent.putExtra("dg", gambar[i]);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return gambar.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtDaftar;
        ImageView imgGambar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDaftar = itemView.findViewById(R.id.txtNamaDestinasi);
            imgGambar = itemView.findViewById(R.id.imgGambarDestinasi);
        }
    }


}

