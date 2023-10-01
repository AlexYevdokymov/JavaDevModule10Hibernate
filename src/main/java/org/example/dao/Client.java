package org.example.dao;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Table(name = "client")
@Entity
@Data
@ToString(exclude = "tickets")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @OneToMany(mappedBy = "client",fetch = FetchType.EAGER)
    private List<Ticket> tickets;

    public Client() {}
    public Client(String name) {
        this.name = name;
    }
}
