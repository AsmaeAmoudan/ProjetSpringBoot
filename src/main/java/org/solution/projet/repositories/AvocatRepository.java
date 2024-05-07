package org.solution.projet.repositories;

import org.solution.projet.entities.Avocat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvocatRepository extends JpaRepository<Avocat, Long> {
}
