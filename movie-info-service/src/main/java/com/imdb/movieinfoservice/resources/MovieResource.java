            package com.imdb.movieinfoservice.resources;

            import com.imdb.movieinfoservice.models.Movie;
            import com.imdb.movieinfoservice.models.MovieSummary;
            import org.springframework.beans.factory.annotation.Autowired;
            import org.springframework.beans.factory.annotation.Value;
            import org.springframework.web.bind.annotation.GetMapping;
            import org.springframework.web.bind.annotation.PathVariable;
            import org.springframework.web.bind.annotation.RequestMapping;
            import org.springframework.web.bind.annotation.RestController;
            import org.springframework.web.client.RestTemplate;

            @RestController
            @RequestMapping("/movie-info")
            public class MovieResource {

                @Value("${api.key}")
                private String apiKey;

                @Autowired
                private RestTemplate restTemplate;

                @GetMapping("/status")
                public String getStatus() {
                    return "{\"status\":\"running\"}";
                }


                @GetMapping("/movie/{movieId}")
                public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
                    System.out.println("Came here with : "  + movieId);
                    //MovieSummary movieSummary = restTemplate.getForObject(
                    //      "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey,
                    //       MovieSummary.class);
                    MovieSummary movieSummary = restTemplate.getForObject(
                            "http://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey,
                            MovieSummary.class);

                   return new Movie(movieId,movieSummary.getTitle(),movieSummary.getOverview());
                }
            }
