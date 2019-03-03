package pl.edu.wszib.savingtheworld.dao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Przepis {

    @Id
            @GeneratedValue
    Long id;

    @Column(nullable = false)
    String tytul;

    @OneToMany(mappedBy = "przepis", fetch = FetchType.EAGER)
    List<Skaladniki> skaladniki;

    @ManyToOne
            @JoinColumn(name = "ksiazka_id")
    KsiazkaKucharska ksiazkaKucharska;

    public Przepis(String tytul, List<Skaladniki> skaladniki, KsiazkaKucharska ksiazkaKucharska) {
        this.tytul = tytul;
        this.skaladniki = skaladniki;
        this.ksiazkaKucharska = ksiazkaKucharska;
    }

    public Przepis(){

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

    public List<Skaladniki> getSkaladniki() {
        return skaladniki;
    }

    public void setSkaladniki(List<Skaladniki> skaladniki) {
        this.skaladniki = skaladniki;
    }

    public KsiazkaKucharska getKsiazkaKucharska() {
        return ksiazkaKucharska;
    }

    public void setKsiazkaKucharska(KsiazkaKucharska ksiazkaKucharska) {
        this.ksiazkaKucharska = ksiazkaKucharska;
    }
}
