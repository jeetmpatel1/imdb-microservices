    package com.imdb.ratingsdataservice.resources;


    import com.imdb.ratingsdataservice.models.Rating;
    import com.imdb.ratingsdataservice.models.UserRating;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import java.util.Arrays;
    import java.util.List;

    @RestController
    @RequestMapping("/ratings-data")
    public class RatingsResource {

        @GetMapping("/status")
        public String getStatus(){
            return "{\"status\":\"running\"}";
        }

        @GetMapping("/{movieId}")
        public Rating getRating(@PathVariable("movieId") String movieId){
            return new Rating(movieId,4);
        }

        @GetMapping("/users/{userId}")
        public UserRating getUserRating(@PathVariable("userId") String userId){
            List<Rating> ratings = Arrays.asList(
                    new Rating("1",4),
                    new Rating("2",3),
                    new Rating("3",5)
            );
            UserRating userRating = new UserRating();
            userRating.setUserRating(ratings);
            return userRating;
        }

    }
