package com.example.nick.thacke.Movie.Ratings.model;

import java.io.Serializable;

public class Comment implements Comparable<Comment>, Serializable {

    /**
     * The user who made this specific comment.
     */
    private User user;

    /**
     * The rating that other users have given this comment.
     */
    private Rating rating;

    /**
     * The actual comment that the user made.
     */
    private String comment;

    public Comment(User user, String comment) {
        this.user = user;
        this.comment = comment;
    }

    public int compareTo(Comment other) {
        return (int) (this.rating.rating() - other.rating.rating());
    }

}
