package org.example;

import org.example.crud.ClientCrudService;
import org.example.crud.PlanetCrudService;
import org.example.crud.TicketCrudService;
import org.example.dao.Client;
import org.example.dao.Planet;
import org.example.dao.Ticket;
import org.example.util.MigrationUtil;


public class Main {
    public static void main(String[] args) {

        MigrationUtil.migrate();

    }
}