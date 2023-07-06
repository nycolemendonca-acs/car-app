package app.car.appcarapi.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data // Anotação LOMBOK
@Entity // Reflete o estado do DB
@Schema(description = "Representa um motorista dentro da plataforma")
public class Driver {
    @Id // Chave primária ID
    @GeneratedValue
    Long id;

    @Schema(description = "Nome do motorista")
    String name;

    @Schema(description = "Data de nascimento do motorista")
    LocalDate birthDate;
}
