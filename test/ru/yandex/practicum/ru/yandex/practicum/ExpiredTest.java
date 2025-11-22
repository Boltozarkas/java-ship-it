package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.PerishableParcel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ExpiredTest {
    @Test
    public void positiveTestIsExpired() {
        PerishableParcel perishableParcel = new PerishableParcel("Описание", 10, "Адрес", 1, 5);
        assertFalse(perishableParcel.isExpired(3)); // Посылка не испортилась
    }

    @Test
    public void whenCheckingExpirationOfPerishableParcel_shouldReturnCorrectState() { // со временем постараюсь называть получше
        PerishableParcel perishableParcel = new PerishableParcel("Описание", 10, "Адрес", 1, 5);
        assertFalse(perishableParcel.isExpired(6)); // Посылка ещё не испортилась (на грани)
    }

    @Test
    public void negativeTestIsExpired() {
        PerishableParcel perishableParcel = new PerishableParcel("Описание", 10, "Адрес", 1, 5);
        assertTrue(perishableParcel.isExpired(10)); // Посылка испортилась
    }
}
