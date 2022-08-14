package com.neto.bike.controller;

import com.neto.bike.domain.dto.BikeDTO;
import com.neto.bike.domain.entities.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public ResponseEntity<BikeDTO> getBike(@PathVariable Long id){
        BikeDTO bike = bikeService.getBike(id);
        return ResponseEntity.ok(bike);
    }

    @PostMapping
    public ResponseEntity<BikeDTO> novaBike(@RequestBody BikeDTO bikeDTO){
            bikeService.novaBike(bikeDTO);
            return ResponseEntity.ok(bikeDTO);
    }


}
