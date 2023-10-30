package org.example.crud;

import org.example.dao.*;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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
    public Ticket getById(long id) {
        Session session = getSession();
        Ticket ticket = session.get(Ticket.class, id);
        session.close();
        return ticket;
    }
    public List<Ticket> listAll() {
        Session session = getSession();
        List<Ticket> tickets = session.createQuery("from Ticket", Ticket.class).list();
        session.close();
        return tickets;
    }
    public void updateById(long id, long client_id, String from_planet_id, String to_planet_id){
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Ticket ticketToUpdate = session.get(Ticket.class, id);
        if (ticketToUpdate != null) {
            Client client = clientCrudService.getById(client_id);
            Planet planet_from = planetCrudService.getById(from_planet_id);
            Planet planet_to = planetCrudService.getById(to_planet_id);
            if(client != null && planet_from != null && planet_to != null) {
                ticketToUpdate.setClient(client);
                ticketToUpdate.setFrom_planet(planet_from);
                ticketToUpdate.setTo_planet(planet_to);
                System.out.println("Ticket with id = " + id + " was updated");
            } else System.out.println("Incorrect client/planet id for update");
        } else {
            System.out.println("Ticket with id " + id + " is not found");
        }
        transaction.commit();
        session.close();
    }
    public void deleteById(long id) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Ticket ticketToDelete = session.get(Ticket.class, id);
        if (ticketToDelete != null) {
            session.remove(ticketToDelete);
            System.out.println("Ticket with id = " + id + " deleted successfully");
        } else {
            System.out.println("Ticket with id = " + id + " is not found");
        }
        transaction.commit();
        session.close();
    }
}
