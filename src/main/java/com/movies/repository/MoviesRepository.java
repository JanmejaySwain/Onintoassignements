package com.movies.repository;

import com.movies.entity.Movies;
import com.movies.payload.SubTotalResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import java.util.List;

@Repository
public interface MoviesRepository extends JpaRepository<Movies,String> {
    @Query(value = "SELECT * FROM oninto_technologies_test_db.movies ORDER BY runtime_minutes DESC LIMIT ?",nativeQuery = true)
    List<Movies> findTopNByOrderByRuntimeMinutesDesc(int n);
    @Query(value = "SELECT m.genres, SUM(r.num_votes) AS numVotesSubtotal FROM Movies m JOIN Ratings r ON m.tconst = r.tconst GROUP BY m.genres",nativeQuery = true)
    List<Object[]> getMoviesGenreWiseWithNumVotesSubtotals();


    @Transactional
    @Modifying
    @Query(value = "UPDATE movies AS m SET m.runtime_minutes = CASE  WHEN m.genres = 'Documentary' THEN m.runtime_minutes + ? WHEN m.genres = 'Animation' THEN m.runtime_minutes + ? ELSE m.runtime_minutes + ? END", nativeQuery = true)
    int incrementRuntimeMinutes(int a,int b,int c);
}
