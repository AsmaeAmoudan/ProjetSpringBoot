package org.solution.projet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity //table creer dans BD
@Data //getter + setter (lombok)
@AllArgsConstructor
@NoArgsConstructor
@Builder //enregistre dans la BD depuis le code - BD no vierge

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)  //assure que les usernames sont uniques
    private String nom;
    private String email;
    private String password;
    private String telephone;
    private String adresse;
    private String date_de_naissance;
    private long numéro_de_sécurité;

    @OneToMany(mappedBy="client", fetch=FetchType.LAZY)
    private List<Facture> factures = new ArrayList<>();
    @OneToMany(mappedBy = "client")
    private List<RendezVous> rendezVous= new ArrayList<>();
    @OneToMany(mappedBy = "client")
    private List<Avis> avis= new ArrayList<>();
}
