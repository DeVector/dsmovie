package com.devector.dsmovie.services;

import com.devector.dsmovie.dto.MovieDTO;
import com.devector.dsmovie.entities.Movie;
import com.devector.dsmovie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pageable){
        Page<Movie> movies = repository.findAll(pageable);
        Page<MovieDTO>  page = movies.map(x -> new MovieDTO(x));
        return page;
    }

    public MovieDTO findById(Long id){
        Movie movie = repository.findById(id).get();
        MovieDTO movieDTO = new MovieDTO(movie);
        return movieDTO;
    }
}
