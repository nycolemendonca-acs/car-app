package app.car.appcarapi.interfaces.incoming;

import app.car.appcarapi.domain.Passenger;
import app.car.appcarapi.domain.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@Service
@RestController
@RequestMapping(path = "passengers", produces = MediaType.APPLICATION_JSON_VALUE)
public class PassengerAPI {
    @Autowired
    PassengerRepository passengerRepository;

    @GetMapping()
    public List<Passenger> listPassengers() {
        return passengerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Passenger findPassenger(@PathVariable("id") Long id) {
        return passengerRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @RolesAllowed("ROLE_ADMIN")
    public Passenger createPassenger(@RequestBody Passenger passenger) {
m
        return passengerRepository.save(passenger);
    }

    @PutMapping("/{id}")
    public Passenger fullUpdatePassenger(
            @PathVariable("id") Long id,
            @RequestBody Passenger passenger) {

        Passenger p = findPassenger(id);
        p.setName(passenger.getName());
        return passengerRepository.save(p);
    }

    @PatchMapping("/{id}")
    public Passenger incrementalUpdatePassenger(
            @PathVariable("id") Long id,
            @RequestBody Passenger passenger) {

        Passenger foundPassenger = findPassenger(id);
        foundPassenger.setName(Optional
                        .ofNullable(passenger.getName())
                        .orElse(foundPassenger.getName()));

        return passengerRepository.save(foundPassenger);
    }

    @DeleteMapping("/{id}")
    public void deletePassemger(@PathVariable("id") Long id) {
        passengerRepository.delete(findPassenger(id));
    }
}
