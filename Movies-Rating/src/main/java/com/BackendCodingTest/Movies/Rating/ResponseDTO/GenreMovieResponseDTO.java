package com.BackendCodingTest.Movies.Rating.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenreMovieResponseDTO {
    private String genre;
    private String primaryTitle;
    private int numVotes;
}
