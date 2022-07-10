package kata.supermarket.pricing.domain.models;

import java.util.UUID;

public class Item {

    private Long id;

    private final String name;

    private final Price unitPrice;

    private final ItemBuyMode buyingMode;


    public Item(final String name, final Price unitPrice, final ItemBuyMode buyingMode){
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

    public ItemBuyMode getBuyingMode() {
        return buyingMode;
    }
}
