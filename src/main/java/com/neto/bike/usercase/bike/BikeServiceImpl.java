package com.neto.bike.usercase.bike;

import com.neto.bike.domain.dto.BikeDTO;
import com.neto.bike.domain.entities.Bike;
import com.neto.bike.domain.exception.BikeNotFound;
import com.neto.bike.domain.mapper.BikeMapper;
import com.neto.bike.repository.BikeRepository;
import com.neto.bike.usercase.boundaries.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
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
    public BikeDTO getBike(Long id){
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

    @Override
    public void removerBike(BikeDTO bikeDTO) {
        Bike bike = bikeRepository.findById(bikeDTO.getId()).orElseThrow(() -> new BikeNotFound());
        bikeRepository.delete(bike);
    }

    @Override
    public BikeDTO alugarBike(BikeDTO bikeDTO) {
        Bike bike = bikeRepository.findById(bikeDTO.getId()).orElseThrow(() -> new BikeNotFound());
        updateCamposAluguel(bike,bikeDTO);
        bikeRepository.save(bike);
        return bikeMapper.bikeToDTO(bike);
    }

    @Override
    public BikeDTO entregarBike(BikeDTO bikeLocada) {
        Bike bike = bikeRepository.findById(bikeLocada.getId()).orElseThrow(() -> new BikeNotFound());
        updateCamposEntrega(bike,bikeLocada);
        bikeRepository.save(bike);
        return bikeMapper.bikeToDTO(bike);
    }

    private void updateCamposAluguel(Bike bike, BikeDTO updateBike){
        bike.setUltimoAluguel(updateBike.getUltimoAluguel());
        bike.setIdLocatario(updateBike.getIdLocatario());
        bike.setVeiculoAlugado(true);
    }
    private void updateCamposEntrega(Bike bike, BikeDTO updateBike){
        bike.setIdLocatario(null);
        bike.setRegiao(updateBike.getRegiao());
        bike.setVeiculoAlugado(false);
    }
}
