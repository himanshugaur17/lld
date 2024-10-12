import java.util.List;
import java.util.Optional;

import vehicle.Vehicle;

public class ParkingLotSystem {
    List<EntryPanel> entryPanels;
    List<ExitPanel> exitPanels;
    List<ParkingFloor> parkingFloors;
    static ParkingLotSystem parkingLotSystem;

    public static ParkingLotSystem get() {
        if (parkingLotSystem == null)
            parkingLotSystem = new ParkingLotSystem();
        return parkingLotSystem;
    }

    public boolean vacateVehicle(ParkingTicket parkingTicket) {
        String parkingSpotId = parkingTicket.parkingTicketId.split("PK-")[1];
        Optional<ParkingSpot> parkSpotOptional = parkingFloors.stream()
                .map(pF -> pF.parkingSpotsByType.get(parkingTicket.vehicleType).stream()
                        .filter(pS -> pS.parkingSpotId.equals(parkingSpotId))
                        .findFirst())
                .filter(pSOptional -> pSOptional.isPresent()).findFirst().get();
        parkSpotOptional.get().occupied = false;
        parkSpotOptional.get().vehicle = null;
        return true;
    }

    public ParkingSpot reserveParkingSpot(Vehicle vehicle) {
        for (ParkingFloor parkingFloor : parkingFloors) {
            ParkingSpot parkingSpot = parkingFloor.getParkingSpot(vehicle.getVehicleType());
            parkingSpot.occupied = true;
            parkingSpot.vehicle = vehicle;
            if (parkingSpot != null)
                return parkingSpot;
        }
        return null;
    }
}
