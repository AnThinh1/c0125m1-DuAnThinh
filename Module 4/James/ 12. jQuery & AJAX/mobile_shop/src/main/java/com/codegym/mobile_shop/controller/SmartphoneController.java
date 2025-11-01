package com.codegym.mobile_shop.controller;

import com.codegym.mobile_shop.model.Smartphone;
import com.codegym.mobile_shop.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/smartphones")
public class SmartphoneController {

    @Autowired
    private ISmartphoneService smartphoneService;

    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> findAllSmartphones() {
        List<Smartphone> smartphones = (List<Smartphone>) smartphoneService.findAll();
        if (smartphones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartphones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Smartphone> findSmartphoneById(@PathVariable("id") Long id) {
        Optional<Smartphone> smartphone = smartphoneService.findById(id);
        return smartphone.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        Smartphone saved = smartphoneService.save(smartphone);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Smartphone> updateSmartphone(@PathVariable("id") Long id, @RequestBody Smartphone smartphone) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphone.setId(smartphoneOptional.get().getId());
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable("id") Long id) {
        Optional<Smartphone> smartphone = smartphoneService.findById(id);
        if (!smartphone.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphone.get(), HttpStatus.OK);
    }
}