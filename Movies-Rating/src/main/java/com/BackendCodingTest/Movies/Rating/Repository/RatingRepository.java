package com.BackendCodingTest.Movies.Rating.Repository;

import com.BackendCodingTest.Movies.Rating.Model.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Ratings,Integer> {
}
