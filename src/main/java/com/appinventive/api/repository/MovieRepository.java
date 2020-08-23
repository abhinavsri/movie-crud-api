package com.appinventive.api.repository;

import com.appinventive.api.domain.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long>
{
    Page<Movie> findByUserId(Long userId, Pageable pageable);
    Boolean existsByUserId(Long userId);
    Optional<Movie> findByIdAndUserId(Long id, Long postId);
}
