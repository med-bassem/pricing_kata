package kata.supermarket.pricing.domain.models.pricing;

import kata.supermarket.pricing.domain.models.ItemBuyMode;
import kata.supermarket.pricing.domain.models.Quantity;

import java.util.Set;

public class PricingApplicability {

    private final Set<ItemBuyMode> applicableBuyingMode;

    private final Quantity applicableQuantity;

    public PricingApplicability(final Quantity applicableQuantity,final ItemBuyMode ... buyModes) {
        this.applicableBuyingMode = Set.of(buyModes);
        this.applicableQuantity = applicableQuantity;
    }

    public boolean isApplicableOn(final ItemBuyMode itemBuyMode){
        return applicableBuyingMode.contains(itemBuyMode);
    }

    public Quantity applicableQuantity(){
        return applicableQuantity;
    }
}
