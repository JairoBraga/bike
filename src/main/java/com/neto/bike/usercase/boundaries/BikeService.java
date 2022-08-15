package com.neto.bike.usercase.boundaries;

import com.neto.bike.domain.dto.BikeDTO;
import com.neto.bike.domain.exception.BikeNotFound;

import java.util.List;

public interface BikeService {

    List<BikeDTO> getAllBikes();
    BikeDTO getBike(Long id) throws BikeNotFound;
    BikeDTO novaBike(BikeDTO newBike);
}
