package model;

public class Rating implements Comparable<Rating> {

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
        this.stars += rating;
        this.ratings++;
    }
    public int compareTo(Rating other) {
        return (int)(this.rating() - other.rating());
    }
}
