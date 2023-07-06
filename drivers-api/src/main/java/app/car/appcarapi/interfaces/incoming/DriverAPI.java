//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package app.car.appcarapi.interfaces.incoming;

import app.car.appcarapi.domain.Driver;
import app.car.appcarapi.domain.DriverRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import app.car.appcarapi.interfaces.incoming.errorhandling.ErrorResponse;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.v3.oas.annotations.*;

@Service
@RestController
@RequestMapping(
    produces = {"application/json"}
)
@Tag(name = "Driver API", description = "Manipula dados de motoristas.")
public interface DriverAPI {

    @Operation(description = "Lista todos os motoristas disponíveis")
    public List<Driver> listDrivers();

    @Operation(
            description = "Localiza um motorista específico",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Caso o motorista tenha sido encontrado na base"),
                    @ApiResponse(responseCode = "404",
                        description = "Caso o motorista não tenha sido encontrado",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
                    )
            }
    )

    Driver findDriver(
            @Parameter(description = "ID do motorista a ser localizado") Long id);

    Driver createDriver(
            @Parameter(description = "Dados do motorista a ser criado") Driver driver);

    Driver fullUpdateDriver(Long id, Driver driver);

    Driver incrementalUpdateDriver(Long id, Driver driver);

    void deleteDriver(Long id);

//    @GetMapping({"/drivers/{id}"})
//    @Operation(
//            description = "Localiza um motorista específico"
//            responses = {
//                    @ApiResponse(responseCode = "200", description = "Caso o motorista tenha sido encontrado na base"),
//                    @ApiResponse(responseCode = "404", description = "Caso o motorista não tenha sido encontrado",
//                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
//            }
//    )
//    public Driver findDriver(
//            @Parameter(description = "ID do motorista a ser localizado")
//            @PathVariable("id") Long id) {
//        return driverRepository.findById(id).orElseThrow(() -> {
//            new ResponseStatusException(HttpStatus.NOT_FOUND));
//    }
//
//    @PostMapping({"/drivers"})
//    public Driver createDriver(@RequestBody Driver driver) {
//        return (Driver)this.driverRepository.save(driver);
//    }
//
//    @PutMapping({"/drivers/{id}"})
//    public Driver fullUpdateDriver(@PathVariable("id") Long id, @RequestBody Driver driver) {
//        Driver foundDriver = this.findDriver(id);
//        foundDriver.setName(driver.getName());
//        foundDriver.setBirthDate(driver.getBirthDate());
//        return (Driver)this.driverRepository.save(foundDriver);
//    }
//
//    @PatchMapping({"/drivers/{id}"})
//    public Driver incrementalUpdateDriver(@PathVariable("id") Long id, @RequestBody Driver driver) {
//        Driver foundDriver = this.findDriver(id);
//        foundDriver.setName((String)Optional.ofNullable(driver.getName()).orElse(foundDriver.getName()));
//        foundDriver.setBirthDate((LocalDate)Optional.ofNullable(driver.getBirthDate()).orElse(foundDriver.getBirthDate()));
//        return (Driver)this.driverRepository.save(foundDriver);
//    }
//
//    @DeleteMapping({"/drivers/{id}"})
//    public void deleteDriver(@PathVariable("id") Long id) {
//        this.driverRepository.delete(this.findDriver(id));
//    }
}
