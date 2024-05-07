package org.solution.projet.services;

import org.solution.projet.entities.Avis;
import org.solution.projet.repositories.AvisRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvisServiceImplementation implements AvisService{

    private AvisRepository avisRepository;
    @Override
    public Avis saveAvis(Avis avis) {
        return avisRepository.save(avis);
    }

    @Override
    public Avis updateAvis(Avis avis) {
        return avisRepository.save(avis);
    }

    @Override
    public void deleteAvisById(Long id) {
        avisRepository.deleteById(id);

    }

    @Override
    public void deleteAllAvis() {
        avisRepository.deleteAll();

    }

    @Override
    public Avis getAvisById(Long id) {
        return avisRepository.findById(id).get();
    }

    @Override
    public List<Avis> getAllAvis() {
        return avisRepository.findAll();
    }
}
