package com.BackendCodingTest.Movies.Rating.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenreMoviesWithSubtotalsDTO {
    private String genre;
    private String primaryTitle;
    private int numVotes;
}
