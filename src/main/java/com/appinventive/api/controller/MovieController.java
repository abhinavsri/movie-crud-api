package com.appinventive.api.controller;
import com.appinventive.api.domain.Movie;
import com.appinventive.api.domain.User;
import com.appinventive.api.exception.MovieNotFoundException;
import com.appinventive.api.exception.UserNotFoundException;
import com.appinventive.api.service.MovieService;
import com.appinventive.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.stream.events.Comment;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private UserService userService;


    @GetMapping("/users/{userId}/movies")
    public Page<Movie> getAllMoviesByUserId(@PathVariable(value = "userId") Long userId,
                                            Pageable pageable) {
        return movieService.findByUserId(userId, pageable);
    }

    @PostMapping("/users/{userId}/movies")
    public Movie createMovie(@PathVariable (value = "userId") Long userId,
                                 @Valid @RequestBody Movie movie) throws UserNotFoundException {

        return  movieService.save(movie, userId);

    }

    @PutMapping("/users/{userId}/movies/{movieId}")
    public Movie update(@PathVariable (value = "userId") Long userId,
                        @PathVariable (value = "movieId") Long movieId,
                                 @Valid @RequestBody Movie movie) throws MovieNotFoundException {

        return  movieService.update(movie, movieId, userId);

    }
    @DeleteMapping("/users/{userId}/movies/{movieId}")
    public ResponseEntity<?> deletePost(@PathVariable (value = "userId") Long userId,
                                        @PathVariable (value = "movieId") Long movieId) {
        return ResponseEntity.ok().build();
    }


}
