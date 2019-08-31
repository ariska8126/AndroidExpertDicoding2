package com.ariska.submission2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ariska.submission2.Model.Movie;
import com.ariska.submission2.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<Movie> movies;

    public MoviesAdapter(Context mContext, ArrayList<Movie> movies) {
        this.mContext = mContext;
        this.movies = movies;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_movie, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Movie movie = movies.get(position);

        holder.tv_title.setText(movie.getTitle());
        holder.tv_overview.setText(movie.getOverview());
        Glide.with(mContext).load(movie.getImage()).into(holder.img_photo);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, movie.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public interface OnclickListener {
        void onClick(Movie movie);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_title, tv_overview;
        private ImageView img_photo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_overview = itemView.findViewById(R.id.tv_mov_overview);
            tv_title = itemView.findViewById(R.id.tv_mov_title);
            img_photo = itemView.findViewById(R.id.img_mov_photo);

        }
    }

}
