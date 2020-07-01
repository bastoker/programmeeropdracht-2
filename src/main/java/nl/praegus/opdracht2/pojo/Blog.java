package nl.praegus.opdracht2.pojo;

public class Blog {
    private  String titel;
    private String blogpost;
    private Auteur auteur;

    public Blog(String titel, String blogpost, Auteur auteur) {
        this.titel = titel;
        this.blogpost = blogpost;
        this.auteur = auteur;
    }

    public String getTitel() {
        return titel;
    }

    public String getBlogpost() {
        return blogpost;
    }

    public Auteur getAuteur() {
        return auteur;
    }
}
