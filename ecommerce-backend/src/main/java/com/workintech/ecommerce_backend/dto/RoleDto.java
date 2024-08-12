package com.workintech.ecommerce_backend.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {

    @NotNull(message = "Id is required")
    private long id;

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Code is required")
    private String code;

}
