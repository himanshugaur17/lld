import java.util.List;
import java.util.Map;

import vehicle.VehicleType;

public class ParkingFloor {
    Map<String, List<ParkingSpot>> parkingSpotsByType;

    public ParkingSpot getParkingSpot(VehicleType vehicleType) {
        List<ParkingSpot> parkingSpots = parkingSpotsByType.get(vehicleType.toString());
        return parkingSpots.stream().filter(pS -> !pS.occupied).findFirst().get();
    }
}
