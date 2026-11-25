
package tn.esprit.microservice2.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.microservice2.dto.AnnonceRequest;
import tn.esprit.microservice2.entities.Annonce;
import tn.esprit.microservice2.enums.StatutAnnonce;
import tn.esprit.microservice2.services.AnnonceService;

import java.util.List;

@RestController
@RequestMapping("/api/annonces")
@RequiredArgsConstructor
public class AnnonceController {

    private final AnnonceService annonceService;

    // CREATE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Annonce creerAnnonce(
            @Valid @RequestBody AnnonceRequest request) {
        return annonceService.creerAnnonce(request);
    }

    // READ ALL
    @GetMapping
    public List<Annonce> getAllAnnonces() {
        return annonceService.getAllAnnonces();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Annonce getAnnonceById(@PathVariable Long id) {
        return annonceService.getAnnonceById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Annonce modifierAnnonce(
            @PathVariable Long id,
            @Valid @RequestBody AnnonceRequest request) {
        return annonceService.modifierAnnonce(id, request);
    }

    // DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void supprimerAnnonce(@PathVariable Long id) {
        annonceService.supprimerAnnonce(id);
    }

    // PUBLISH
    @PatchMapping("/{id}/publier")
    public Annonce publierAnnonce(@PathVariable Long id) {
        return annonceService.publierAnnonce(id);
    }

    // ARCHIVE
    @PatchMapping("/{id}/archiver")
    public Annonce archiverAnnonce(@PathVariable Long id) {
        return annonceService.archiverAnnonce(id);
    }

    // FILTER BY STATUS
    @GetMapping("/statut/{statut}")
    public List<Annonce> getAnnoncesByStatut(
            @PathVariable StatutAnnonce statut) {
        return annonceService.getAnnoncesByStatut(statut);
    }

    // FILTER BY OWNER
    @GetMapping("/proprietaire/{proprietaireId}")
    public List<Annonce> getAnnoncesByProprietaire(
            @PathVariable String proprietaireId) {
        return annonceService.getAnnoncesByProprietaire(proprietaireId);
    }

    // FILTER BY HOUSING
    @GetMapping("/logement/{logementId}")
    public List<Annonce> getAnnoncesByLogement(
            @PathVariable Long logementId) {
        return annonceService.getAnnoncesByLogement(logementId);
    }
}
