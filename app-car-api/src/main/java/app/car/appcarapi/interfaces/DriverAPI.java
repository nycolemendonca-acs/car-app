package app.car.appcarapi.interfaces;

import app.car.appcarapi.domain.Driver;
import app.car.appcarapi.domain.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// A classe é um Serviço REST
@Service
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE) // API deve produzir dados em JSON
public class DriverAPI {

    // Inclusão da DriverRepository como um campo da DriverAPI
    @Autowired DriverRepository driverRepository;
    @GetMapping("/drivers")
    public List<Driver> listDrivers() {
        return driverRepository.findAll();
    }

    @GetMapping("/drivers/{id}")
    public Driver findDriver(@PathVariable("id") Long id) {
        return driverRepository.findById(id).get();
    }
}
