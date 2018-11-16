package com.example.oeloem.letsadventure;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class AdapterGunung extends RecyclerView.Adapter<AdapterGunung.ViewHolder> {
    Context context;
    String[] daftarGunung;
    int[] gambarGunung;

    public AdapterGunung(Context context, String[] daftarGunung, int[] gambarGunung) {
        this.context = context;
        this.daftarGunung = daftarGunung;
        this.gambarGunung = gambarGunung;
    }

    @NonNull
    @Override
    public AdapterGunung.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_hiking,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterGunung.ViewHolder viewHolder, int i) {
        viewHolder.txtgunung.setText(daftarGunung[i]);
        Glide.with(context).load(gambarGunung[i]).into(viewHolder.imgDaftarGunung);
        viewHolder.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Your Like This",Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"You Have Shared",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return gambarGunung.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button btnFavorite,btnShare;
        TextView txtgunung;
        ImageView imgDaftarGunung;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtgunung = itemView.findViewById(R.id.txtDaftarGunung);
            imgDaftarGunung = itemView.findViewById(R.id.imgGunung);
            btnFavorite = itemView.findViewById(R.id.btnFavorite);
            btnShare = itemView.findViewById(R.id.btnShare);
        }
    }
}

