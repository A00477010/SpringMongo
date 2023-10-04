package dev.Aditya.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    private ObjectId id;
    private String imdb;
    private String title;
    private String date;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backDrops;

    @DocumentReference
    private List<Reviews> reviewIds;




}
