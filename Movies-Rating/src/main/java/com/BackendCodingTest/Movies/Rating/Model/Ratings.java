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
@Table(name="ratings")
public class Ratings {


    @Id
    private String tconst;

    private float averageRating;

    private int numVotes;
}
