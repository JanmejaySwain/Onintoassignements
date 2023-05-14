package com.movies.repository;


import com.movies.entity.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingsRepository extends JpaRepository<Ratings, String> {
    @Query(value = "SELECT * FROM oninto_technologies_test_db.ratings WHERE average_rating > ? ORDER BY average_rating ASC",nativeQuery = true)
    List<Ratings> findTopByOrderByAverageRatingAsc(float v);
}
