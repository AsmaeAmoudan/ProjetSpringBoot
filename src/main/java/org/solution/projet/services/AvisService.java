package org.solution.projet.services;

import org.solution.projet.entities.Avis;
import org.solution.projet.entities.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AvisService {

    Avis saveAvis(Avis avis);
    Avis updateAvis(Avis avis);
    void deleteAvisById(Long id);
    void deleteAllAvis();
    Avis getAvisById(Long id);
    List<Avis> getAllAvis();
}
