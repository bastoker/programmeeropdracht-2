package nl.praegus.opdracht2.database;

import nl.praegus.opdracht2.pojo.Auteur;
import nl.praegus.opdracht2.pojo.Blog;

import java.util.List;

/**
 * Interface van de database
 */
public interface Database {

    // Haal alle blogs op
    List<Blog> getAllBlogs();

    // Haal alle auteurs op
    List<Auteur> getAllAuteurs();
}
