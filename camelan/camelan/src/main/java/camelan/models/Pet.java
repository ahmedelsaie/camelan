package camelon.models;

import camelon.utils.StringListConverter;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
@Table(name = "pets")
public class Pet {

    @Id
    private long id;

    @NotBlank
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Tag> tags;

    @NotEmpty
    @Convert(converter = StringListConverter.class)
    private List<String> photoUrls;

    @ManyToOne
    private Category category;

    @Enumerated(EnumType.ORDINAL)
    private Pet.Status status;

    @ManyToOne
    private User owner;

    private enum Status {
        available,
        pending,
        sold
    }


}
