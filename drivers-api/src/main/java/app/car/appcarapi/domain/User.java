package app.car.appcarapi.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    Long id;

    @Column(unique = true)
    String username;
    String password;

    Boolean enable;

    @ElementCollection
    List<String> roles;
}
