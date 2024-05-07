package org.solution.projet.services;

import org.solution.projet.entities.Facture;
import org.solution.projet.entities.RendezVous;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RendezVousService {

    RendezVous saveRendezVous(RendezVous rendezVous);
    RendezVous updateRendezVous(RendezVous rendezVous);
    void deleteRendezVousById(Long id);
    void deleteAllRendezVous();
    RendezVous getRendezVousById(Long id);
    List<RendezVous> getAllRendezVous();
}
