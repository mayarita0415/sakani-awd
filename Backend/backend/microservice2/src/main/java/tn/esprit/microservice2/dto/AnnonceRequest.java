
package tn.esprit.microservice2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class AnnonceRequest {

    @NotNull
    @Positive
    private Long logementId;

    @NotBlank
    private String proprietaireId;

    @NotBlank
    private String titre;

    private String description;
}
