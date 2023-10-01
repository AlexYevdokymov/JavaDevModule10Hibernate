package org.example.crud;

import org.example.dao.*;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TicketCrudService {
    private final HibernateUtil util = HibernateUtil.getInstance();
    private Session getSession() {
        return util.getSessionFactory().openSession();
    }
    ClientCrudService clientCrudService = new ClientCrudService();
    PlanetCrudService planetCrudService = new PlanetCrudService();

    public void create(long client_id, String from_planet_id, String to_planet_id) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Client client = clientCrudService.getById(client_id);
        Planet planet_from = planetCrudService.getById(from_planet_id);
        Planet planet_to = planetCrudService.getById(to_planet_id);
        if(client != null && planet_from != null && planet_to != null) {
            Ticket ticket = new Ticket(client,planet_from,planet_to);
            client.getTickets().add(ticket);
            planet_from.getTickets_from().add(ticket);
            planet_to.getTickets_to().add(ticket);
            session.persist(ticket);
        } else {
            System.out.println("No client/planets with such id");
        }
        transaction.commit();
        session.close();
    }
}
