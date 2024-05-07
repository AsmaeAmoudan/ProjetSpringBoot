package org.solution.projet.services;

import org.solution.projet.entities.Bureau;
import org.solution.projet.repositories.BureauRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BureauServiceImplementation implements BureauService{
    private BureauRepository bureauRepository;

    @Override
    public Bureau saveBureau(Bureau bureau) {
        return bureauRepository.save(bureau);
    }

    @Override
    public Bureau updateBureau(Bureau bureau) {
        return bureauRepository.save(bureau);
    }

    @Override
    public void deleteBureauById(Long id) {
        bureauRepository.deleteById(id);

    }

    @Override
    public void deleteAllBureau() {
        bureauRepository.deleteAll();

    }

    @Override
    public Bureau getBureauById(Long id) {
        return bureauRepository.findById(id).get();
    }

    @Override
    public List<Bureau> getAllBureau() {
        return bureauRepository.findAll();
    }
}
