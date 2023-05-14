package com.movies.payload;

import lombok.Data;

@Data
public class LongestDurationMovieResponse {
    private String tconst;
    private String primaryTitle;
    private int runtimeMinutes;
    private String genres;
}
