package com.example.ArpegioBackend.payload;

import com.example.ArpegioBackend.entity.CategoryType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryDTO(
        Long categoryID,
        @NotBlank ( message = "Category must have a name")
        CategoryType name,
        @Size(max = 300)
        String description
) {
}
