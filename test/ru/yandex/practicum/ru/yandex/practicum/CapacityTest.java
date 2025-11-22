package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.StandardParcel;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CapacityTest {
    @Test
    public void testAddParcel() {
        ParcelBox<StandardParcel> standardBox = new ParcelBox<>(20, new ArrayList<>());
        StandardParcel parcel = new StandardParcel("Описание", 15, "Адрес", 1);
        assertTrue(standardBox.addParcel(parcel)); // Максимальный вес не превышен, посылка должна быть добавлена
    }

    @Test
    public void testWhenTheBoxIsOverflowing() {
        ParcelBox<StandardParcel> standardBox = new ParcelBox<>(20, new ArrayList<>());
        StandardParcel parcel = new StandardParcel("Описание", 30, "Адрес", 1);
        assertFalse(standardBox.addParcel(parcel)); // Максимальный вес превышен
    }

    @Test
    public void testMaxWeightParcelFailed() {
        ParcelBox<StandardParcel> standardBox = new ParcelBox<>(20, new ArrayList<>());
        StandardParcel maxWeightParcel = new StandardParcel("Описание", 21, "Адрес", 1);
        assertFalse(standardBox.addParcel(maxWeightParcel)); // Максимальный вес превышен (на границе)
    }
}