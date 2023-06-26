package app.car.appcarapi.domain;

import app.car.appcarapi.interfaces.outcoming.GMapsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TravelService {
    @Autowired
    TravelRequestRepository travelRequestRepository;

    @Autowired
    GMapsService gMapsService;

    private static final int MAX_TRAVEL_TIME = 600;

    public TravelRequest saveTravelRequest(TravelRequest travelRequest) {
        travelRequest.setStatus(TravelRequestStatus.CREATED);
        travelRequest.setCreationDate(new Date());
        return travelRequestRepository.save(travelRequest);
    }

    @GetMapping("/nearby")
    public List<TravelRequest> listNearbyRequests(
            @RequestParam String currentAddress) {

        List<TravelRequest> requests = travelRequestRepository
                .findByStatus(TravelRequestStatus.CREATED);

        return requests
                .stream()
                .filter(tr -> gMapsService.getDistanceBetweenAddresses(currentAddress, tr.getOrigin()) < MAX_TRAVEL_TIME)
                .collect(Collectors.toList());
    }
}
