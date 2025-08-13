package com.javatuz.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountsDto {

    @NotEmpty(message = "AccountNumber cannot be a null or empty")
    @Pattern(regexp = "(^S|[0-9]{9})",message = "Mobile number must be 9 digits")
    @Schema(
            description = "Account Number of Eazy Bank account", example = "345443324"
    )
    private Long accountNumber;

    @Schema(
            description = "Account type of Eazy Bank account", example = "Savings"
    )
    @NotEmpty(message = "AccountType cannot be a null or empty")
    private String accountType;

    @NotEmpty(message = "BranchAddress cannot be a null or empty")
    @Schema(
            description = "Eazy Bank branch address", example = "Bobut Street 85, 28"
    )
    private String branchAddress;
}
