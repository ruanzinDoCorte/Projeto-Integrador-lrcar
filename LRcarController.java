package com.exemple.LRcar.LRcar;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.exemple.LRcar.LRcar.Model.LRcarModel;
import com.exemple.LRcar.LRcar.Repository.LRcarRepository;
import com.exemple.LRcar.LRcarDTO.LRcarDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/lrcar")
public class LRcarController {

    @Autowired
    private LRcarRepository lrcarRepository;

    
    @PostMapping
    public ResponseEntity<LRcarModel> createCar(@RequestBody @Valid LRcarDTO lrcarDTO) {
    
        LRcarModel car = new LRcarModel();
        car.setAnodelancamento(lrcarDTO.anodelancamento());
        car.setCor(lrcarDTO.cor());
        car.setModelo(lrcarDTO.modelo());
        car.setStatus(lrcarDTO.status());

        LRcarModel savedCar = lrcarRepository.save(car);
        return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
    }


   
    @GetMapping
    public List<LRcarModel> getAllCars() {
        return lrcarRepository.findAll();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<LRcarModel> getCarById(@PathVariable UUID id) {
        LRcarModel car = lrcarRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carro não encontrado"));

        return new ResponseEntity<>(car, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<LRcarModel> updateCar(@PathVariable UUID id, @RequestBody LRcarDTO lrcarDTO) {
        LRcarModel car = lrcarRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carro não encontrado"));

        
        car.setAnodelancamento(lrcarDTO.anodelancamento());
        car.setCor(lrcarDTO.cor());
        car.setModelo(lrcarDTO.modelo());
        car.setStatus(lrcarDTO.status());

        LRcarModel updatedCar = lrcarRepository.save(car);
        return new ResponseEntity<>(updatedCar, HttpStatus.OK);
  
    }

   
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable UUID id) {
        Optional<LRcarModel> carOptional = lrcarRepository.findById(id);
        if (carOptional.isPresent()) {
            lrcarRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
    }
}
