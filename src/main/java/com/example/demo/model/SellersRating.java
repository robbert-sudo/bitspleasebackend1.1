package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table
public class SellersRating {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ratingId;

    @Column
    private long ratedUserId;

    @Column
    private long rating;

    public long getRatingId() {return ratingId;}
    public void setRatingId(long ratingId) {this.ratingId = ratingId;}
    public long getRatedUserId() {return ratedUserId;}
    public void setRatedUserId(long ratedUserId) {this.ratedUserId = ratedUserId;}
    public long getRating() {return rating;}
    public void setRating(long rating) {this.rating = rating;}
}
