package com.example.oeloem.letsadventure;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdapterHotel extends RecyclerView.Adapter<AdapterHotel.ViewHolder> {

    Context context;
    int[] gambarHoltel;
    String[] daftarHotel,infoHotel;

    public AdapterHotel(Context context, int[] gambarHoltel, String[] daftarHotel, String[] infoHotel) {
        this.context = context;
        this.gambarHoltel = gambarHoltel;
        this.daftarHotel = daftarHotel;
        this.infoHotel = infoHotel;
    }

    @NonNull
    @Override
    public AdapterHotel.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_pesan_hotel,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHotel.ViewHolder viewHolder, final int i) {

        viewHolder.txtDaftarHotel.setText(daftarHotel[i]);
        Glide.with(context).load(gambarHoltel[i]).into(viewHolder.imgHotel);
        viewHolder.btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,InfoHotel.class);
                intent.putExtra("id",daftarHotel[i]);
                intent.putExtra("ii",infoHotel[i]);
                intent.putExtra("ig",gambarHoltel[i]);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return gambarHoltel.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button btnPesan;
        TextView txtDaftarHotel,txtInfoHotel;
        ImageView imgHotel;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDaftarHotel = itemView.findViewById(R.id.txtDaftarHotel);
            imgHotel = itemView.findViewById(R.id.imgGambarHotel);
            btnPesan = itemView.findViewById(R.id.btnPesan);
            txtInfoHotel = itemView.findViewById(R.id.txtInfoHotel);
        }
    }
}


