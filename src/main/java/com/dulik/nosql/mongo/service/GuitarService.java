package com.dulik.nosql.mongo.service;

import com.dulik.nosql.mongo.entity.Guitar;
import com.dulik.nosql.mongo.repository.GuitarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GuitarService {

    private final GuitarRepository guitarRepository;

    public void save(Guitar newGuitar) {
        if (newGuitar != null) {
            guitarRepository.save(newGuitar);
        }
    }

    public void saveList(List<Guitar> newGuitars) {
        if (newGuitars != null && !newGuitars.isEmpty()) {
            guitarRepository.saveAll(newGuitars);
        }
    }

    public List<Guitar> getAllGuitars() {
        return guitarRepository.findAll();
    }

    public Optional<Guitar> getGuitarById(String idGuitar) {
        return guitarRepository.findById(idGuitar);
    }

    public void deleteGuitar(String idGuitar) {
        getGuitarById(idGuitar).ifPresent(guitarRepository::delete);
    }
}
