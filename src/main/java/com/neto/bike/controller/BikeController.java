package com.neto.bike.controller;

import com.neto.bike.domain.dto.BikeDTO;
import com.neto.bike.usercase.boundaries.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bikes")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @GetMapping(path = "/listaBicicletas")
    public ResponseEntity<List<BikeDTO>> getAllBikes(){
        List<BikeDTO> bikeList = bikeService.getAllBikes();
        return ResponseEntity.ok(bikeList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BikeDTO> getBike(@PathVariable Long id){
        BikeDTO bike = bikeService.getBike(id);
        return ResponseEntity.ok(bike);
    }

    @PostMapping
    public ResponseEntity<BikeDTO> novaBike(@RequestBody BikeDTO bikeDTO){
            bikeService.novaBike(bikeDTO);
            return ResponseEntity.ok(bikeDTO);
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarBike(@RequestBody BikeDTO bikeDTO){
        bikeService.removerBike(bikeDTO);
    }

    @PostMapping("/alugar")
    public BikeDTO locarBike(@RequestBody BikeDTO bikeDTO){
        BikeDTO updatedBike = bikeService.alugarBike(bikeDTO);
        return updatedBike;
    }
    @PostMapping("/entrega")
    public BikeDTO entregarBike(@RequestBody BikeDTO bikeDTO){
        BikeDTO updatedBike = bikeService.entregarBike(bikeDTO);
        return updatedBike;
    }
}
