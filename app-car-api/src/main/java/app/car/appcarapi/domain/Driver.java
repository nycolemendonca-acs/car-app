package app.car.appcarapi.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data // Anotação LOMBOK
@Entity // Reflete o estado do DB
public class Driver {
    @Id // Chave primária ID
    Long id;
    String name;
    LocalDate birthDate;
}
