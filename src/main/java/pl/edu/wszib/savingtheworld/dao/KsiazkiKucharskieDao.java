package pl.edu.wszib.savingtheworld.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.savingtheworld.OurCrudReposytory;

import java.util.List;

@Repository
public interface KsiazkiKucharskieDao extends OurCrudReposytory <KsiazkaKucharska, Long> {


}
