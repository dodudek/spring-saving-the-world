package pl.edu.wszib.savingtheworld.dao;

import javax.persistence.*;

@Entity
@Table
public class Faktura {

    @Id
    @GeneratedValue
    Long fakturaId;
    double kwota;
    String tytul;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
            @JoinColumn(name = "podatnik_id", nullable = false)
    Podatnik podatnik;

    public Podatnik getPodatnik() {
        return podatnik;
    }

    public void setPodatnik(Podatnik podatnik) {
        this.podatnik = podatnik;
    }

    public Faktura(){

    }

    public Faktura(double kwota, String tytul) {
        this.kwota = kwota;
        this.tytul = tytul;
    }

    public Long getFakturaId() {
        return fakturaId;
    }

    public void setFakturaId(Long fakturaId) {
        this.fakturaId = fakturaId;
    }

    public double getKwota() {
        return kwota;
    }

    public void setKwota(double kwota) {
        this.kwota = kwota;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }
}
