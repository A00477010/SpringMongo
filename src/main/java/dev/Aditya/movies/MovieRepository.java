package dev.Aditya.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//The Repository tag is ued to maek the class as a data access object. This interface will be responsible to deal with data related operations.
//This comes under the DAO section
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
//    This MongoRepo comes with buit in methods to search wth id but it dosent come with a mehtod to search with some other parameter.
//    By just specfying findMovieByImdbId mongodb will understand that we are trying to get the document using the ImdbId.(Its that intelligent).
//    How is it able to retrive the data from the document -> It reads the parameter we passed in the argument and then compares it with the paramenter we have stored in the movie @Document file.From there it figures out that we are trying to retrive Document with a particular parameter.


    Optional<Movie> findMovieByImdbId(String imdbId);






}
