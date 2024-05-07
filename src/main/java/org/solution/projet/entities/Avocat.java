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
public class Avocat {

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

    @ManyToOne
    private Specialite specialite;
    @ManyToOne
    private Bureau bureau;
    @OneToMany(mappedBy = "avocat", fetch = FetchType.LAZY)
    private List<RendezVous> rendezVous=new ArrayList<>();
    @OneToMany(mappedBy = "avocat", fetch = FetchType.LAZY)
    private List<Avis> avis=new ArrayList<>();

}
