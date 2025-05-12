package com.javat.cards.constants;

public class CardsConstants {
    public static final String CREDIT_CARD = "Credit Card";
    public static final int NEW_CARD_LIMIT = 100_000;

    private CardsConstants() {
        // Prevent instantiation
    }

    public static final String STATUS_201 = "201";
    public static final String MESSAGE_201 = "Card created successfully";
    public static final String STATUS_200 = "200";
    public static final String MESSAGE_200 = "Request processed successfully";
    public static final String STATUS_500 = "500";
    public static final String MESSAGE_500 = "An error occurred. Please try again later or contact support.";
    public static final String STATUS_417 = "417";
    public static final String MESSAGE_417_UPDATE = "Update operation failed. Please try again later or contact support.";
    public static final String MESSAGE_417_DELETE = "Delete operation failed. Please try again later or contact support.";
}
