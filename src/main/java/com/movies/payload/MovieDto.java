package com.movies.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class MovieDto {
    private String tconst;
    private String titleType;
    private String primaryTitle;
    private int runtimeMinutes;
    private String genres;
}
