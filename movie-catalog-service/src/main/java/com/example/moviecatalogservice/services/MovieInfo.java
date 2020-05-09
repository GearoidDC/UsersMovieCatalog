package com.example.moviecatalogservice.services;

import com.example.moviecatalogservice.models.CatalogItem;
import com.example.moviecatalogservice.models.Movie;
import com.example.moviecatalogservice.models.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfo {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
    public CatalogItem getCatalogItem(Rating rating) {
        Movie movie = restTemplate.getForObject( "http://movie-info-service/movies/" + rating.getMovieId(),Movie.class);
        return new CatalogItem(movie.getTitle(), movie.getSummary(), rating.getRating());
    }

    public CatalogItem getFallbackCatalogItem(Rating rating) {
        return new CatalogItem("Movie name not found", "", rating.getRating());

    }

}
