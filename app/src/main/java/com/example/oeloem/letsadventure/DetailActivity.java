package com.example.oeloem.letsadventure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.imgDetailGambar)
    ImageView imgDetailGambar;
    @BindView(R.id.txtIsiDetail)
    TextView txtIsiDetail;

    @Override
    protected void onCreate(Bundle savedInstantState) {
        super.onCreate(savedInstantState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Glide.with(this). load(getIntent(). getIntExtra("dg",0)).into(imgDetailGambar);
        txtIsiDetail.setText(getIntent().getStringExtra("dn"));
        txtIsiDetail.setText(getIntent().getStringExtra("in"));
    }
}
