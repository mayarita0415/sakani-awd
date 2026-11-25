
package tn.esprit.microservice2.entities;

import jakarta.persistence.*;
import lombok.*;
import tn.esprit.microservice2.enums.StatutAnnonce;

import java.time.LocalDateTime;

@Entity
@Table(name = "annonces")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long logementId;

    @Column(nullable = false)
    private String proprietaireId;

    @Column(nullable = false)
    private String titre;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutAnnonce statut;

    private LocalDateTime dateCreation;

    private LocalDateTime datePublication;

    @PrePersist
    public void prePersist() {
        if (dateCreation == null) {
            dateCreation = LocalDateTime.now();
        }

        if (statut == null) {
            statut = StatutAnnonce.BROUILLON;
        }
    }
}
