package app.car.appcarapi.domain;

import app.car.appcarapi.interfaces.outcoming.GMapsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TravelRequestRepository extends JpaRepository<TravelRequest, Long> {


    List<TravelRequest> findByStatus(TravelRequestStatus status);
}
