package SmartFarmerBackend.repository;

import SmartFarmerBackend.model.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CropRepository extends JpaRepository<Crop, Integer> {

    List<Crop> findByFarmerId(int farmerId);
    List<Crop> findByCenterId(int centerId);
}