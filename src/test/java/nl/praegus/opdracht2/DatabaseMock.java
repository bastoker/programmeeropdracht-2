package nl.praegus.opdracht2;

import nl.praegus.opdracht2.database.Database;
import nl.praegus.opdracht2.pojo.Auteur;
import nl.praegus.opdracht2.pojo.Blog;

import java.util.Arrays;
import java.util.List;

public class DatabaseMock implements Database {
    @Override
    public List<Blog> getAllBlogs() {
        Blog blog1 = new Blog("titel1", "bladibla! nog een paar woorden", new Auteur("Piet"));
        Blog blog2 = new Blog("titel2", "bladibla en nog meer!", new Auteur("Jan"));
        Blog blog3 = new Blog("titel3", "bladibla en nog meer! Nog een blog van Jan", new Auteur("Jan"));
        Blog blog4 = new Blog("titel4", "bladibla is ook belangrijk!", new Auteur("Klaas"));
        return Arrays.asList(blog1, blog2, blog3);
    }

    @Override
    public List<Auteur> getAllAuteurs() {
        return Arrays.asList(new Auteur("Piet"), new Auteur("Jan"), new Auteur("Klaas"), new Auteur("HeeftGeenBlogs"));
    }
}
