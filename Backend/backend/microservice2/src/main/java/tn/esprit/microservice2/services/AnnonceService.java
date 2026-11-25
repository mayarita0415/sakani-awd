
package tn.esprit.microservice2.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.microservice2.dto.AnnonceRequest;
import tn.esprit.microservice2.entities.Annonce;
import tn.esprit.microservice2.enums.StatutAnnonce;
import tn.esprit.microservice2.repositories.AnnonceRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnonceService {

    private final AnnonceRepository annonceRepository;

    // CREATE
    public Annonce creerAnnonce(AnnonceRequest request) {

        Annonce annonce = new Annonce();

        annonce.setLogementId(request.getLogementId());
        annonce.setProprietaireId(request.getProprietaireId());
        annonce.setTitre(request.getTitre());
        annonce.setDescription(request.getDescription());
        annonce.setStatut(StatutAnnonce.BROUILLON);
        annonce.setDateCreation(LocalDateTime.now());

        return annonceRepository.save(annonce);
    }

    // READ ALL
    public List<Annonce> getAllAnnonces() {
        return annonceRepository.findAll();
    }

    // READ BY ID
    public Annonce getAnnonceById(Long id) {
        return annonceRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Annonce introuvable"
                ));
    }

    // UPDATE
    public Annonce modifierAnnonce(Long id, AnnonceRequest request) {

        Annonce annonce = getAnnonceById(id);

        annonce.setLogementId(request.getLogementId());
        annonce.setProprietaireId(request.getProprietaireId());
        annonce.setTitre(request.getTitre());
        annonce.setDescription(request.getDescription());

        return annonceRepository.save(annonce);
    }

    // DELETE
    public void supprimerAnnonce(Long id) {
        Annonce annonce = getAnnonceById(id);
        annonceRepository.delete(annonce);
    }

    // PUBLISH
    public Annonce publierAnnonce(Long id) {

        Annonce annonce = getAnnonceById(id);

        if (annonce.getStatut() != StatutAnnonce.BROUILLON) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Seule une annonce en brouillon peut etre publiee"
            );
        }

        annonce.setStatut(StatutAnnonce.PUBLIEE);
        annonce.setDatePublication(LocalDateTime.now());

        return annonceRepository.save(annonce);
    }

    // ARCHIVE
    public Annonce archiverAnnonce(Long id) {

        Annonce annonce = getAnnonceById(id);

        if (annonce.getStatut() != StatutAnnonce.PUBLIEE) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Seule une annonce publiee peut etre archivee"
            );
        }

        annonce.setStatut(StatutAnnonce.ARCHIVEE);

        return annonceRepository.save(annonce);
    }

    // FILTER BY STATUS
    public List<Annonce> getAnnoncesByStatut(StatutAnnonce statut) {
        return annonceRepository.findByStatut(statut);
    }

    // FILTER BY OWNER
    public List<Annonce> getAnnoncesByProprietaire(String proprietaireId) {
        return annonceRepository.findByProprietaireId(proprietaireId);
    }

    // FILTER BY HOUSING
    public List<Annonce> getAnnoncesByLogement(Long logementId) {
        return annonceRepository.findByLogementId(logementId);
    }
}
