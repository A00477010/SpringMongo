package dev.Aditya.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController

//@GetiMapping or get is used to display information to the user.
//On other hand postmapping is uesd to read data from user.
//In restApi there are multiple layers and here the controller class is a part of it , it job is only to take response from user and return a response.
//The controller delegates this task to the Service class to get the data.

@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(),HttpStatus.OK);
    }
    @GetMapping("/new")
    public ResponseEntity<String> getAllNewMovies(){
        return  new ResponseEntity<String>("All new Movies with response entity", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>>getSingleMovie(@PathVariable ObjectId id){

        return new ResponseEntity<>(movieService.getMovieById(id),HttpStatus.OK);

    }
    @GetMapping("imdb/{imdbId}")
    public ResponseEntity<Optional<Movie>>getMovieByImdbId(@PathVariable String imdbId){
        return new ResponseEntity<>(movieService.findMovieByImdbId(imdbId),HttpStatus.OK);

    }



}
