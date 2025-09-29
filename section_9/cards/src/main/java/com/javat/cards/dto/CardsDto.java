package com.javat.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        name = "Cards",
        description = "Schema to hold Card information"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardsDto {

    @NotEmpty(message = "Mobile Number cannot be a null or empty")
    @Pattern(regexp = "(^S|[0-9]{9})",message = "Mobile number must be 9 digits")
    @Schema(
            description = "Mobile Number of Customer", example = "901234567"
    )
    private String mobileNumber;

    @NotEmpty(message = "Card Number cannot be a null or empty")
    @Pattern(regexp = "(^S|[0-9]{12})",message = "Card number must be 12 digits")
    @Schema(
            description = "Card Number of the customer", example = "547901234567"
    )
    private String cardNumber;

    @NotEmpty(message = "CardType cannot be a null or empty")
    @Schema(
            description = "Type of the card", example = "Credit Card"
    )
    private String cardType;

    @Positive(message = "Total limit amount should be greater than zero")
    @Schema(
            description = "Total limit amount", example = "100000"
    )
    private int totalLimit;

    @PositiveOrZero(message = "Amount used should be equal or greater than zero")
    @Schema(
            description = "Amount used", example = "1000"
    )
    private int amountUsed;

    @PositiveOrZero(message = "Available amount should be equal or greater than zero")
    @Schema(
            description = "Available amount against a card", example = "99000"
    )
    private int availableAmount;

}
