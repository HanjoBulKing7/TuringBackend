package com.example.ArpegioBackend.mapper;

import com.example.ArpegioBackend.entity.Users;
import com.example.ArpegioBackend.payload.UserDTO;
import org.mapstruct.Mapper;

@Mapper( componentModel = "spring" )
public interface UserMapper extends GenericMapper<Users, UserDTO> {

}
