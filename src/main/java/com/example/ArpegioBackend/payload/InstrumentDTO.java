package com.example.ArpegioBackend.payload;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record InstrumentDTO(
        Long id,
        @NotBlank(message = "Instrument must have a name")
        @Size(min = 2, max = 100)
        String name,
        @NotNull
        @DecimalMin(value = "0.0", inclusive = false)
        @Digits(integer = 8, fraction = 2)
        BigDecimal price,
        @NotNull(message = "Instrument must have a category")
        Long categoryId,
        @NotBlank
        @Size(max = 60)
        String model,
        @Size(max = 500)
        String description,
        @NotNull
        @Min(0)
        Integer stock
) {}
