package org.solution.projet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.solution.projet.enums.RendezVousStatus;

import java.util.Date;

@Entity
@Data //getter + setter (lombok)
@AllArgsConstructor
@NoArgsConstructor
@Builder //enregistre dans la BD depuis le code - BD no vierge

public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date date;
    private Date heure;
    private String durée;
    private RendezVousStatus status= RendezVousStatus.nouveau;

    @ManyToOne
    private Client client;
    @ManyToOne
    private Avocat avocat;
    @OneToOne
    @JoinColumn(name = "facture_id", referencedColumnName = "id")
    private Facture facture;
}
