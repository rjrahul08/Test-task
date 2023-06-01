package com.BackendCodingTest.Movies.Rating.Repository;

import com.BackendCodingTest.Movies.Rating.Model.Movies;
import com.BackendCodingTest.Movies.Rating.ResponseDTO.GenreMoviesWithSubtotalsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movies,Integer> {
    @Query("SELECT new com.example.GenreMoviesWithSubtotalsDTO(m.genre, m.primaryTitle, SUM(r.numVotes)) " +
            "FROM Movie m " +
            "JOIN Rating r ON m.tconst = r.tconst " +
            "GROUP BY m.genre, m.primaryTitle " +
            "ORDER BY m.genre")
    List<GenreMoviesWithSubtotalsDTO> getGenreMoviesWithSubtotals();

    @Modifying
    @Transactional
    @Query("UPDATE Movie m SET m.runtimeMinutes = " +
            "CASE WHEN m.genre = 'Documentary' THEN m.runtimeMinutes + 15 " +
            "     WHEN m.genre = 'Animation' THEN m.runtimeMinutes + 30 " +
            "     ELSE m.runtimeMinutes + 45 " +
            "END")
    void updateRuntimeMinutes();
}
