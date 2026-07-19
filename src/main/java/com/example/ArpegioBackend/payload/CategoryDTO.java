package com.example.ArpegioBackend.payload;

import com.example.ArpegioBackend.entity.CategoryType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CategoryDTO(
        Long id,
        @NotNull( message = "Category must have a name")
        CategoryType name,
        @Size(max = 300)
        String description
) {
}
