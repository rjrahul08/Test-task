package com.BackendCodingTest.Movies.Rating.Converter;

import com.BackendCodingTest.Movies.Rating.Model.Movies;
import com.BackendCodingTest.Movies.Rating.RequestDTO.MovieRequestDTO;
import com.BackendCodingTest.Movies.Rating.ResponseDTO.MovieResponseDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieConverter {
    public static Movies movieRequestDTOtoMovie(MovieRequestDTO movieRequestDTO){
        return Movies.builder()
                .tconst(movieRequestDTO.getTconst())
                .genre(movieRequestDTO.getGenre())
                .primaryTitle(movieRequestDTO.getPrimaryTitle())
                .runtimeMinutes(movieRequestDTO.getRuntimeMinutes())
                .titleType(movieRequestDTO.getTitleType())
                .build();
    }

    public static MovieResponseDTO moviesToMovieResponseDTO(Movies movies){
        return MovieResponseDTO.builder()
                .tconst(movies.getTconst())
                .primaryTitle(movies.getPrimaryTitle())
                .genre(movies.getGenre())
                .runtimeMinutes(movies.getRuntimeMinutes())
                .build();
    }
}
