package org.solution.projet.services;

import org.solution.projet.entities.Facture;
import org.solution.projet.entities.Specialite;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SpecialiteService {

    Specialite saveSpecialite(Specialite specialite);
    Specialite updateSpecialite(Specialite specialite);
    void deleteSpecialiteById(Long id);
    void deleteAllSpecialite();
    Specialite getSpecialiteById(Long id);
    List<Specialite> getAllSpecialite();
}
