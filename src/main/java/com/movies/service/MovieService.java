package com.movies.service;

import com.movies.entity.Movies;
import com.movies.payload.*;

import java.util.List;

public interface MovieService {
    List<LongestDurationMovieResponse> getLongestDurationMovies(int i);

    void saveNewMovie(MovieDto movieDto);

    List<TopRatedMovieresponse> findTopratedMovies(float v);

    List<SubTotalResponse> moviesWithSubTotal();

    void updateRunTimeMinutes();
}
