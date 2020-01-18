    package com.imdb.ratingsdataservice.resources;


    import com.imdb.ratingsdataservice.models.Rating;
    import com.imdb.ratingsdataservice.models.UserRating;
    import io.swagger.annotations.ApiOperation;
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
        @ApiOperation(value = "Find the over all average rating of movie",
        notes = "Provide the movie Id to get the average rating of all users for that particular movie",
        response=Rating.class)
        public Rating getRating(@PathVariable("movieId") String movieId){
            return new Rating(movieId,4);
        }

        @GetMapping("/users/{userId}")
        @ApiOperation(value = "Find the all the movies watched and rated by particular user.",
                notes = "Provide the user Id to get the Name and Rating of the movie by particular user",
                response=UserRating.class)
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
