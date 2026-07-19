package com.example.ArpegioBackend.repository;

import com.example.ArpegioBackend.entity.Instrument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
    Page<Instrument> findByCategoryId(Long categoryId, Pageable pageable);
}
