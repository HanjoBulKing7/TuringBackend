package com.example.ArpegioBackend.repository;

import com.example.ArpegioBackend.entity.Category;
import com.example.ArpegioBackend.entity.CategoryType;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Long> {


    Optional<Category> findByName(@NotBlank( message = "Category must have a name") String name);
}
