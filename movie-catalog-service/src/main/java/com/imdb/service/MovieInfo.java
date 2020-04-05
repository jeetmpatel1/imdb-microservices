package com.imdb.service;

import com.imdb.models.CatalogItem;
import com.imdb.models.Movie;
import com.imdb.models.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfo {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
    public CatalogItem getCatalogItem(Rating rating) {
        Movie movie = restTemplate.getForObject("http://movie-info-service/movie-info/movie/" + rating.getMovieId(), Movie.class);
        return new CatalogItem(movie.getName(), "Test", rating.getRating());
    }

    CatalogItem getFallbackCatalogItem(Rating rating) {
        return new CatalogItem("Movie Name Not Found", "", rating.getRating());
    }

}
