package pl.edu.wszib.savingtheworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wszib.savingtheworld.dao.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;

@Component
public class InitKsiazka {

    @Autowired
    KsiazkiKucharskieDao ksiazkiKucharskieDao;

    @Autowired
    PrzepisyDao przepisyDao;

    @Autowired
    SkladnikiDao skladnikiDao;

    @Autowired
    TypSkladnikaDao typSkladnikaDao;


    @PostConstruct

    public void init(){

        for (int i =0; i<10; i++){
            TypSkladnika typSkladnika = new TypSkladnika();
            typSkladnika.setNazwa("skladnik" + i);
            typSkladnikaDao.save(typSkladnika);
        }

        KsiazkaKucharska ksiazkaKucharska = new KsiazkaKucharska();
        ksiazkaKucharska.setTytul("Moja książka");
        ksiazkiKucharskieDao.save(ksiazkaKucharska);

        Przepis przepis = new Przepis();
        przepis.setKsiazkaKucharska(ksiazkaKucharska);
        przepis.setTytul("Przepis 1");
        przepis = przepisyDao.save(przepis);

        List<TypSkladnika> typSkladnikas = typSkladnikaDao.findAll();
        for (TypSkladnika typ: typSkladnikas) {
            Skaladniki skaladniki = new Skaladniki();
            skaladniki.setIlosc(new Random().nextInt(5)+1);
            skaladniki.setTypSkladnika(typ);
            skaladniki.setPrzepis(przepis);
            skladnikiDao.save(skaladniki);

        }

        System.out.printf("");
    }


}
