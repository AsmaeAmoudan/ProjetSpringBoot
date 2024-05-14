package org.solution.projet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.solution.projet.security.entities.User;

import java.util.ArrayList;
import java.util.List;

@Entity
//@DiscriminatorValue("AVOCAT")
@Data //getter + setter (lombok)
@AllArgsConstructor
@NoArgsConstructor
@Builder //enregistre dans la BD depuis le code - BD no vierge
public class Avocat /*extends User*/ {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)  //assure que les usernames sont uniques
    private String nom;
    private String email;
    private String password;
    private String telephone;
    private String adresse;
    private String expérience;
    private String horaire_de_travail;

    @ManyToMany
    @JoinTable(name = "AVOCATS_SPECIALITES", // Join table name
            joinColumns = @JoinColumn(name = "AVOCAT_ID"), // Foreign key for Avocat
            inverseJoinColumns = @JoinColumn(name = "SPECIALITE_ID")) // Foreign key for Specialite
    private List<Specialite> specialites = new ArrayList<>();
    @ManyToOne
    private Bureau bureau;
    @ManyToOne
    private RendezVous rendezVous;


}
