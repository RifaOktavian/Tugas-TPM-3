package com.example.hero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHero;
    private ArrayList<ModelHero> listHero = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHero = findViewById(R.id.rvHero);
        rvHero.setHasFixedSize(true);
        listHero.addAll(DataHero.getListHero());

        show();
    }

    public void show(){
        rvHero.setLayoutManager(new LinearLayoutManager(this));
        AdapterHero adapterHero = new AdapterHero(this);
        adapterHero.setModelHeroes(listHero);
        rvHero.setAdapter(adapterHero);
    }
}