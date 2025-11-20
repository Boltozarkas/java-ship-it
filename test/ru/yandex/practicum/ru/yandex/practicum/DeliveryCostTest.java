package ru.yandex.practicum;


import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DeliveryCostTest {

    @Test
    public void testStandardParcelCost() {
        StandardParcel standardParcel = new StandardParcel("Описание", 10, "Адрес", 1);
        assertEquals(standardParcel.calculateDeliveryCost(10), 20);
    }

    @Test
    public void testFragileParcelCost() {
        FragileParcel fragileParcel = new FragileParcel("Описание", 10, "Адрес", 1);
        assertEquals(fragileParcel.calculateDeliveryCost(10), 40);
    }

    @Test
    public void testPerishableParcelCost() {
        PerishableParcel perishableParcel = new PerishableParcel("Описание", 10, "Адрес", 1, 18);
        assertEquals(perishableParcel.calculateDeliveryCost(10), 30);
    }

    @Test
    public void positiveTestIsExpired() {
        PerishableParcel perishableParcel = new PerishableParcel("Описание", 10, "Адрес", 1, 5);
        assertFalse(perishableParcel.isExpired(6)); // Посылка ещё не испортилась
    }

    @Test
    public void negativeTestIsExpired() {
        PerishableParcel perishableParcel = new PerishableParcel("Описание", 10, "Адрес", 1, 5);
        assertTrue(perishableParcel.isExpired(7)); // Посылка испортилась
    }

    @Test
    public void testAddParcel() {
        ParcelBox<StandardParcel> standardBox = new ParcelBox<>(20, new ArrayList<>());

        StandardParcel parcel = new StandardParcel("Описание", 15, "Адрес", 1);
        assertTrue(standardBox.addParcel(parcel)); // Максимальный вес не превышен, посылка должна быть добавлена

        StandardParcel anotherParcel = new StandardParcel("Описание", 10, "Адрес", 1);
        assertFalse(standardBox.addParcel(anotherParcel)); // Максимальный вес превышен, посылка не должна быть добавлена
    }
}
