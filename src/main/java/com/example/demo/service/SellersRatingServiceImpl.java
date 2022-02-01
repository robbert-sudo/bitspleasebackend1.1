package com.example.demo.service;

import com.example.demo.model.SellersRating;
import com.example.demo.repository.SellersRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellersRatingServiceImpl implements SellersRatingService {

    private SellersRatingRepository sellersRatingRepository;

    @Autowired
    private SellersRatingServiceImpl(SellersRatingRepository sellersRatingRepository) {
        this.sellersRatingRepository = sellersRatingRepository;
    }



    @Override
    public void save(SellersRating sellersRating) {
        sellersRatingRepository.save(sellersRating);
    }

    @Override
    public Iterable<SellersRating> findAll() {
        Iterable<SellersRating> sellersRatings = sellersRatingRepository.findAll();
        return sellersRatings;
    }


    @Override
    public Iterable<SellersRating> findAllByRatedUserId(long rated_user_id) {
        Iterable<SellersRating> sellersRatings = sellersRatingRepository.findAllByRatedUserId(rated_user_id);
        return sellersRatings;

    }

    @Override
    public float getAverageRatingBySeller(long rated_user_id) {

        float total = 0;
        float size = 0;

        Iterable<SellersRating> sellersRatings = sellersRatingRepository.findAllByRatedUserId(rated_user_id);
        for (SellersRating sellersRating : sellersRatings) {
            total += sellersRating.getRating();
            size += 1;
        }
        float averageRating = total / size;

        return averageRating;
    }
//        ArrayList<SellersRating> results = new ArrayList<SellersRating>();
//        Iterable<SellersRating> sellersRatings = sellersRatingRepository.findAll();
//        for (SellersRating sellersRating : sellersRatings) {
//            if (sellersRating.getRatedUserId() == sellerId) {
//                results.add(sellersRating);
//            }
//        }
//        if (results.size() == 0) {
//            return 0;
//        }
//        long total = 0;
//        for (SellersRating s : results) {
//            total += s.getRating();
//        }
//        float averageRating = (float) total / (float) results.size();
//        return averageRating;
//    }


}
