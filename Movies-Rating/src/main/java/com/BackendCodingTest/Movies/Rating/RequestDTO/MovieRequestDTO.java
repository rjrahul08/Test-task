package com.BackendCodingTest.Movies.Rating.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieRequestDTO {

    private String tconst;

    private String titleType;

    private String primaryTitle;

    private int runtimeMinutes;
    private String genre;

}
