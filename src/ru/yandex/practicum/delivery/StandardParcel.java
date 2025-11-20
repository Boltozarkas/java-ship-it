package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel{
    private static final int COST_PER_UNIT = 2;

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem() {
        super.packageItem();
    }

    @Override
    public void deliver() {
        super.deliver();
    }

    @Override
    public int calculateDeliveryCost(int weight) {
        return super.calculateDeliveryCost(weight);
    }

    @Override
    protected int getBaseCostPerUnit() {
        return COST_PER_UNIT;
    }
}
