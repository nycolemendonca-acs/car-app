package app.car.appcarapi.interfaces.incoming.output;

import app.car.appcarapi.domain.Passenger;
import app.car.appcarapi.domain.TravelRequestStatus;
import lombok.Data;

import java.util.Date;

@Data
public class TravelRequestOutput {
    Long id;
    Passenger passenger;
    String origin;
    String destination;
    TravelRequestStatus status;
    Date creationDate;
}
