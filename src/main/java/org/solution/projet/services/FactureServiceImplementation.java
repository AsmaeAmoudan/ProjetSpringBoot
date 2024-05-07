package org.solution.projet.services;

import org.solution.projet.entities.Facture;
import org.solution.projet.repositories.FactureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactureServiceImplementation implements FactureService{
    private FactureRepository factureRepository;
    @Override
    public Facture saveFacture(Facture facture) {
        return factureRepository.save(facture);
    }

    @Override
    public Facture updateFacture(Facture facture) {
        return factureRepository.save(facture);
    }

    @Override
    public void deleteFactureById(Long id) {
        factureRepository.deleteById(id);

    }

    @Override
    public void deleteAllFacture() {
        factureRepository.deleteAll();

    }

    @Override
    public Facture getFactureById(Long id) {
        return factureRepository.findById(id).get();
    }

    @Override
    public List<Facture> getAllFacture() {
        return factureRepository.findAll();
    }
}
