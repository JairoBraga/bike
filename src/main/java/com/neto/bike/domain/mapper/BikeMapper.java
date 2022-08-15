package com.neto.bike.domain.mapper;

import com.neto.bike.domain.dto.BikeDTO;
import com.neto.bike.domain.entities.Bike;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BikeMapper {

    BikeMapper INSTANCE = Mappers.getMapper(BikeMapper.class);


    BikeDTO bikeToDTO(Bike bike);


    Bike dtoToEntity(BikeDTO bike);
}
