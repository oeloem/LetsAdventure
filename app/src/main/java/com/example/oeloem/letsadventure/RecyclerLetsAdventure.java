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
import android.widget.Adapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerLetsAdventure extends AppCompatActivity {

    @BindView(R.id.myRecycleView)
    RecyclerView myRecycleView;

    String[] namaDestinasi,isiDestinasi;
    int[] gambarDestinasi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_lets_adventure);
        ButterKnife.bind(this);

        namaDestinasi = getResources().getStringArray(R.array.daftar_judul);
        isiDestinasi = getResources().getStringArray(R.array.isi_judul);
        gambarDestinasi = new int[]{R.drawable.duainggris,R.drawable.tigamesir,R.drawable.empatkamboja,R.drawable.limaindonesia,R.drawable.enamchina,R.drawable.tujuhindia,R.drawable.delapanyunani,R.drawable.sembilanpisaitalia,R.drawable.sepuluhperancis};


        AdapterLets adapterLets = new AdapterLets(RecyclerLetsAdventure.this,gambarDestinasi,namaDestinasi,isiDestinasi);

        myRecycleView.setHasFixedSize(true);
        myRecycleView.setLayoutManager(new LinearLayoutManager(this));
        myRecycleView.setAdapter(adapterLets);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();

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
