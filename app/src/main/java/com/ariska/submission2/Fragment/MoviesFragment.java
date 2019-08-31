package com.ariska.submission2.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ariska.submission2.Model.Movie;
import com.ariska.submission2.Data.MovieData;
import com.ariska.submission2.Adapter.MoviesAdapter;
import com.ariska.submission2.R;

import java.util.ArrayList;

public class MoviesFragment extends Fragment implements MoviesAdapter.OnclickListener{

    RecyclerView rv_movies;
    MoviesAdapter moviesAdapter;

    public MoviesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies, container, false);

        rv_movies = view.findViewById(R.id.rv_movie_list);
        rv_movies.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_movies.setHasFixedSize(true);

        ArrayList<Movie> movies = new ArrayList<>();
        movies.addAll(MovieData.getMovies());
        moviesAdapter = new MoviesAdapter(getActivity(), movies);
        rv_movies.setAdapter(moviesAdapter);
        return view;
    }

    @Override
    public void onClick(Movie movie){

    }
}
