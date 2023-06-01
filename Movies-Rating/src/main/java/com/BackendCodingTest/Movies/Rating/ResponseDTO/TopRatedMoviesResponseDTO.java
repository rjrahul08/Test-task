package com.BackendCodingTest.Movies.Rating.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TopRatedMoviesResponseDTO {
    private String tconst;
    private String primaryTitle;
    private String genre;
    private float averageRating;
}
