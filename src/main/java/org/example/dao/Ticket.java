package org.example.dao;

import jakarta.persistence.*;
import lombok.Data;


@Table(name = "ticket")
@Entity
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(insertable = false)
    private String created_at;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Planet from_planet;
    @ManyToOne
    private Planet to_planet;
    public Ticket() {}

    public Ticket(Client client, Planet from_planet, Planet to_planet) {
        this.client = client;
        this.from_planet = from_planet;
        this.to_planet = to_planet;
    }
}
