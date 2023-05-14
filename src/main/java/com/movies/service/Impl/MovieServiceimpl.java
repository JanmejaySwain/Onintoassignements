package com.movies.service.Impl;

import com.movies.entity.Movies;
import com.movies.entity.Ratings;
import com.movies.payload.*;
import com.movies.repository.MoviesRepository;
import com.movies.repository.RatingsRepository;
import com.movies.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceimpl implements MovieService {

    private ModelMapper mapper;
    private MoviesRepository moviesRepository;
    private RatingsRepository ratingsRepository;

    public MovieServiceimpl(ModelMapper mapper, MoviesRepository moviesRepository, RatingsRepository ratingsRepository) {
        this.mapper = mapper;
        this.moviesRepository = moviesRepository;
        this.ratingsRepository = ratingsRepository;
    }

    @Override
    public List<LongestDurationMovieResponse> getLongestDurationMovies(int i) {
        List<Movies> listOfMovies = moviesRepository.findTopNByOrderByRuntimeMinutesDesc(i);
        List<LongestDurationMovieResponse> responseList=new ArrayList<>();
        for(Movies movie:listOfMovies)
        {
            LongestDurationMovieResponse response=new LongestDurationMovieResponse();
            response.setTconst(movie.getTconst());
            response.setGenres(movie.getGenres());
            response.setPrimaryTitle(movie.getPrimaryTitle());
            response.setRuntimeMinutes(movie.getRuntimeMinutes());
            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public void saveNewMovie(MovieDto movieDto) {
        Movies movie = movieDtoToEntity(movieDto);
        moviesRepository.save(movie);
    }

    @Override
    public List<TopRatedMovieresponse> findTopratedMovies(float v) {
        List<Ratings> listOfRatings = ratingsRepository.findTopByOrderByAverageRatingAsc(v);
        List<TopRatedMovieresponse> movieresponseList=new ArrayList<>();
        for(Ratings rating:listOfRatings)
        {
            TopRatedMovieresponse ratedMovieresponse=new TopRatedMovieresponse();
            ratedMovieresponse.setTconst(rating.getTconst());
            ratedMovieresponse.setAverageRating(rating.getAverageRating());
            ratedMovieresponse.setGenres(rating.getMovie().getGenres());
            ratedMovieresponse.setPrimaryTitle(rating.getMovie().getPrimaryTitle());
            movieresponseList.add(ratedMovieresponse);
        }
        return movieresponseList;
    }

    @Override
    public List<SubTotalResponse> moviesWithSubTotal() {
        List<SubTotalResponse> responseList =new ArrayList<>();
        List<Object[]> objects = moviesRepository.getMoviesGenreWiseWithNumVotesSubtotals();
        for(Object[] row:objects)
        {
            String genre=(String) row[0];
            BigDecimal numVotesSubtotal = (BigDecimal) row[1];
            responseList.add(new SubTotalResponse(genre,numVotesSubtotal.longValue()));
        }

        return responseList;
    }

    @Override
    public void updateRunTimeMinutes() {
       moviesRepository.incrementRuntimeMinutes(15,30,45);
    }

    private Movies movieDtoToEntity(MovieDto movieDto)
    {
        return mapper.map(movieDto,Movies.class);
    }
    private MovieDto movieEntityToDto(Movies movies)
    {
        return mapper.map(movies,MovieDto.class);
    }


}
