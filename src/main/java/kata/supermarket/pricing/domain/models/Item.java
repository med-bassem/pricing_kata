package kata.supermarket.pricing.domain.models;

import java.util.UUID;

public class Item {

    private Long id;

    private final String name;

    private final Price basePrice;

    private final ItemBuyMode buyingMode;


    public Item(final String name, final Price basePrice, final ItemBuyMode buyingMode){
        initId();
        this.name = name ;
        this.basePrice = basePrice;
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

    public Price getBasePrice() {
        return basePrice;
    }

    public ItemBuyMode getBuyingMode() {
        return buyingMode;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unitPrice=" + basePrice +
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
