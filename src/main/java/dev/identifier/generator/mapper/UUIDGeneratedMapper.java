package dev.identifier.generator.mapper;

import dev.identifier.generator.dto.UUIDGeneratedDTO;
import dev.identifier.generator.entity.UUIDGenerated;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UUIDGeneratedMapper {

    @Mapping(source = "uuid", target = "uuidGenerated")
    UUIDGeneratedDTO toDTO(UUIDGenerated uuid);

    @InheritInverseConfiguration
    UUIDGenerated toEntity(UUIDGeneratedDTO dto);
}
