import java.time.Instant;
import java.util.Date;

public class ExitPanel {
    String panelId;

    public ParkingTicket vacateVehicle(ParkingTicket parkingTicket) {
        ParkingLotSystem parkingLotSystem = ParkingLotSystem.get();
        parkingLotSystem.vacateVehicle(parkingTicket);
        parkingTicket.exitTime = Date.from(Instant.ofEpochMilli(System.currentTimeMillis()));

        return parkingTicket;
    }
}
