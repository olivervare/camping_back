package ee.camping.back_camping.validation;

import lombok.Getter;

@Getter
public enum Error {
    UNVALIDATED_CREDENTIALS("Vale kasutajanimi või parool", 111),
    USERNAME_UNAVAILABLE("Selline kasutajanimi on juba olemas", 222),
    LISTING_NAME_UNAVAILABLE("Sellise nimega telkimisplats on juba olemas", 333),
    BOOKING_UNAVAILABLE("Kuupäevavaliku konflikt", 666);

    private final String message;
    private final Integer errorCode;

    Error(String message, Integer errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
