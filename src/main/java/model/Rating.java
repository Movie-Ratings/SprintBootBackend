package model;

import java.io.Serializable;

public class Rating implements Comparable<Rating>, Serializable {

    /**
     * The number of total 'stars' that this rating has accumulated. Each user supplies a rating in the range of [0,5].
     */
    private double stars;

    /**
     * The total number of ratings given so far. Each rating increments this value by one.
     */
    private double ratings;

    public double rating() {
        return (this.stars/this.ratings);
    }

    public void rate(int rating) {
        if(rating >= 0 && rating <= 5) {
            this.stars += rating;
            this.ratings++;
        }
        else {
            throw new IllegalArgumentException("Rating must be between [0,5], inclusive, but the given rating is '" + rating + "'.");
        }
    }
    public int compareTo(Rating other) {
        return (int)(this.rating() - other.rating());
    }
}
