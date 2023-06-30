package app.car.appcarapi.interfaces.incoming.input;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class TravelRequestInput {
    @NotNull(message = "O campo passengerId não pode ser nulo")
    Long passengerId;

    @NotNull(message = "O campo origin não pode ser nulo")
    String origin;

    @NotNull(message = "O campo destination não pode ser nulo")
    String destination;
}
