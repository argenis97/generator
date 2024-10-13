package dev.identifier.generator.repository;

import dev.identifier.generator.entity.UUIDGenerated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UUIDGeneratedRepository extends JpaRepository<UUIDGenerated, Long> {
}
