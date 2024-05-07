package org.solution.projet.services;

import org.solution.projet.entities.RendezVous;
import org.solution.projet.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendezVousServiceImplementation implements RendezVousService{
    private RendezVousRepository rendezVousRepository;
    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public RendezVous updateRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public void deleteRendezVousById(Long id) {
        rendezVousRepository.deleteById(id);

    }

    @Override
    public void deleteAllRendezVous() {
        rendezVousRepository.deleteAll();

    }

    @Override
    public RendezVous getRendezVousById(Long id) {
        return rendezVousRepository.findById(id).get();
    }

    @Override
    public List<RendezVous> getAllRendezVous() {
        return rendezVousRepository.findAll();
    }
}
