package dev.Aditya.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    public ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTempelate;

    //    We use the mongoTempelate to update information in the database according to the imdbId

//    What exactly will happen? -> We will get data from user in form of json format with exactly 2 parameter in it ie. review and the imdbId, in the following method the data will be loaded in a map.
//    When Spring receives the request, it automatically converts the JSON data from the request body into a Map<String, String>, where keys and values are derived from the JSON properties.
    public Review createReview(String reviewBody, String imdbId) {
        Review reviews = reviewRepository.insert(new Review(reviewBody));
//        Review reviews = new Review(reviewBody);
//        reviewRepository.insert(reviews);
        mongoTempelate.update(Movie.class).matching(Criteria.where("imdbId").is(imdbId)).apply(new Update().push("reviewIds").value(reviews)).first();
        return reviews;
    }
}