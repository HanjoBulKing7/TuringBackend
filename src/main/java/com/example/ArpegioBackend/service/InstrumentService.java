package com.example.ArpegioBackend.service;

import com.example.ArpegioBackend.payload.ApiResponse;
import com.example.ArpegioBackend.payload.InstrumentDTO;
import com.example.ArpegioBackend.payload.PageResponse;

public interface InstrumentService {
    ApiResponse<InstrumentDTO> addInstrument(InstrumentDTO dto);
    ApiResponse<PageResponse<InstrumentDTO>> getAllInstruments(int page, int size, String sortBy, String direction);
    ApiResponse<InstrumentDTO> getInstrument(Long id);
    ApiResponse<InstrumentDTO> updateInstrument(Long id, InstrumentDTO dto);
    ApiResponse<?> deleteInstrument(Long id);
    ApiResponse<PageResponse<InstrumentDTO>> getInstrumentsByCategory(Long categoryId, int page, int size, String sortBy, String direction);
}