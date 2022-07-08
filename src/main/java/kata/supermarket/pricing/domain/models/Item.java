package kata.supermarket.pricing.domain.models;

import java.util.UUID;

public class Item {

    private Long id;

    private final String name;

    private final Price unitPrice;

    private final BuyingMode buyingMode;


    public Item(final String name, final Price unitPrice, final BuyingMode buyingMode){
        initId();
        this.name = name ;
        this.unitPrice = unitPrice;
        this.buyingMode = buyingMode;
    }

    private void initId(){
        this.id = UUID.randomUUID().getLeastSignificantBits();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Price getUnitPrice() {
        return unitPrice;
    }

    public BuyingMode getBuyingMode() {
        return buyingMode;
    }
}
