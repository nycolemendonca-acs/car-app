package app.car.appcarapi.interfaces.incoming;

import app.car.appcarapi.domain.TravelRequest;
import app.car.appcarapi.domain.TravelService;
import app.car.appcarapi.interfaces.incoming.input.TravelRequestInput;
import app.car.appcarapi.interfaces.incoming.mapping.TravelRequestMapper;
import app.car.appcarapi.interfaces.incoming.output.TravelRequestOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequestMapping(path = "/travelRequests", produces = MediaType.APPLICATION_JSON_VALUE)
public class TravelRequestAPI {

    @Autowired
    TravelService travelService;

    @Autowired
    TravelRequestMapper mapper;

    @PostMapping
    public EntityModel<TravelRequestOutput> makeTravelRequest(@RequestBody @Validated TravelRequestInput travelRequestInput) {
        TravelRequest request = travelService.saveTravelRequest(mapper.map(travelRequestInput));
        TravelRequestOutput output = mapper.map(request);
        return mapper.buildOutputModel(request, output);
    }

    @GetMapping("/nearby")
    public List<EntityModel<TravelRequestOutput>> listNearbyRequests(
            @RequestParam String currentAddress) {

        List<TravelRequest> requests = travelService.listNearbyRequests(currentAddress);
        return mapper.buildOutputModel(requests);
    }
}
