package com.example.moviecatalogservice.resources;


import com.example.moviecatalogservice.models.CatalogItem;
import com.example.moviecatalogservice.models.Rating;
import com.example.moviecatalogservice.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResources {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        List<Rating> ratings = Arrays.asList(
                new Rating( "1234", 4),
                new Rating("5678" , 3)

        );

        return ratings.stream().map(rating -> {
            Movie movie = restTemplate.getForObject( "http://localhost:8082/movies/" + rating.getMovieId(),Movie.class);
            return new CatalogItem(movie.getName(), "Desc", rating.getRating());

        })
                .collect(Collectors.toList());

        // Get all rated movie IDs

        // For each movie ID, call movie info service and get details

        // Put them all together


    }
}
