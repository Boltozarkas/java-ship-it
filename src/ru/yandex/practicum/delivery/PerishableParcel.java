package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    private static final int COST_PER_UNIT = 3;
    protected int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay) {
        return (sendDay + timeToLive) < currentDay;
    }

    @Override
    protected int getBaseCostPerUnit() {
        return COST_PER_UNIT;
    }
}
