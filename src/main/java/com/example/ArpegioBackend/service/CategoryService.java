package com.example.ArpegioBackend.service;

import com.example.ArpegioBackend.payload.ApiResponse;
import com.example.ArpegioBackend.payload.CategoryDTO;
import com.example.ArpegioBackend.payload.PageResponse;


public interface CategoryService {

     ApiResponse<CategoryDTO> addCategory(CategoryDTO categoryDTO);
     ApiResponse<PageResponse<CategoryDTO>> getAllCategories(int page, int size, String sortBy, String direction);
     ApiResponse<CategoryDTO> getCategory(Long id);
     ApiResponse<CategoryDTO> updateCategory(Long id, CategoryDTO categoryDTO);
     ApiResponse<?> deleteCategory(Long id);
}
