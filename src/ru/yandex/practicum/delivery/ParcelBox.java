package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;


public class ParcelBox<T extends Parcel> {
    private int maxWeight;
    private List<T> parcels;

    public ParcelBox(int maxWeight, List<T> parcels) {
        this.maxWeight = maxWeight;
        this.parcels = new ArrayList<>();
    }

    // Метод для добавления посылки в коробку
    public boolean addParcel(T parcel) {
        if (getCurrentWeight() + parcel.getWeight() <= maxWeight) {
            parcels.add(parcel);
            System.out.println("Посылка добавлена.");
            return true;
        } else {
            System.out.println("Превышен максимальный вес коробки.");
            return false;
        }
    }

    // Метод для получения всех посылок из коробки
    public List<T> getAllParcels() {
        return parcels;
    }

    // Метод для получения текущего веса всех посылок в коробке
    public int getCurrentWeight() {
        int totalWeight = 0;
        for (T parcel : parcels) {
            totalWeight += parcel.getWeight();
        }
        return totalWeight;
    }



}
