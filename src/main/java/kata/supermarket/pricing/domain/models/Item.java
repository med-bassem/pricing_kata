package kata.supermarket.pricing.domain.models;

import java.util.Objects;
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

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", buyingMode=" + buyingMode +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id.equals(item.id);
    }

    @Override
    public int hashCode() {
        return id.intValue();
    }
}
