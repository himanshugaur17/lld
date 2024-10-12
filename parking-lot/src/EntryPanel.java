import java.time.Instant;
import java.util.Date;

import vehicle.Vehicle;

public class EntryPanel {
    String panelId;

    public ParkingTicket generateParkingTicket(Vehicle vehicle) {
        ParkingLotSystem parkingLotSystem = ParkingLotSystem.get();
        ParkingSpot parkingSpot = parkingLotSystem.reserveParkingSpot(vehicle);

        return new ParkingTicket(Date.from(Instant.ofEpochMilli(System.currentTimeMillis())),
                "PK-" + parkingSpot.parkingSpotId, vehicle.getPlateNumber(),vehicle.getVehicleType().toString());
    }

}
