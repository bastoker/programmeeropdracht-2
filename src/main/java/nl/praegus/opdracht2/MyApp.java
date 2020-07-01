package nl.praegus.opdracht2;

import nl.praegus.opdracht2.database.Database;
import nl.praegus.opdracht2.database.DatabaseImpl;
import nl.praegus.opdracht2.pojo.Auteur;
import nl.praegus.opdracht2.pojo.Blog;

import java.util.List;

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



        System.out.println("\n\n");
    }
}
