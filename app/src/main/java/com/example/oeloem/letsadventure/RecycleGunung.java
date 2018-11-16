package com.example.oeloem.letsadventure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleGunung extends AppCompatActivity {

    @BindView(R.id.RecycleGunung)
    RecyclerView RecycleGunung;

    String[] daftar;
    int[] gambar = {R.drawable.gunungindonesiasatu, R.drawable.gunungdua, R.drawable.gunungtiga, R.drawable.gunungempat, R.drawable.gununglima, R.drawable.gunungenam, R.drawable.gunungtujuh, R.drawable.gunungdelapan, R.drawable.gunungsembilan, R.drawable.gunungsepuluh, R.drawable.gunungsebelas, R.drawable.gunungduabelas, R.drawable.gunungtigabelas, R.drawable.gunungempatbelas, R.drawable.gununglimabelas};


    @Override
    protected void onCreate(Bundle savedInstantState) {
        super.onCreate(savedInstantState);
        setContentView(R.layout.activity_recycle_gunung);
        ButterKnife.bind(this);

        daftar = getResources().getStringArray(R.array.daftar_gunung);

        AdapterGunung adapterGunung = new AdapterGunung(this, daftar, gambar);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu. menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;

        switch (item.getItemId()) {
            case R.id.action_hotel:
                intent = new Intent(this, RecyclerHotel.class);
                startActivity(intent);
                finish();
                break;

            case R.id.action_profile:
                intent = new Intent(this, Profile.class);
                startActivity(intent);
                finish();
                break;

            case R.id.action_about:
                intent = new Intent(this, About.class);
                startActivity(intent);
                finish();
                break;

            case R.id.action_Home:
                intent = new Intent(this, RecyclerLetsAdventure.class);
                startActivity(intent);
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);

    }
}



