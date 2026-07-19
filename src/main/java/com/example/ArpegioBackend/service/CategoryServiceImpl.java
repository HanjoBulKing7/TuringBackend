package com.example.ArpegioBackend.service;

import com.example.ArpegioBackend.entity.Category;
import com.example.ArpegioBackend.mapper.CategoryMapper;
import com.example.ArpegioBackend.payload.ApiResponse;
import com.example.ArpegioBackend.payload.CategoryDTO;
import com.example.ArpegioBackend.payload.PageResponse;
import com.example.ArpegioBackend.payload.PagebaleResponse;
import com.example.ArpegioBackend.repository.CategoryRepository;
import com.example.ArpegioBackend.utils.PageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final CategoryMapper  categoryMapper;

    @Override
    public ApiResponse<CategoryDTO> addCategory(CategoryDTO categoryDTO) {


        Optional<Category> existingCategory = categoryRepository.findByName(categoryDTO.name());

        if(existingCategory.isPresent())
            throw new RuntimeException("Category already exists");

        Category savedCategory = categoryRepository.save(categoryMapper.mapToEntity(categoryDTO));

        return new ApiResponse<>(
                "Category saved succesfully",
                categoryMapper.mapToDto(savedCategory),
                LocalDateTime.now()
        );
    }

    @Override
    public ApiResponse<PageResponse<CategoryDTO>> getAllCategories(int page, int size, String sortBy, String direction) {
        Sort sortByAndOrder = direction.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sortByAndOrder);

        Page<Category> categoryPage = categoryRepository.findAll(pageable);

        List<CategoryDTO> categoriesDTOs = categoryPage.getContent()
                .stream()
                .map(categoryMapper::mapToDto)
                .toList();

        PageResponse<CategoryDTO> pageResponse = new PageResponse<>();

        pageResponse.setContent(categoriesDTOs);
        pageResponse.setPageNumber(categoryPage.getNumber());
        pageResponse.setPageSize(categoryPage.getSize());
        pageResponse.setTotalElements(categoryPage.getTotalElements());
        pageResponse.setTotalPages(categoryPage.getTotalPages());
        pageResponse.setLastPage(categoryPage.isLast());

        return new ApiResponse<>(
                "Categories retrieved successfully",
                pageResponse,
                LocalDateTime.now()
        );
    }


}
