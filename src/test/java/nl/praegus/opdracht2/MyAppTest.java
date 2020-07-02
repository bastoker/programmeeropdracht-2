package nl.praegus.opdracht2;

import nl.praegus.opdracht2.pojo.Auteur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyAppTest {
    private MyApp myApp;

    @BeforeEach
    public void init() {
        myApp = new MyApp(new DatabaseMock());
    }

    @Test
    public void aantalAuteursKomtOvereenMetDatabase() {
        Map<Auteur, Integer> result = myApp.berekenWoordenPerAuteur();
        assertEquals(4, result.size()); // De testdata bevat 4 auteurs
    }

    @Test
    public void aantalWoordenVoorAuteurHeeftGeenBlogsIs0() {
        int aantalWoordenVoorHeeftGeenBlogs = myApp.berekenWoordenPerAuteur().get(new Auteur("HeeftGeenBlogs"));
        assertEquals(0, aantalWoordenVoorHeeftGeenBlogs); // Als je geen blogs hebt geschreven is het aantal woorden 0
    }

    @Test
    public void PietHeeft5WoordenGeschreven() {
        int aantalWoordenVoorHeeftGeenBlogs = myApp.berekenWoordenPerAuteur().get(new Auteur("Piet"));
        assertEquals(5, aantalWoordenVoorHeeftGeenBlogs);
    }

    @Test
    public void woordenVanMeerdereBlogsWordenGoedOpgeteld() {
        int aantalWoordenVoorHeeftGeenBlogs = myApp.berekenWoordenPerAuteur().get(new Auteur("Jan"));
        assertEquals(13, aantalWoordenVoorHeeftGeenBlogs);
    }
}
