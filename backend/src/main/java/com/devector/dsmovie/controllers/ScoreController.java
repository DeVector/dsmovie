package com.devector.dsmovie.controllers;

import com.devector.dsmovie.dto.MovieDTO;
import com.devector.dsmovie.dto.ScoreDTO;
import com.devector.dsmovie.services.MovieService;
import com.devector.dsmovie.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

    @Autowired
    private ScoreService service;

    @PutMapping
    public MovieDTO saveScore(@RequestBody ScoreDTO dto){
        MovieDTO movieDTO = service.saveScore(dto);
        return movieDTO;
    }

}
