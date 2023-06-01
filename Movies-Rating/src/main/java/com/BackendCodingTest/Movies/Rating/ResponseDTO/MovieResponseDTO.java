package com.BackendCodingTest.Movies.Rating.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieResponseDTO {
    private String tconst;
    private String primaryTitle;
    private int runtimeMinutes;
    private String genre;
}
