package org.solution.projet.services;

import org.solution.projet.entities.Avocat;
import org.solution.projet.repositories.AvocatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvocatServiceImplementation implements AvocatService {
    @Autowired
    private AvocatRepository avocatRepository;

    @Override
    public Avocat saveAvocat(Avocat avocat) {
        return avocatRepository.save(avocat);
    }

    @Override
    public Avocat updateAvocat(Avocat avocat) {
        return avocatRepository.save(avocat);
    }

    @Override
    public void deleteAvocatById(Long id) {
        avocatRepository.deleteById(id);

    }

    @Override
    public void deleteAllAvocat() {
        avocatRepository.deleteAll();

    }

    @Override
    public Avocat getAvocatById(Long id) {
        return avocatRepository.findById(id).get();
    }

    @Override
    public List<Avocat> getAllAvocat() {
        return avocatRepository.findAll();
    }
}
