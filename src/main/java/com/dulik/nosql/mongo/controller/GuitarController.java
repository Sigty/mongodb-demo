package com.dulik.nosql.mongo.controller;

import com.dulik.nosql.mongo.entity.Guitar;
import com.dulik.nosql.mongo.service.GuitarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("v1/guitar")
public class GuitarController {

    private final GuitarService guitarService;

    @GetMapping(value = "/echo")
    public ResponseEntity<Map<String, Object>> echo() {
        return ResponseEntity.ok(Collections.singletonMap("ok", true));
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Boolean> saveGuitar(@RequestBody Guitar newGuitar) {
        guitarService.save(newGuitar);
        return ResponseEntity.ok().body(true);
    }

    @PostMapping("/addList")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Boolean> saveListGuitars(@RequestBody List<Guitar> newGuitars) {
        guitarService.saveList(newGuitars);
        return ResponseEntity.ok().body(true);
    }

    @GetMapping("/get")
    public ResponseEntity<Guitar> getGuitar(@RequestParam(value = "id", required = false) String idGuitar) {
        return ResponseEntity.ok().body(guitarService.getGuitarById(idGuitar).orElse(null));

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Guitar>> getGuitars() {
        return ResponseEntity.ok().body(guitarService.getAllGuitars());
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Boolean> updateGuitar(@RequestBody Guitar newGuitar) {
        guitarService.save(newGuitar);
        return ResponseEntity.ok().body(true);
    }

    @GetMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Boolean> deleteGuitar(@RequestParam(value = "id", required = false) String idGuitar) {
        guitarService.deleteGuitar(idGuitar);
        return ResponseEntity.ok().body(true);
    }
}
