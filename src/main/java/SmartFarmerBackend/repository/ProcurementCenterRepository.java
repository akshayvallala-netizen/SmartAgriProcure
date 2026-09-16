package SmartFarmerBackend.repository;

import SmartFarmerBackend.model.ProcurementCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcurementCenterRepository
        extends JpaRepository<ProcurementCenter, Integer> {
}