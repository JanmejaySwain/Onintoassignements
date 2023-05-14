package com.movies.payload;

import lombok.Data;

@Data
public class TopRatedMovieresponse {
    private String tconst;
    private String primaryTitle;
    private String genres;
    private float averageRating;
}
