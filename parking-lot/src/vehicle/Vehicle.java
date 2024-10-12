package vehicle;

public abstract class Vehicle {
    String description;
    String plateNumber;
    VehicleType vehicleType;
    public String getDescription() {
        return description;
    }
    public String getPlateNumber() {
        return plateNumber;
    }
    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
