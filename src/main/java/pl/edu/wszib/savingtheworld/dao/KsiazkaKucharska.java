package pl.edu.wszib.savingtheworld.dao;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class KsiazkaKucharska {

    @Id
            @GeneratedValue
    Long id;
    @Column(nullable = false)
    String tytul;

    @OneToMany(mappedBy = "ksiazkaKucharska")
    List<Przepis> przepisy;

    public KsiazkaKucharska(){

    }

    public KsiazkaKucharska(String tytul, List<Przepis> przepisy) {
        this.tytul = tytul;
        this.przepisy = przepisy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public List<Przepis> getPrzepisy() {
        return przepisy;
    }

    public void setPrzepisy(List<Przepis> przepisy) {
        this.przepisy = przepisy;
    }
}
