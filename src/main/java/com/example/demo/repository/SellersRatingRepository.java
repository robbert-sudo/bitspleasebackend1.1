package com.example.demo.repository;

import com.example.demo.model.SellersRating;
import org.springframework.data.repository.CrudRepository;

public interface SellersRatingRepository extends CrudRepository <SellersRating, Long> {

    Iterable<SellersRating> findAllByRatedUserId(long rated_user_id);

}
