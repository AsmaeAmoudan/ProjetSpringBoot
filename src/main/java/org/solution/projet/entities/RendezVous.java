package org.solution.projet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.solution.projet.enums.RendezVousStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    // One-to-One relationship with Client (owned by RendezVous)
    @OneToOne(cascade = CascadeType.ALL) // Cascade persist/update/delete to Client
    @JoinColumn(name = "client_id", referencedColumnName = "id") // Foreign key
    private Client client;

    // Many-to-Many relationship with Avocat (using a join table)
    @ManyToMany
    @JoinTable(name = "RENDEZVOUS_AVOCATS", // Join table name
            joinColumns = @JoinColumn(name = "RENDEZVOUS_ID"), // Foreign key for RendezVous
            inverseJoinColumns = @JoinColumn(name = "AVOCAT_ID")) // Foreign key for Avocat
    private List<Avocat> avocats = new ArrayList<>();

    // Add this line
    @OneToOne(mappedBy = "rendezVous")
    private Facture facture;
}
