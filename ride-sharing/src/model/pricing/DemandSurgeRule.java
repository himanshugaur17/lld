package model.pricing;

public class DemandSurgeRule implements PricingRule {
    @Override
    public double apply(PricingMetadata pricingMetadata, double baseFare) {
        Integer demand = (Integer) pricingMetadata.get("currentDemand");
        if (demand != null && demand > 80) {
            return baseFare * 1.5; // 50% surge if demand > 80%
        }
        return baseFare;
    }

}
