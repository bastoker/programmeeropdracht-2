package nl.praegus.opdracht2.pojo;

import java.util.Objects;

public class Auteur {
    private String naam;

    public Auteur(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auteur otherAuteur = (Auteur) o;
        return naam.equals(otherAuteur.naam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam);
    }
}
