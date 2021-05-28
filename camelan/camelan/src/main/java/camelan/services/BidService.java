package camelon.services;

import camelon.Repository.BidsRepository;
import camelon.Repository.PetsRepository;
import camelon.models.Bid;
import camelon.models.Pet;
import camelon.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BidService {

    @Autowired
    BidsRepository bidsRepository;

    @Autowired
    PetsRepository petsRepository;

    public Bid bid(Bid bid) {

        Long userId = bid.getUser().getId();
        Long petId = bid.getPet().getId();

        List<Bid> pastBid = bidsRepository.findAllByPet_IdAndUser_Id(petId, userId);

        if (pastBid.size() > 0) {
            bidsRepository.delete(pastBid.get(0));
        }

        return bidsRepository.save(bid);
    }


    public List<Bid> listAllBids(Long petId, User owner) {

        Optional<Pet> pet = petsRepository.
            findById(petId);

        if (pet.get().getOwner().getId().equals(owner.getId())) {
            return bidsRepository.findAllByPet_Id(petId);
        }
        else
            return new ArrayList<>();
    }

}
