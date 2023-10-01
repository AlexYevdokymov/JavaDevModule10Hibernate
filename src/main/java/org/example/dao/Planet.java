package org.example.dao;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Table(name = "planet")
@Entity
@Data
public class Planet {
    @Id
    private String id;
    @Column
    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "from_planet",fetch = FetchType.EAGER)
    private List<Ticket> tickets_from;

    @ToString.Exclude
    @OneToMany(mappedBy = "to_planet",fetch = FetchType.EAGER)
    private List<Ticket> tickets_to;

    public Planet() {
    }

    public Planet(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
