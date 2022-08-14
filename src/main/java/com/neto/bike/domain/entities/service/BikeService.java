package com.neto.bike.domain.entities.service;

import com.neto.bike.domain.dto.BikeDTO;

import java.util.List;

public interface BikeService {

    List<BikeDTO> getAllBikes();
    BikeDTO getBike(Long id);
    BikeDTO novaBike(BikeDTO newBike);
}
