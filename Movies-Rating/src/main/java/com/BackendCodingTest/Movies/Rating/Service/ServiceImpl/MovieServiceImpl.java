package com.BackendCodingTest.Movies.Rating.Service.ServiceImpl;

import com.BackendCodingTest.Movies.Rating.Converter.MovieConverter;
import com.BackendCodingTest.Movies.Rating.Model.Movies;
import com.BackendCodingTest.Movies.Rating.Model.Ratings;
import com.BackendCodingTest.Movies.Rating.Repository.MovieRepository;
import com.BackendCodingTest.Movies.Rating.Repository.RatingRepository;
import com.BackendCodingTest.Movies.Rating.RequestDTO.MovieRequestDTO;
import com.BackendCodingTest.Movies.Rating.ResponseDTO.GenreMovieResponseDTO;
import com.BackendCodingTest.Movies.Rating.ResponseDTO.GenreMoviesWithSubtotalsDTO;
import com.BackendCodingTest.Movies.Rating.ResponseDTO.MovieResponseDTO;
import com.BackendCodingTest.Movies.Rating.ResponseDTO.TopRatedMoviesResponseDTO;
import com.BackendCodingTest.Movies.Rating.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    RatingRepository ratingRepository;

    @Override
    public String addMovie(MovieRequestDTO movieRequestDTO) throws Exception {
        Movies movies;
        try {
            movies = MovieConverter.movieRequestDTOtoMovie(movieRequestDTO);
        }catch (Exception e){
            throw new Exception("Movie not found");
        }
        movieRepository.save(movies);
        return "success";
    }
    @Override
    public List<MovieResponseDTO> longestDurationMovies(){
        List<Movies> movies = movieRepository.findAll();
        movies.sort((m1, m2) -> m2.getRuntimeMinutes() - m1.getRuntimeMinutes());
        List<Movies> topMovies = movies.subList(0, Math.min(10, movies.size()));
        List<MovieResponseDTO> movieResponseDTOS = new ArrayList<>();
        for(Movies movie : topMovies){
            MovieResponseDTO movieResponseDTO = MovieConverter.moviesToMovieResponseDTO(movie);
            movieResponseDTOS.add(movieResponseDTO);
        }
        return movieResponseDTOS;
    }

    @Override
    public List<TopRatedMoviesResponseDTO> TopRatedMovies(float minAverageRating){
        List<Movies> movies = movieRepository.findAll();
        return movies.stream()
                .filter(movie -> getAverageRating(movie.getTconst()) > minAverageRating)
                .map(this::createTopRatedMoviesResponseDTO)
                .sorted((m1, m2) -> Float.compare(m2.getAverageRating(), m1.getAverageRating()))
                .collect(Collectors.toList());
    }
    private float getAverageRating(String tconst) {
        Ratings rating = ratingRepository.findById(Integer.valueOf(tconst)).orElse(null);
        return rating != null ? rating.getAverageRating() : 0.0f;
    }

    private TopRatedMoviesResponseDTO createTopRatedMoviesResponseDTO(Movies movie) {
        return TopRatedMoviesResponseDTO.builder()
                .tconst(movie.getTconst())
                .primaryTitle(movie.getPrimaryTitle())
                .genre(movie.getGenre())
                .averageRating(getAverageRating(movie.getTconst()))
                .build();
    }

    @Override
    public void UpdateRuntimeMinutes(){
        movieRepository.updateRuntimeMinutes();
    }

    @Override
    public List<GenreMoviesWithSubtotalsDTO> genreMoviesWithSubtotals(){
        return movieRepository.getGenreMoviesWithSubtotals();
    }

}
