package com.example.ArpegioBackend.mapper;

import com.example.ArpegioBackend.entity.Instrument;
import com.example.ArpegioBackend.payload.InstrumentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper( componentModel = "spring" )
public interface InstrumentMapper extends GenericMapper<Instrument, InstrumentDTO>{


    @Override
    @Mapping(target = "category", ignore = true) // lo seteas manual en el service
    Instrument mapToEntity(InstrumentDTO dto);

    @Override
    @Mapping(source = "category.id", target = "categoryId")
    InstrumentDTO mapToDto(Instrument entity);
}
