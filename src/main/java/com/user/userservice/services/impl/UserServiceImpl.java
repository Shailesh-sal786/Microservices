package com.user.userservice.services.impl;

import com.user.userservice.entities.Hotel;
import com.user.userservice.entities.Rating;
import com.user.userservice.entities.User;
import com.user.userservice.external.services.HotelService;
import com.user.userservice.external.services.RatingService;
import com.user.userservice.repositories.UserRepository;
import com.user.userservice.exceptions.ResourceNotFoundException;
import com.user.userservice.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RatingService ratingService;


   // private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);

        return userRepository.save(user);
    }


    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }


    @Override
    public User getUser(String userId) {
        User user= userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given id is not found on dserver "+userId));
       // fetch rating of above user using rating service
        //http://localhost:8083/ratings/users/1a04a9ca-7666-4426-aee2-16874dc2bc67
       // String url = "http://localhost:8083/ratings/users/"+userId;
        String url = "http://RATINGSERVICE/ratings/users/"+userId;

    //  ArrayList <Rating> ratings =  restTemplate.getForObject(url,ArrayList.class);

//        Rating[] ratings = restTemplate.getForObject(url, Rating[].class);

        List<Rating> ratingList = ratingService.getRating(userId);

      //  List<Rating> ratingList = Arrays.asList(ratings);

        log.info("{}",ratingList);
        log.info("printing fro log of sl4j");

        for(Rating rating: ratingList){
          //  Hotel hotel = getHotel(rating.getHotelId());
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
        }
        user.setRatings(ratingList);
        return user;
    }

    //Those which microservices are called from this microservice their data should be in this microservice in the form of class.

    public Hotel getHotel(String hotelId){
        //String Hotel_url = "http://localhost:8082/hotels/"+hotelId;
        String Hotel_url = "http://HOTELSERVICE/hotels/"+hotelId;
        Hotel hotel = restTemplate.getForObject(Hotel_url,Hotel.class);
        return hotel;

    }
}
