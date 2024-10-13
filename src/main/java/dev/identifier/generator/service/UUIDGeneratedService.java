package dev.identifier.generator.service;

import dev.identifier.generator.dto.UUIDGeneratedDTO;

import java.util.Optional;

public interface UUIDGeneratedService {
    Optional<UUIDGeneratedDTO> generate();
}
