package com.example.oeloem.letsadventure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RecyclerHotel extends AppCompatActivity {

    @BindView(R.id.recycleHotel)
    RecyclerView recycleHotel;

    String[] daftarHotel,infoHotel;
    int[] gambarHotel = {R.drawable.infosatuinggris,R.drawable.infoduamesir,R.drawable.infotigakamboja,R.drawable.infoempatindonesia,R.drawable.infolimachina,R.drawable.infoenamindia,R.drawable.infotujuhyunani,R.drawable.infodelapanitalia,R.drawable.infosembilanprancis};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_hotel);
        ButterKnife.bind(this);

        daftarHotel = getResources().getStringArray(R.array.daftar_hotel);
        infoHotel = getResources().getStringArray(R.array.detail_hotel);

        AdapterHotel adapterHotel = new AdapterHotel(RecyclerHotel.this,gambarHotel,daftarHotel,infoHotel);

        recycleHotel.setHasFixedSize(true);
        recycleHotel.setLayoutManager(new LinearLayoutManager(this));
        recycleHotel.setAdapter(adapterHotel);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.action_hotel:
                intent = new Intent(this,RecyclerHotel.class);
                startActivity(intent);
                finish();
                break;

            case R.id.action_profile:
                intent = new Intent(this,Profile.class);
                startActivity(intent);
                finish();
                break;

            case  R.id.action_about:
                intent = new Intent(this,About.class);
                startActivity(intent);
                finish();
                break;

            case R.id.action_Home:
                intent = new Intent(this,RecyclerLetsAdventure.class);
                startActivity(intent);
                finish();
                break;

            case R.id.action_Gunung:
                intent = new Intent(this,RecycleGunung.class);
                startActivity(intent);
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}