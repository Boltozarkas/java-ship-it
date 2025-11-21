package ru.yandex.practicum.delivery;

public abstract class Parcel {
    //добавьте реализацию и другие необходимые классы
    protected String description;
    protected int weight;
    protected String deliveryAddress;
    protected int sendDay;

    public int getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

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

    public int calculateDeliveryCost() {
        return weight * getBaseCostPerUnit(); // к этому я долго еще буду привыкать:D
    }

    protected abstract int getBaseCostPerUnit(); // Спасибо=))
}
