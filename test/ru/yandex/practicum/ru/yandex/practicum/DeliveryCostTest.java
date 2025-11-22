package ru.yandex.practicum;


import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

import static org.junit.jupiter.api.Assertions.*;

public class DeliveryCostTest {

    @Test
    public void testStandardParcelCost() {
        StandardParcel standardParcel = new StandardParcel("Описание", 10, "Адрес", 1);
        assertEquals(standardParcel.calculateDeliveryCost(), 20);
    }

    @Test
    public void testFragileParcelCost() {
        FragileParcel fragileParcel = new FragileParcel("Описание", 10, "Адрес", 1);
        assertEquals(fragileParcel.calculateDeliveryCost(), 40);
    }

    @Test
    public void testPerishableParcelCost() {
        PerishableParcel perishableParcel = new PerishableParcel("Описание", 10, "Адрес", 1, 18);
        assertEquals(perishableParcel.calculateDeliveryCost(), 30);
    }
}