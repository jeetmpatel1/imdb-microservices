    package com.imdb.resources;

    import com.imdb.models.CatalogItem;

    import java.util.Arrays;
    import java.util.List;

    import com.imdb.models.Movie;
    import com.imdb.models.Rating;
    import com.imdb.models.UserRating;
    import com.imdb.service.MovieInfo;
    import com.imdb.service.UserRatingInfo;
    import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.context.annotation.ComponentScan;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;
    import org.springframework.web.client.RestTemplate;

    import javax.annotation.Resource;
    import java.util.Collections;
    import java.util.stream.Collectors;

    @RestController
    @RequestMapping("/movie-catalog")
    public class MovieCatalogResource {
        @Autowired
        private RestTemplate restTemplate;

        @Autowired
        MovieInfo movieInfo;

        @Autowired
        UserRatingInfo userRatingInfo;

        @GetMapping("/status")
        public String getStatus() {
            return "{\"status\":\"running\"}";
        }

        @GetMapping("/users/{userId}")
        public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

            UserRating ratings = userRatingInfo.getUserRating(userId);

            return ratings.getRatings().stream().map(rating -> {
                return movieInfo.getCatalogItem(rating);

            }).collect(Collectors.toList());
        }

    }
