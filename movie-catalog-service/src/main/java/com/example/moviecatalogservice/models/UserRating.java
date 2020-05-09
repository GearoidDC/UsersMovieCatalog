package com.example.moviecatalogservice.models;

import java.util.List;

public class UserRating {

    private String userId;

    private List<Rating> userRating;

    public List<Rating> getUserRating() {
        return userRating;
    }

    public void setUserRating(List<Rating> userRating) {
        this.userRating = userRating;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
