package com.example.hero;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.CollationElementIterator;
import java.util.ArrayList;

public class AdapterHero extends RecyclerView.Adapter<AdapterHero.ViewHolder> {
    private ArrayList<ModelHero> modelHeroes;
    public Context context;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hero_item,parent,false);

        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        Glide.with(context).load(getModelHeroes().get(position).getGambarHero()).into(holder.ivGambarHero);
        holder.tvNamaHero.setText(getModelHeroes().get(position).getNamaHero());
        holder.tvDeskripsiHero.setText(getModelHeroes().get(position).getDeskripsiHero());
        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra("nama",getModelHeroes().get(position).getNamaHero());
                intent.putExtra("deskripsi",getModelHeroes().get(position).getDeskripsiHero());
                intent.putExtra("gambar",getModelHeroes().get(position).getGambarHero());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getModelHeroes().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public CollationElementIterator tvDeskripsiHero;
        private ImageView ivGambarHero;
        private TextView tvNamaHero;
        private LinearLayout layoutItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivGambarHero = itemView.findViewById(R.id.Hero_image);
            tvNamaHero = itemView.findViewById(R.id.Hero_name);
            layoutItem = itemView.findViewById(R.id.layout_Item);
        }
    }

    public ArrayList<ModelHero> getModelHeroes() {
        return modelHeroes;
    }

    public void setModelHeroes(ArrayList<ModelHero> modelHeroes) {
        this.modelHeroes = modelHeroes;
    }

    public AdapterHero(Context context) {
        this.context = context;
    }
}