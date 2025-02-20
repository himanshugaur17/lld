package service;

import model.pricing.PricingMetadata;

@FunctionalInterface
public interface IPricingRuleEngine {
    double calculateFare(PricingMetadata pricingMetadata, double baseFare);

}
