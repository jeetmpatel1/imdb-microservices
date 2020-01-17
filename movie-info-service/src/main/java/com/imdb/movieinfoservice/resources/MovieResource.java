package com.imdb.movieinfoservice.resources;

import com.imdb.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieResource {
    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId){
        int id;
        try{
            id = Integer.parseInt(movieId);
        }catch(NumberFormatException e){
            return new Movie("-1","Default Movie");
        }
        if(id == 1)
            return new Movie("1","Kevi Rite Jaish");
        if(id == 2)
            return new Movie("2","Bey yaar!");
        if(id == 3)
            return new Movie("3","Taare Zameen Par");
        return new Movie("-1","Default Movie");
    }
}
