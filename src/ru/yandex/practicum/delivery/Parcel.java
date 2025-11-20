package ru.yandex.practicum.delivery;

public abstract class Parcel {
    //добавьте реализацию и другие необходимые классы
    protected String description;

    public int getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    protected int weight;
    protected String deliveryAddress;
    protected int sendDay; // день месяца, в который посылка была отправлена. Для упрощения предполагаем,
    // что посылки всегда доставляются в том же календарном месяце, что и отправляются, и сам месяц нас не интересует.
    // Полноценную работу с датами в Java вы освоите чуть позже.


    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public void packageItem() {
        System.out.println("Посылка <<" + description + ">> упакована");
    }

    public void deliver() {
        System.out.println("Посылка <<" + description + ">> доставлена по адресу " + deliveryAddress);
    }

    public int calculateDeliveryCost(int weight) {
        return weight * getBaseCostPerUnit();
    }

    protected abstract int getBaseCostPerUnit();
}
