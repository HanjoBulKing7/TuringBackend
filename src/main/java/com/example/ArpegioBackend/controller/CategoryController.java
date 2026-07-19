package com.example.ArpegioBackend.controller;

import com.example.ArpegioBackend.payload.ApiResponse;
import com.example.ArpegioBackend.payload.CategoryDTO;
import com.example.ArpegioBackend.payload.PageResponse;
import com.example.ArpegioBackend.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<CategoryDTO>>> getAllCategories(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        ApiResponse<PageResponse<CategoryDTO>> categories = categoryService.getAllCategories(page, size, sortBy, direction);

        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryDTO>> getOneCategory(
            @PathVariable Long id
    ) {
        ApiResponse<CategoryDTO> foundCategoryRes = categoryService.getCategory(id);

        return ResponseEntity.status(HttpStatus.OK).body(foundCategoryRes);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CategoryDTO>> addCategory(@Valid @RequestBody CategoryDTO categoryDTO) {

        ApiResponse<CategoryDTO> savedRes = categoryService.addCategory(categoryDTO);

        return ResponseEntity.status(HttpStatus.OK)
                .body(savedRes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryDTO>> updateCategory(
            @PathVariable Long id,
            @Valid @RequestBody CategoryDTO categoryDTO) {

        ApiResponse<CategoryDTO> updatedRes = categoryService.updateCategory(id, categoryDTO);

        return ResponseEntity.status(HttpStatus.OK).body(updatedRes);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Long id){

        categoryService.deleteCategory(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
