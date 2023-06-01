package com.BackendCodingTest.Movies.Rating.Converter;

import com.BackendCodingTest.Movies.Rating.Model.Movies;
import com.BackendCodingTest.Movies.Rating.Model.Ratings;
import com.BackendCodingTest.Movies.Rating.ResponseDTO.GenreMovieResponseDTO;
import com.BackendCodingTest.Movies.Rating.ResponseDTO.TopRatedMoviesResponseDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieRatingConverter {
    public static TopRatedMoviesResponseDTO ratingMoviesToRatingResponseDTO(Ratings ratings, Movies movies){
        return TopRatedMoviesResponseDTO.builder()
                .averageRating(ratings.getAverageRating())
                .genre(movies.getGenre())
                .primaryTitle(movies.getPrimaryTitle())
                .tconst(movies.getTconst())
                .build();
    }

    public static GenreMovieResponseDTO ratingMoviesToGenreMovieResponseDTO(Ratings ratings,Movies movies){
        return GenreMovieResponseDTO.builder()
                .genre(movies.getGenre())
                .numVotes(ratings.getNumVotes())
                .primaryTitle(movies.getPrimaryTitle())
                .build();
    }
}
