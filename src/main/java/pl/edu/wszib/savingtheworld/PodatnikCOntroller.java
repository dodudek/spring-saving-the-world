package pl.edu.wszib.savingtheworld;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.savingtheworld.dao.Podatnik;
import pl.edu.wszib.savingtheworld.dao.PodatnikDAO;
import pl.edu.wszib.savingtheworld.dto.Podatnik.PodatnikDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping ("/podatnik")

public class PodatnikCOntroller {

    @Autowired
    PodatnikDAO dao;

    @Autowired
    Mapper mapper;


    @GetMapping("/znajdz")
    public PodatnikDTO podatnik (@RequestParam Long pesel){
        return dao.findById(pesel).map(podatnik -> mapper.map(podatnik, PodatnikDTO.class)).orElse(null);

    }

    @GetMapping("/wszyscy")
    public List<PodatnikDTO> podatnicy(){
        return StreamSupport.stream(dao.findAll().spliterator(), false)
                .map(podatnik -> mapper.map(podatnik, PodatnikDTO.class)).collect(Collectors.toList());

    }

    @PostMapping ("/zapisz")
    public PodatnikDTO zapisz ( PodatnikDTO podatnik){
       return mapper.map(dao.save(mapper.map(podatnik, Podatnik.class)), PodatnikDTO.class);
    }

    @DeleteMapping ("/usun")
    public PodatnikDTO usun (Long pesel){
        Podatnik podatnik = dao.findById(pesel).orElse(null);
        dao.deleteById(pesel);
        return mapper.map(podatnik, PodatnikDTO.class);

    }


}
