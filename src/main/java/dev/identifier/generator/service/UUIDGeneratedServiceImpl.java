package dev.identifier.generator.service;

import dev.identifier.generator.dto.UUIDGeneratedDTO;
import dev.identifier.generator.entity.UUIDGenerated;
import dev.identifier.generator.mapper.UUIDGeneratedMapper;
import dev.identifier.generator.repository.UUIDGeneratedRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UUIDGeneratedServiceImpl implements UUIDGeneratedService {

    private final UUIDGeneratedRepository repository;
    private final UUIDGeneratedMapper mapper;

    public UUIDGeneratedServiceImpl(UUIDGeneratedRepository repository, UUIDGeneratedMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<UUIDGeneratedDTO> generate() {

        Optional<UUIDGenerated> oUUID = repository.findAll()
                .stream()
                .findFirst();

        if (oUUID.isEmpty())
        {
            UUIDGenerated uuid = new UUIDGenerated();
            uuid.setUuid(UUID.randomUUID());
            repository.save(uuid);

            return Optional.of(mapper.toDTO(uuid));
        }

        return oUUID
                .map(mapper::toDTO);
    }
}
