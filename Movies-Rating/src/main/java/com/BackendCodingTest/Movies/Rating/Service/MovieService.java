package com.BackendCodingTest.Movies.Rating.Service;

import com.BackendCodingTest.Movies.Rating.RequestDTO.MovieRequestDTO;
import com.BackendCodingTest.Movies.Rating.ResponseDTO.GenreMovieResponseDTO;
import com.BackendCodingTest.Movies.Rating.ResponseDTO.GenreMoviesWithSubtotalsDTO;
import com.BackendCodingTest.Movies.Rating.ResponseDTO.MovieResponseDTO;
import com.BackendCodingTest.Movies.Rating.ResponseDTO.TopRatedMoviesResponseDTO;

import java.util.List;

public interface MovieService {
    String addMovie(MovieRequestDTO movieRequestDTO) throws Exception;

    List<MovieResponseDTO> longestDurationMovies();

    List<TopRatedMoviesResponseDTO> TopRatedMovies(float minAverageRating);

    void UpdateRuntimeMinutes();

    List<GenreMoviesWithSubtotalsDTO> genreMoviesWithSubtotals();
}
