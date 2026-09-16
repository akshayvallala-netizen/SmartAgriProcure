package SmartFarmerBackend.service;

import org.springframework.stereotype.Service;

@Service
public class AIPredictionService {

    public int predictWaitingTime(int farmersAhead) {

        // Average processing time per farmer
        int averageTimePerFarmer = 5;

        // Basic AI prediction
        int predictedTime =
                farmersAhead * averageTimePerFarmer;

        return predictedTime;
    }
}