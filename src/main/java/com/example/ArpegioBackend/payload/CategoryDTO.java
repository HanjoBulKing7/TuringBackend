package com.example.ArpegioBackend.payload;

import com.example.ArpegioBackend.entity.CategoryType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CategoryDTO(
        Long id,
        @NotBlank( message = "Category must have a name")
        String name,
        @Size(max = 300)
        String description
) {
}
