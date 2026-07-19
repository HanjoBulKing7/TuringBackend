package com.example.ArpegioBackend.mapper;

public interface GenericMapper<E, D> {

    E mapToEntity(D dto);
    D mapToDto(E entity);


}
