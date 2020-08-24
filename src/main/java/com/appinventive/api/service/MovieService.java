package com.appinventive.api.service;

import com.appinventive.api.domain.Movie;
import com.appinventive.api.domain.User;
import com.appinventive.api.exception.MovieNotFoundException;
import com.appinventive.api.exception.UserNotFoundException;
import com.appinventive.api.repository.MovieRepository;
import com.appinventive.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserService userService;

    public Page<Movie> findByUserId(Long userId, Pageable pageable) {
        return movieRepository.findByUserId(userId, pageable);
    }

    public Optional<Movie> findByIdAndUserId(Long movieId, Long userId) {
        return movieRepository.findByIdAndUserId(movieId, userId);
    }

    public Movie save(Movie movie, Long userId) {
        userService.findById(userId).map(user ->{
            movie.setUser(user);
            return user;
        }).orElseThrow(() -> new UserNotFoundException("User with id " + userId + " not found"));
        return (Movie) movieRepository.save(movie);
    }
    public void delete(Long userId, Long movieId) throws MovieNotFoundException {
        Optional<Movie> optionalMovie = movieRepository.findByIdAndUserId(movieId, userId);
        if(optionalMovie.isPresent()){
            movieRepository.delete(optionalMovie.get());
        }else{
            throw  new MovieNotFoundException("Movie with id " + movieId + " not found for user with id"+userId);
        }
    }


    public Movie update(Movie movie, Long movieId, Long userId) {
        Optional<Movie> optionalMovie = movieRepository.findByIdAndUserId(movieId, userId);
        Movie existingMovie = null;
        if(optionalMovie.isPresent()){
            existingMovie =optionalMovie.get();
            existingMovie.setRating(movie.getRating());
            existingMovie.setTitle(movie.getTitle());
            existingMovie.setRating(movie.getRating());
        }else{
          throw new MovieNotFoundException("Movie with id " + movieId + " not found for user with id"+userId);
        }
        return existingMovie;
    }
}
