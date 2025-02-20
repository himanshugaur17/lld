package model.pricing;

public interface PricingRule {
    double apply(PricingMetadata pricingMetadata, double baseFare);
}
