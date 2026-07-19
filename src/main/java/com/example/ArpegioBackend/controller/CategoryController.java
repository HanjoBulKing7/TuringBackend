package com.example.ArpegioBackend.controller;

import com.example.ArpegioBackend.payload.ApiResponse;
import com.example.ArpegioBackend.payload.CategoryDTO;
import com.example.ArpegioBackend.payload.PageResponse;
import com.example.ArpegioBackend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping("/categories")
    public ResponseEntity<ApiResponse<PageResponse<CategoryDTO>>> getAllCategories(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        ApiResponse<PageResponse<CategoryDTO>> categories = categoryService.getAllCategories(page, size, sortBy, direction);

        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @PostMapping
    public ResponseEntity addCategory(@RequestBody CategoryDTO categoryDTO) {

        ApiResponse<CategoryDTO> savedRes = categoryService.addCategory(categoryDTO);

        return ResponseEntity.status(HttpStatus.OK)
                .body(savedRes);
    }
}
