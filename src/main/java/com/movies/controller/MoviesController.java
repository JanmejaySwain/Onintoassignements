package com.movies.controller;

import com.movies.payload.*;
import com.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class MoviesController {
    @Autowired
    private MovieService movieService;

    @GetMapping("longest-duration-movies")
    public ResponseEntity<List<LongestDurationMovieResponse>> longestDurationMovies()
    {
        return new ResponseEntity<>(movieService.getLongestDurationMovies(10), HttpStatus.OK);
    }
    @PostMapping("new-movie")
    public ResponseEntity<String> saveNewMovie(@RequestBody MovieDto movieDto)
    {
        movieService.saveNewMovie(movieDto);
        return new ResponseEntity<>("sucess",HttpStatus.CREATED);
    }
    @GetMapping("top-rated-movies")
    public ResponseEntity<List<TopRatedMovieresponse>> topRatedMovies()
    {
        return new ResponseEntity<>(movieService.findTopratedMovies(6.0f),HttpStatus.OK);
    }
    @GetMapping("genre-movies-with-subtotals")
    public ResponseEntity<List<SubTotalResponse>>moviesWithSubTotals()
    {
        return new ResponseEntity<>(movieService.moviesWithSubTotal(),HttpStatus.OK);
    }

    @GetMapping("update-runtime-minutes")
    public ResponseEntity<String> updateRunTimeMinutes()

    {
        movieService.updateRunTimeMinutes();
        return new ResponseEntity<>("Data updated Successfully",HttpStatus.ACCEPTED);
    }
}
