package org.solution.projet.services;

import org.solution.projet.entities.Bureau;
import org.solution.projet.entities.Facture;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FactureService {
    Facture saveFacture(Facture facture);
    Facture updateFacture(Facture facture);
    void deleteFactureById(Long id);
    void deleteAllFacture();
    Facture getFactureById(Long id);
    List<Facture> getAllFacture();
}
