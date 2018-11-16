package com.example.oeloem.letsadventure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InfoHotel extends AppCompatActivity {

    @BindView(R.id.txtGambarInfoHotel)
    ImageView txtGambarInfoHotel;
    @BindView(R.id.txtInfoHotel)
    TextView txtInfoHotel;

    @Override
    protected void onCreate(Bundle savedInstantState) {
        super.onCreate(savedInstantState);
        setContentView(R.layout.activity_info_hotel);
        ButterKnife.bind(this);

        Glide.with(this).load(getIntent().getIntExtra("ig", 0)).into(txtGambarInfoHotel);
        txtInfoHotel.setText(getIntent().getStringExtra("ii"));
    }
}
