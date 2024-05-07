package org.solution.projet.services;

import org.solution.projet.entities.Avocat;
import org.solution.projet.entities.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AvocatService {
    Avocat saveAvocat(Avocat avocat);
    Avocat updateAvocat(Avocat avocat);
    void deleteAvocatById(Long id);
    void deleteAllAvocat();
    Avocat getAvocatById(Long id);
    List<Avocat> getAllAvocat();


}
