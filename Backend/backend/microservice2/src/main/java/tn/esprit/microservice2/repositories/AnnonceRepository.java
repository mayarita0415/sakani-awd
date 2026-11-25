
package tn.esprit.microservice2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.microservice2.entities.Annonce;
import tn.esprit.microservice2.enums.StatutAnnonce;

import java.util.List;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Long> {

    List<Annonce> findByStatut(StatutAnnonce statut);

    List<Annonce> findByProprietaireId(String proprietaireId);

    List<Annonce> findByLogementId(Long logementId);
}
