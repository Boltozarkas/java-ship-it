package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {
    private static final int COST_PER_UNIT = 2;

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }
    // Надо мне привыкнуть замечать когда нужно убирать лишнее переопределение)
    @Override
    protected int getBaseCostPerUnit() {
        return COST_PER_UNIT;
    }
}
