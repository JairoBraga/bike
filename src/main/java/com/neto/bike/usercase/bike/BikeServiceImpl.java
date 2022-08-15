package com.neto.bike.usercase.bike;

import com.neto.bike.domain.dto.BikeDTO;
import com.neto.bike.domain.entities.Bike;
import com.neto.bike.domain.exception.BikeNotFound;
import com.neto.bike.domain.mapper.BikeMapper;
import com.neto.bike.repository.BikeRepository;
import com.neto.bike.usercase.boundaries.BikeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class BikeServiceImpl implements BikeService {

    @Autowired
    private BikeMapper bikeMapper;
    @Autowired
    private BikeRepository bikeRepository;
    @Override
    public List<BikeDTO> getAllBikes() {
        List<Bike> bikeList = bikeRepository.findAll();
        List<BikeDTO> listBikeDTO = bikeList.stream().map(bike -> bikeMapper.bikeToDTO(bike)).collect(Collectors.toList());
        return listBikeDTO;
    }

    @Override
    public BikeDTO getBike(Long id) throws BikeNotFound {
        Bike bike = bikeRepository.findById(id).orElseThrow(() -> new BikeNotFound());
        BikeDTO bikeDTO = bikeMapper.bikeToDTO(bike);
        return bikeDTO;
    }

    @Override
    public BikeDTO novaBike(BikeDTO newBike) {
        Bike novaBike = bikeMapper.dtoToEntity(newBike);
        Bike savedBike = bikeRepository.save(novaBike);
        newBike.setId(savedBike.getId());
        return newBike;
    }
}
