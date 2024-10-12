package parking.spot;

public abstract class ParkingSpot {
    String id;
    String description;
    boolean occupied;

    public ParkingSpot(String id, String description, boolean occupied) {
        this.id = id;
        this.description = description;
        this.occupied = occupied;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

}
