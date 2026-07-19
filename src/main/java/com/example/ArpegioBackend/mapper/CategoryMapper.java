package com.example.ArpegioBackend.mapper;

import com.example.ArpegioBackend.entity.Category;
import com.example.ArpegioBackend.payload.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper( componentModel = "spring" )
public interface CategoryMapper extends GenericMapper<Category, CategoryDTO> {

}
