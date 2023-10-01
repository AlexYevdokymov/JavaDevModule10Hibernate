package org.example;

import org.example.crud.TicketCrudService;


public class Main {
    public static void main(String[] args) {

//        MigrationUtil.migrate();

        TicketCrudService ticketCrudService = new TicketCrudService();
        ticketCrudService.create(5,"EA3","VEN2");

    }
}