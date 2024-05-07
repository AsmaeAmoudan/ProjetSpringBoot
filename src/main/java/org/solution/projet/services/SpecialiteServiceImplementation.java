package org.solution.projet.services;

import org.solution.projet.entities.Specialite;
import org.solution.projet.repositories.SpecialiteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialiteServiceImplementation implements SpecialiteService{
    private SpecialiteRepository specialiteRepository;
    @Override
    public Specialite saveSpecialite(Specialite specialite) {
        return specialiteRepository.save(specialite);
    }

    @Override
    public Specialite updateSpecialite(Specialite specialite) {
        return specialiteRepository.save(specialite);
    }

    @Override
    public void deleteSpecialiteById(Long id) {
        specialiteRepository.deleteById(id);

    }

    @Override
    public void deleteAllSpecialite() {
        specialiteRepository.deleteAll();

    }

    @Override
    public Specialite getSpecialiteById(Long id) {
        return specialiteRepository.findById(id).get();
    }

    @Override
    public List<Specialite> getAllSpecialite() {
        return specialiteRepository.findAll();
    }
}
