package camelon.controller;

import camelon.models.Bid;
import camelon.models.User;
import camelon.services.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    BidService petsService;

    @RequestMapping(value = "/bid", method = POST, produces = "application/json")
    public Bid bid(@RequestBody Bid bid) {

        return petsService.bid(bid);
    }

    @RequestMapping(value = "/listAllbids/{pet_id}", method = GET, produces = "application/json")
    public List<Bid> listAllbids(@PathVariable("pet_id") Long petId,
                                 @RequestHeader(name="user") User user) {
        return petsService.listAllBids(petId, user);
    }


}
