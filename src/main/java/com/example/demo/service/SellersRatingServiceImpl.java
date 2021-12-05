package com.example.demo.service;

import com.example.demo.UserRepository.SellersRatingRepository;
import com.example.demo.model.SellersRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SellersRatingServiceImpl implements SellersRatingService {

    @Autowired
    private SellersRatingRepository sellersRatingRepository;

    @Override
    public void save(SellersRating sellersRating) {
        sellersRatingRepository.save(sellersRating);
    }

    @Override
    public float getAverageRatingBySeller(long sellerId) {
        ArrayList<SellersRating> results = new ArrayList<SellersRating>();
        Iterable<SellersRating> sellersRatings = sellersRatingRepository.findAll();
        for (SellersRating sellersRating : sellersRatings) {
            if (sellersRating.getRatedUserId() == sellerId) {
                results.add(sellersRating);
            }
        }
        if (results.size() == 0) {
            return 0;
        }
        long total = 0;
        for (SellersRating s : results) {
            total += s.getRating();
        }
        float averageRating = (float)total / (float)results.size();
        return averageRating;
    }

}
