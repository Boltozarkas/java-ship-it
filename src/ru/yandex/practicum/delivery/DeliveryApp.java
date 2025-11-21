package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> trackableParcels = new ArrayList<>();
    private static ParcelBox<StandardParcel> standardBox = new ParcelBox<>(20, new ArrayList<>()); // Пример максимального веса
    private static ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(15, new ArrayList<>());
    private static ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(10, new ArrayList<>());

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    updateTrackingStatus();
                    break;
                case 5:
                    showBoxContents();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Обновить статус трекинга всех посылок");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.println("Выберите тип посылки:");
        System.out.println("1 — Стандартная посылка");
        System.out.println("2 — Хрупкая посылка");
        System.out.println("3 — Скоропортящаяся посылка");
        int parcelType = Integer.parseInt(scanner.nextLine());

        System.out.print("Введите описание посылки: ");
        String description = scanner.nextLine();
        System.out.print("Введите вес посылки: ");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите адрес доставки: ");
        String deliveryAddress = scanner.nextLine();
        System.out.print("Введите день отправки (число): ");
        int sendDay = Integer.parseInt(scanner.nextLine());

        Parcel parcel;
        switch (parcelType) {
            case 1:
                parcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
                if (standardBox.addParcel((StandardParcel) parcel)) {
                    allParcels.add(parcel);
                } else {
                    System.out.println("Посылка не добавлена из-за превышения максимального веса коробки.");
                }
                break;
            case 2:
                parcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                trackableParcels.add((Trackable) parcel);
                if (fragileBox.addParcel((FragileParcel) parcel)) {
                    allParcels.add(parcel);
                } else {
                    System.out.println("Посылка не добавлена из-за превышения максимального веса коробки.");
                }
                break;
            case 3:
                System.out.println("Введите срок годности (кол-во дней): ");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                parcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
                if (perishableBox.addParcel((PerishableParcel) parcel)) {
                    allParcels.add(parcel);
                } else {
                    System.out.println("Посылка не добавлена из-за превышения максимального веса коробки.");
                }
                break;
            default:
                System.out.println("Неверный выбор.");
        }
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        int totalCost = 0;
        for (Parcel parcel : allParcels) {
            totalCost += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость доставки всех посылок: " + totalCost);
    }

    private static void updateTrackingStatus() {
        System.out.print("Введите новое местоположение: ");
        String newLocation = scanner.nextLine();
        for (Trackable parcel : trackableParcels) {
            parcel.reportStatus(newLocation);
        }
    }

    private static void showBoxContents() {
        System.out.println("Выберите тип коробки:");
        System.out.println("1 — Стандартная посылка");
        System.out.println("2 — Хрупкая посылка");
        System.out.println("3 — Скоропортящаяся посылка");
        int boxType = Integer.parseInt(scanner.nextLine());

        switch (boxType) {
            case 1:
                for (StandardParcel parcel : standardBox.getAllParcels()) {
                    System.out.println(parcel.getDescription());
                }
                break;
            case 2:
                for (FragileParcel parcel : fragileBox.getAllParcels()) {
                    System.out.println(parcel.getDescription());
                }
                break;
            case 3:
                for (PerishableParcel parcel : perishableBox.getAllParcels()) {
                    System.out.println(parcel.getDescription());
                }
                break;
            default:
                System.out.println("Неверный выбор.");
                break;
        }
    }


}

