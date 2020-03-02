package com.example.hero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    private ImageView gambar;
    private TextView nama,deskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hero_detail);

        gambar = findViewById(R.id.hero_image);
        nama = findViewById(R.id.hero_name);
        deskripsi = findViewById(R.id.hero_detail);

        Bundle bundle = getIntent().getExtras();
        String nameHero = bundle.getString("nama");
        String deskripsiHero = bundle.getString("deskripsi");
        String gambarHero = bundle.getString("gambar");
        nama.setText(nameHero);
        deskripsi.setText(deskripsiHero);
        Glide.with(this).load(gambarHero).into(gambar);

    }
}