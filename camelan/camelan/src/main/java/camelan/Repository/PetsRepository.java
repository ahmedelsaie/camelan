package camelon.Repository;

import camelon.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PetsRepository extends JpaRepository<Pet, Integer> {
    Optional<Pet> findById(long l);
}
