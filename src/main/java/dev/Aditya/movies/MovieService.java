package dev.Aditya.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//This is the service class which is called by the controller to get the data.
//This is the class where most of the Business logic is written .
//The service class calls the movieRepository interface , since that interface extends mongodb interface , so using that we can retrive data from the mongodb.

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;


    public List<Movie> allMovies() {
        return movieRepository.findAll();


    }

    public Optional<Movie> getMovieById(ObjectId id) {
        return movieRepository.findById(id);

    }
    public Optional<Movie> findMovieByImdbId(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
