package com.user.userservice.external.services;

import com.user.userservice.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name ="RATINGSERVICE")
public interface RatingService {
    @GetMapping("/ratings/users/{userId}")
     List<Rating> getRating(@PathVariable("userId") String userId);


}
