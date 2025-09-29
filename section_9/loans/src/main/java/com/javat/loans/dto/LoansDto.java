package com.javat.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        name = "Loans",
        description = "Schema to hold Loan information"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoansDto {

    @NotEmpty(message = "Mobile Number cannot be a null or empty")
    @Pattern(regexp = "(^S|[0-9]{9})",message = "Mobile number must be 9 digits")
    @Schema(
            description = "Mobile Number of Customer", example = "901234567"
    )
    private String mobileNumber;

    @NotEmpty(message = "Loan Number cannot be a null or empty")
    @Pattern(regexp = "(^S|[0-9]{12})",message = "Loan number must be 12 digits")
    @Schema(
            description = "Loan Number of the customer", example = "547901234567"
    )
    private String loanNumber;

    @NotEmpty(message = "LoanType cannot be a null or empty")
    @Schema(
            description = "Type of the loan", example = "Home Loan"
    )
    private String loanType;

    @Positive(message = "Total loan amount should be greater than zero")
    @Schema(
            description = "Total loan amount", example = "100000"
    )
    private int totalLoan;

    @PositiveOrZero(message = "Total loan amount paid should be equal or greater than zero")
    @Schema(
            description = "Total loan amount paid", example = "1000"
    )
    private int amountPaid;

    @PositiveOrZero(message = "Total outstanding amount should be equal or greater than zero")
    @Schema(
            description = "Total outstanding amount against a loan", example = "99000"
    )
    private int outstandingAmount;

}
