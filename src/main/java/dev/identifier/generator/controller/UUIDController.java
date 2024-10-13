package dev.identifier.generator.controller;

import dev.identifier.generator.dto.UUIDGeneratedDTO;
import dev.identifier.generator.service.UUIDGeneratedService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uuid")
public class UUIDController {

    private final UUIDGeneratedService service;

    public UUIDController(UUIDGeneratedService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UUIDGeneratedDTO> generate(){
        return service.generate()
                .map(uuid -> new ResponseEntity<>(uuid, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
