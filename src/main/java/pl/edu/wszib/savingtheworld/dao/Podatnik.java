package pl.edu.wszib.savingtheworld.dao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table

public class Podatnik {

    @Id
            @GeneratedValue
    public Long pesel;

    @Column(nullable = false)
    public  String imie;
    @Column(nullable = false)
    public  String nazwisko;

    @OneToMany(targetEntity = Faktura.class, fetch = FetchType.EAGER, mappedBy = "FakturaId")
    List <Faktura> faktury;

    public Podatnik() {
    }

    public Podatnik( String imie, String nazwisko) {

        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public List<Faktura> getFaktura() {
        return faktury;
    }

    public void setFaktura(List<Faktura> faktura) {
        this.faktury = faktura;
    }

    public Long getPesel() {
        return pesel;
    }

    public void setPesel(Long pesel) {
        this.pesel = pesel;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
}
