package com.user.userservice.external.services;

import com.user.userservice.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name ="RATINGSERVICE")
public interface RatingService {
    @GetMapping("/ratings/users/{userId}")
     List<Rating> getRating(@PathVariable("userId") String userId);

    @PostMapping("/ratings")
    public Rating createRating(Rating values);

    @PutMapping("/ratings/{ratingId}")
    public Rating updateRating(@PathVariable ("ratingId") String ratingId , Rating rating);

    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRating(@PathVariable String ratingId);


}
