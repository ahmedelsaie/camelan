package camelon.models;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tags")
public class Tag {

    @Id
    private long id;

    private String name;

}
