package SmartFarmerBackend.repository;

import SmartFarmerBackend.model.Officer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfficerRepository extends JpaRepository<Officer, Integer> {

    Optional<Officer> findByMobile(String mobile);
}