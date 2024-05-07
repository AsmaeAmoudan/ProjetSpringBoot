package org.solution.projet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data //getter + setter (lombok)
@AllArgsConstructor
@NoArgsConstructor
@Builder //enregistre dans la BD depuis le code - BD no vierge

public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double montant;

    @ManyToOne
    private Client client;
    @OneToOne(mappedBy = "facture")
    private RendezVous rendezVous;


}
