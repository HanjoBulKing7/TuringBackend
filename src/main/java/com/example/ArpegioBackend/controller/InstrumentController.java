package com.example.ArpegioBackend.controller;

import com.example.ArpegioBackend.payload.ApiResponse;
import com.example.ArpegioBackend.payload.InstrumentDTO;
import com.example.ArpegioBackend.payload.PageResponse;
import com.example.ArpegioBackend.service.InstrumentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/instruments")
public class InstrumentController {

    private final InstrumentService instrumentService;

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<InstrumentDTO>>> getAllInstruments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "9") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(instrumentService.getAllInstruments(page, size, sortBy, direction));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<InstrumentDTO>> getOneInstrument(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(instrumentService.getInstrument(id));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<ApiResponse<PageResponse<InstrumentDTO>>> getByCategory(
            @PathVariable Long categoryId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "9") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(instrumentService.getInstrumentsByCategory(categoryId, page, size, sortBy, direction));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<InstrumentDTO>> addInstrument(@Valid @RequestBody InstrumentDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(instrumentService.addInstrument(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<InstrumentDTO>> updateInstrument(
            @PathVariable Long id, @Valid @RequestBody InstrumentDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(instrumentService.updateInstrument(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteInstrument(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(instrumentService.deleteInstrument(id));
    }
}