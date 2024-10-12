import vehicle.Vehicle;

public class ParkingSpot {
    boolean occupied;
    Vehicle vehicle;
    String parkingSpotId;
    public ParkingSpot(boolean occupied, String parkingSpotId) {
        this.occupied = occupied;
        this.parkingSpotId = parkingSpotId;
    }
}
