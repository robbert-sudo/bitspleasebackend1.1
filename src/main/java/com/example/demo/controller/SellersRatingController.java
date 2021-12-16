package com.example.demo.controller;

import com.example.demo.model.SellersRating;
import com.example.demo.service.SellersRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "sellerratings")
public class SellersRatingController {

    private SellersRatingService sellersRatingService;

    @Autowired
    public SellersRatingController(SellersRatingService sellersRatingService) {
        this.sellersRatingService = sellersRatingService;
    }

    @PostMapping
    public ResponseEntity addSellerRating(@RequestBody SellersRating sellersRating) {
        sellersRatingService.save(sellersRating);
        return ResponseEntity.ok("bedankt voor uw stem.");
    }

    @GetMapping
    public ResponseEntity getAllRatings() {
        Iterable<SellersRating> sellersRatings = sellersRatingService.findAll();
        return ResponseEntity.ok(sellersRatings);
    }

    @GetMapping(value = "/${ratedUserId}")
    public ResponseEntity getAllRatingsFromUser(@PathVariable long ratedUserId) {
        Iterable<SellersRating> sellersRatings = sellersRatingService.findAllByRatedUserId(ratedUserId);
        return ResponseEntity.ok(sellersRatings);
    }

    @GetMapping(value = "/getaverage")
    public ResponseEntity getAverageSellerRating(@RequestBody long sellerId) {
        float averageSellerRating = sellersRatingService.getAverageRatingBySeller(sellerId);
        return ResponseEntity.ok(averageSellerRating);
    }


}
