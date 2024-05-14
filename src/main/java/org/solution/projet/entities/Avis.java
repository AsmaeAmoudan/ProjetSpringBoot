package org.solution.projet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data //getter + setter (lombok)
@AllArgsConstructor
@NoArgsConstructor
@Builder //enregistre dans la BD depuis le code - BD no vierge

public class Avis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String note;
    private String commentaire;

    @OneToMany(mappedBy="avis", fetch=FetchType.LAZY)
    private List<Client> clients = new ArrayList<>();

    // Remove @mappedBy and define owning side
    @OneToOne
    @JoinColumn(name = "rendez_vous_id", referencedColumnName = "id") // Adjust column name if needed
    private RendezVous rendezVous ;

}
