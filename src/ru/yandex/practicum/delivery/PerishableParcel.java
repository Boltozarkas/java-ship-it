package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel{
    private static final int COST_PER_UNIT = 3;
    protected int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }


    public boolean isExpired(int currentDay) {
        if ((sendDay + timeToLive) >= currentDay) {
            return false; // не испортилась
        } else {
            return  true; // испортилась
        }
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
