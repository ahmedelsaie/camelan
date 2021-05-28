package camelon.Repository;

import camelon.models.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BidsRepository extends JpaRepository<Bid, Integer> {

    List<Bid> findAllByPet_Id(Long petId);

    List<Bid> findAllByPet_IdAndUser_Id(Long petId,Long userId);
}
