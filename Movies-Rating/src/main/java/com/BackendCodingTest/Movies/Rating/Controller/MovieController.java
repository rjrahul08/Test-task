package com.BackendCodingTest.Movies.Rating.Controller;

import com.BackendCodingTest.Movies.Rating.RequestDTO.MovieRequestDTO;
import com.BackendCodingTest.Movies.Rating.ResponseDTO.GenreMovieResponseDTO;
import com.BackendCodingTest.Movies.Rating.ResponseDTO.GenreMoviesWithSubtotalsDTO;
import com.BackendCodingTest.Movies.Rating.ResponseDTO.MovieResponseDTO;
import com.BackendCodingTest.Movies.Rating.ResponseDTO.TopRatedMoviesResponseDTO;
import com.BackendCodingTest.Movies.Rating.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/new-movie")
    public ResponseEntity addMovie(@RequestBody MovieRequestDTO movieRequestDTO){
        String response = "";
        try {
            response = movieService.addMovie(movieRequestDTO);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(response,HttpStatus.CREATED);
    }

    @GetMapping("/longest-duration-movies")
    public ResponseEntity longestDurationMovies(){
        List<MovieResponseDTO> movieResponseDTOS = new ArrayList<>();
        try {
            movieResponseDTOS = movieService.longestDurationMovies();
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(movieResponseDTOS,HttpStatus.ACCEPTED);
    }


    @GetMapping("/top-rated-movies")
    public ResponseEntity TopRatedMovies(@RequestParam(value = "minAverageRating", defaultValue = "6.0") float minAverageRating){
        List<TopRatedMoviesResponseDTO> topRatedMoviesResponseDTOS = new ArrayList<>();
        try {
            topRatedMoviesResponseDTOS = movieService.TopRatedMovies(minAverageRating);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(topRatedMoviesResponseDTOS,HttpStatus.ACCEPTED);
    }

    @GetMapping("/genre-movies-with-subtotals")
    public ResponseEntity genreMoviesWithSubtotals(){
        List<GenreMoviesWithSubtotalsDTO> genreMovieResponseDTOS = new ArrayList<>();
        try {
            genreMovieResponseDTOS = movieService.genreMoviesWithSubtotals();
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(genreMovieResponseDTOS,HttpStatus.ACCEPTED);
    }

    @PutMapping("/update-runtime-minutes")
    public ResponseEntity UpdateRuntimeMinutes(){
        try {
            movieService.UpdateRuntimeMinutes();
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("Successfully Updated",HttpStatus.ACCEPTED);
    }
}
