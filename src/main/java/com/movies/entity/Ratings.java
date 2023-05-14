package com.movies.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor@NoArgsConstructor
public class Ratings {
    @Id
    private String tconst;
    @Column(name = "averageRating")
    private float averageRating;
    @Column(name = "numVotes")
    private long numVotes;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tconst")
    private Movies movie;
}
