package camelon.models;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "categories")
public class Category {

    @Id
    private long id;

    private String name;
}
