package org.solution.projet.services;

import org.solution.projet.entities.Avocat;
import org.solution.projet.entities.Bureau;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface BureauService {
    Bureau saveBureau(Bureau  bureau);
    Bureau updateBureau(Bureau bureau);
    void deleteBureauById(Long id);
    void deleteAllBureau();
    Bureau getBureauById(Long id);
    List<Bureau> getAllBureau();
}
