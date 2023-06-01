package com.BackendCodingTest.Movies.Rating.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="movies")
public class Movies {
    @Id
    private String tconst;


    private String titleType;

    private String primaryTitle;

    private int runtimeMinutes;

    private String genre;
}
