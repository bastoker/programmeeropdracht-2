package nl.praegus.opdracht2;

import nl.praegus.opdracht2.database.Database;
import nl.praegus.opdracht2.database.DatabaseImpl;
import nl.praegus.opdracht2.pojo.Auteur;
import nl.praegus.opdracht2.pojo.Blog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

/***
 *    ██████╗ ██████╗  █████╗ ███████╗ ██████╗ ██╗   ██╗███████╗     ██████╗ ██████╗ ██████╗ ██████╗  █████╗  ██████╗██╗  ██╗████████╗    ██████╗
 *    ██╔══██╗██╔══██╗██╔══██╗██╔════╝██╔════╝ ██║   ██║██╔════╝    ██╔═══██╗██╔══██╗██╔══██╗██╔══██╗██╔══██╗██╔════╝██║  ██║╚══██╔══╝    ╚════██╗
 *    ██████╔╝██████╔╝███████║█████╗  ██║  ███╗██║   ██║███████╗    ██║   ██║██████╔╝██║  ██║██████╔╝███████║██║     ███████║   ██║        █████╔╝
 *    ██╔═══╝ ██╔══██╗██╔══██║██╔══╝  ██║   ██║██║   ██║╚════██║    ██║   ██║██╔═══╝ ██║  ██║██╔══██╗██╔══██║██║     ██╔══██║   ██║       ██╔═══╝
 *    ██║     ██║  ██║██║  ██║███████╗╚██████╔╝╚██████╔╝███████║    ╚██████╔╝██║     ██████╔╝██║  ██║██║  ██║╚██████╗██║  ██║   ██║       ███████╗
 *    ╚═╝     ╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝ ╚═════╝  ╚═════╝ ╚══════╝     ╚═════╝ ╚═╝     ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝   ╚═╝       ╚══════╝
 */
public class MyApp {
    private static final String GREETING = "\n\n\nWelkom bij Praegus Opdracht 2!\n\n\n";

    private Database database;

    public static void main(String... args) {
        Database database = new DatabaseImpl();
        MyApp myApp = new MyApp(database);
        myApp.toonWelkom();
        myApp.toonBlogInfo();
        myApp.toonAantalWoordenPerAuteur();
    }

    public MyApp(Database database) {
        this.database = database;
    }

    public final void toonWelkom() {
        System.out.println(GREETING);
    }

    public final void toonBlogInfo() {
        System.out.println("BLOG INFO");
        System.out.println("---------");

        List<Blog> blogs = database.getAllBlogs();
        blogs.forEach((blog) -> {
            System.out.println(String.format("Blog \"%s\": geschreven door %s", blog.getTitel(), blog.getAuteur().getNaam()));
        });

        System.out.println("\n\n");
    }

    public void toonAantalWoordenPerAuteur() {
        System.out.println("BLOG STATISTIEKEN");
        System.out.println("-----------------");

        List<Auteur> allAuteurs = database.getAllAuteurs();
        List<Blog> allBlogs = database.getAllBlogs();

        // TODO: Bereken het totaal aantal woorden en toon deze aan de gebruiker:
        Map<Auteur, Integer> woordenPerAuteur = new HashMap<>();

        // Initialiseer de map met 0 voor elke auteur.
        // Dit voorkomt o.a. dat we auteurs die nog geen blogs geschreven hebben
        // niet genoemd worden in het overzicht:
        for (Auteur auteur: allAuteurs) {
            woordenPerAuteur.put(auteur, 0);
        }

        // Voor het aantal woorden kiezen we ervoor om spaties en newlines
        // als scheidingsteken te gebruiken.
        //
        // We gebruiken hier de default compute-functie van de Map-interface
        // voor een iets functionelere stijl om dit op te lossen:
        for (Blog b : allBlogs) {
            woordenPerAuteur.compute(
                    b.getAuteur(),
                    (a, c) -> c + b.getBlogpost().split("[ \n]").length);
        }
        allAuteurs.forEach(
                a -> System.out.println(format("Auteur %s heeft %s woorden geschreven", a.getNaam(), woordenPerAuteur.get(a)))
        );

        System.out.println("\n\n");


        System.out.println("\n\n");
    }
}
