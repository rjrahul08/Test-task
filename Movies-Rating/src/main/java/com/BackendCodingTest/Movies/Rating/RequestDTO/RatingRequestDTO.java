package com.BackendCodingTest.Movies.Rating.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RatingRequestDTO {

    private String tconst;
    private float averageRating;

    private int numVotes;
}
