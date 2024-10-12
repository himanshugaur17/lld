import java.util.Date;

public class ParkingTicket {
    Date entryTime;
    Date exitTime;
    String parkingTicketId;
    String vehicleRegisterNumber;
    String vehicleType;

    public ParkingTicket(Date entryTime, String parkingTicketId, String vehicleRegisterNumber, String vehicleType) {
        this.entryTime = entryTime;
        this.parkingTicketId = parkingTicketId;
        this.vehicleRegisterNumber = vehicleRegisterNumber;
        this.vehicleType = vehicleType;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

}
