package factory;

import java.util.Arrays;
import java.util.List;

import model.pricing.DemandSurgeRule;
import model.pricing.PricingRule;
import service.IPricingRuleEngine;

public class PricingRuleEngineFactory {
    IPricingRuleEngine defaultPricingRuleEngine() {
        List<PricingRule> pricingRules = Arrays.asList(new DemandSurgeRule());
        return (pricingMetadata, baseFare) -> {
            double fare = baseFare;
            for (PricingRule pricingRule : pricingRules) {
                fare = pricingRule.apply(pricingMetadata, fare);
            }
            return fare;
        };
    }
}
