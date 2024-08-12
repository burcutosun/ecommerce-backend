package com.workintech.ecommerce_backend.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreDto {

    @NotEmpty(message = "Store name is required")
    @Size(min = 3, message = "Store name must be at least 3 characters")
    private String name;

    @NotEmpty(message = "Store phone is required")
    @Pattern(regexp = "^5(0[5-7]|[3-5]\\d) ?\\d{3} ?\\d{4}$", message = "Store phone should be a valid Turkiye phone number")
    private String phone;

    @NotEmpty(message = "Store tax number is required")
    @Pattern(regexp = "^T\\d{4}V\\d{6}$", message = "Store tax number should match the pattern TXXXXVXXXXXX")
    private String taxNo;

    @NotEmpty(message = "Store bank account is required")
    @Pattern(regexp = "^[A-Z]{2}[0-9]{2}[A-Z0-9]{4}[0-9]{7}([A-Z0-9]?){0,16}$", message = "Store bank account should be valid")
    private String bankAccount;

}
