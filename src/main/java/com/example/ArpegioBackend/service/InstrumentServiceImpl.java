package com.example.ArpegioBackend.service;

import com.example.ArpegioBackend.entity.Category;
import com.example.ArpegioBackend.entity.Instrument;
import com.example.ArpegioBackend.exception.ResourceNotFoundException;
import com.example.ArpegioBackend.mapper.InstrumentMapper;
import com.example.ArpegioBackend.payload.ApiResponse;
import com.example.ArpegioBackend.payload.InstrumentDTO;
import com.example.ArpegioBackend.payload.PageResponse;
import com.example.ArpegioBackend.repository.CategoryRepository;
import com.example.ArpegioBackend.repository.InstrumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstrumentServiceImpl implements InstrumentService {

    private final InstrumentRepository instrumentRepository;
    private final CategoryRepository categoryRepository;
    private final InstrumentMapper instrumentMapper;

    @Override
    public ApiResponse<InstrumentDTO> addInstrument(InstrumentDTO dto) {
        Category category = categoryRepository.findById(dto.categoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        Instrument instrument = instrumentMapper.mapToEntity(dto);
        instrument.setCategory(category);

        Instrument saved = instrumentRepository.save(instrument);

        return new ApiResponse<>(
                "Instrument saved successfully",
                instrumentMapper.mapToDto(saved),
                LocalDateTime.now()
        );
    }

    @Override
    public ApiResponse<PageResponse<InstrumentDTO>> getAllInstruments(int page, int size, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Instrument> instrumentPage = instrumentRepository.findAll(pageable);

        List<InstrumentDTO> dtos = instrumentPage.getContent()
                .stream()
                .map(instrumentMapper::mapToDto)
                .toList();

        PageResponse<InstrumentDTO> pageResponse = new PageResponse<>();
        pageResponse.setContent(dtos);
        pageResponse.setPageNumber(instrumentPage.getNumber());
        pageResponse.setPageSize(instrumentPage.getSize());
        pageResponse.setTotalElements(instrumentPage.getTotalElements());
        pageResponse.setTotalPages(instrumentPage.getTotalPages());
        pageResponse.setLastPage(instrumentPage.isLast());

        return new ApiResponse<>("Instruments retrieved successfully", pageResponse, LocalDateTime.now());
    }

    @Override
    public ApiResponse<InstrumentDTO> getInstrument(Long id) {
        Instrument instrument = instrumentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instrument not found"));

        return new ApiResponse<>("Instrument found", instrumentMapper.mapToDto(instrument), LocalDateTime.now());
    }

    @Override
    public ApiResponse<InstrumentDTO> updateInstrument(Long id, InstrumentDTO dto) {
        Instrument existing = instrumentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instrument not found"));

        Category category = categoryRepository.findById(dto.categoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        existing.setName(dto.name());
        existing.setPrice(dto.price());
        existing.setModel(dto.model());
        existing.setDescription(dto.description());
        existing.setStock(dto.stock());
        existing.setCategory(category);

        Instrument updated = instrumentRepository.save(existing);

        return new ApiResponse<>("Instrument updated successfully", instrumentMapper.mapToDto(updated), LocalDateTime.now());
    }

    @Override
    public ApiResponse<?> deleteInstrument(Long id) {
        instrumentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instrument not found"));

        instrumentRepository.deleteById(id);

        return new ApiResponse<>("Instrument with id " + id + " deleted successfully", null, LocalDateTime.now());
    }

    @Override
    public ApiResponse<PageResponse<InstrumentDTO>> getInstrumentsByCategory(Long categoryId, int page, int size, String sortBy, String direction) {
        categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        Sort sort = direction.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Instrument> instrumentPage = instrumentRepository.findByCategoryId(categoryId, pageable);

        List<InstrumentDTO> dtos = instrumentPage.getContent()
                .stream()
                .map(instrumentMapper::mapToDto)
                .toList();

        PageResponse<InstrumentDTO> pageResponse = new PageResponse<>();
        pageResponse.setContent(dtos);
        pageResponse.setPageNumber(instrumentPage.getNumber());
        pageResponse.setPageSize(instrumentPage.getSize());
        pageResponse.setTotalElements(instrumentPage.getTotalElements());
        pageResponse.setTotalPages(instrumentPage.getTotalPages());
        pageResponse.setLastPage(instrumentPage.isLast());

        return new ApiResponse<>("Instruments retrieved successfully", pageResponse, LocalDateTime.now());
    }
}