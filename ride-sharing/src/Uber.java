import model.pricing.PricingMetadata;
import request.RideRequest;
import response.RideRequestResponse;

public class Uber {
    private final PricingService pricingService;
    private final LocationService locationService;

    public Uber(PricingService pricingService, LocationService locationService) {
        this.pricingService = pricingService;
        this.locationService = locationService;
    }

    public RideRequestResponse rideRequest(RideRequest rideRequest) {
        PricingMetadata.Builder pricingMBuilder = new PricingMetadata.Builder();
        PricingMetadata pricingMetadata = pricingMBuilder.add("currentDemand", 5)
                .add("city", rideRequest.getCity())
                .build();
        double price = pricingService.getPrice(pricingMetadata);
        RideRequestResponse.Builder responseBuilder = new RideRequestResponse.Builder();
        return responseBuilder.price(price).build();
    }
    

}
