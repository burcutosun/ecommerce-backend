package com.workintech.ecommerce_backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotEmpty(message = "Full name is required")
    @Size(min = 3, message = "Full name must be at least 3 characters")
    private String name;

    @Email(message = "Email should be valid")
    @NotEmpty(message = "Email is required")
    private String email;

    @NotEmpty(message = "Password is required")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@.#$!%*?&^])[A-Za-z\\d@.#$!%*?&]{8,}$", message = "Password must be at least 8 characters including numbers, lowercase letters, uppercase letters and special characters")
    private String password;

    @NotEmpty(message = "Role id is required")
    private long roleId;

}
