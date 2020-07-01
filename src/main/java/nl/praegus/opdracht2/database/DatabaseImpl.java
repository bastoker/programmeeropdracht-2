package nl.praegus.opdracht2.database;

import nl.praegus.opdracht2.pojo.Auteur;
import nl.praegus.opdracht2.pojo.Blog;

import java.util.Arrays;
import java.util.List;

// Dit is een stand-in van een echte database
public class DatabaseImpl implements Database {
    @Override
    public List<Blog> getAllBlogs() {
        Blog blog1 = new Blog("Hoe schrijf ik een unittest?", "Een unittest schrijven is eigenlijk echt heel eenvoudig. Zorg er eerst voor dat je JUnit op je classpath hebt staan, bijv. via maven. Daarna moet je de unittest schrijven en voila, je hebt j eerste unittest geschreven!", new Auteur("Bas"));
        Blog blog2 = new Blog("Hoe schrijf ik een goede acceptatietest", "Een acceptatietest test in principe de hele applicatie, en is dus een blackbox test. Volgens de testpyramide van Cohn is het belangrijk niet teveel te testen via een acceptatietest. Maar alleen de belangrijkste eigenschappen en integraties van componenten. Gebruik bijvoorbeeld een framework als FitNesse. Succes!!!", new Auteur("Bas"));
        Blog blog3 = new Blog("Wat is de testpyramide?", "De testpyramide, ook wel de pyramide van Cohn genaamd, is een voorbeeld van hoe je een gezonde testmix van een applicatie kan opbouwen. Onderin de Unittesten, in het midden de integratietesten of componenttesten, en bovenin de acceptatietesten of UI-testen.", new Auteur("Maarten-Jan"));
        return Arrays.asList(blog1, blog2, blog3);
    }

    @Override
    public List<Auteur> getAllAuteurs() {
        return Arrays.asList(new Auteur("Bas"), new Auteur("Maarten-Jan"), new Auteur("Melvin"));
    }
}
