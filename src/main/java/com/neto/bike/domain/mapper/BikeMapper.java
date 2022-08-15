package com.neto.bike.domain.mapper;

import com.neto.bike.domain.dto.BikeDTO;
import com.neto.bike.domain.entities.Bike;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BikeMapper {

    BikeMapper INSTANCE = Mappers.getMapper( BikeMapper.class );

    @Mapping(source = "bikeEntity", target = "bikeDTO")
    BikeDTO bikeToDTO(Bike bike);

    @Mapping(source = "bikeDTO", target = "bikeEntity")
    Bike dtoToEntity(BikeDTO bike);
}
