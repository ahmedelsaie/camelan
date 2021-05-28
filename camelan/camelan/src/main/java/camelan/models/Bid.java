package camelon.models;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "bids")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Pet pet;

    private double amount;
}
