package com.example.netex.controller;

import com.example.netex.dto.MovieDto;
import com.example.netex.model.Movie;
import com.example.netex.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class MovieController {

    private MovieService movieService;

    @GetMapping("/")
    public List<Movie> getTest() {
        return movieService.findAll();
    }

    @PostMapping("/movie")
    public Movie createMovie(@RequestBody MovieDto movie) {
        Map<String, Object> qParams = new HashMap<>();
        qParams.put("t", movie.getTitle());
        return movieService.save(qParams);
    }
}
