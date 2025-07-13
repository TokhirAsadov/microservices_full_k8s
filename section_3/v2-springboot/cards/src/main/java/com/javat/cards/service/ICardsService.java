package com.javat.cards.service;

import com.javat.cards.dto.CardsDto;

public interface ICardsService {
    void createCards(String mobileNumber);

    CardsDto fetchCard(String mobileNumber);

    Boolean updateCard(CardsDto cardsDto);

    Boolean deleteCard(String mobileNumber);
}
