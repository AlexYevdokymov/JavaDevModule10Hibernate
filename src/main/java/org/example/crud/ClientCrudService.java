package org.example.crud;

import org.example.dao.Client;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientCrudService {
    private final HibernateUtil util = HibernateUtil.getInstance();
    private Session getSession() {
        return util.getSessionFactory().openSession();
    }

    public void create(Client client) {
        try {
            Session session = getSession();
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Client getById(long id) {
        Session session = getSession();
        Client client = session.get(Client.class, id);
        session.close();
        return client;
    }

    public List<Client> listAll() {
        Session session = getSession();
        List<Client> clients = session.createQuery("from Client", Client.class).list();
        session.close();
        return clients;
    }

    public void updateById(long id, String name) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Client clientToUpdate = session.get(Client.class, id);
        if (clientToUpdate != null) {
            clientToUpdate.setName(name);
            System.out.println("Client with id = " + id + " is renamed to \"" + name +"\"");
        } else {
            System.out.println("Client with id " + id + " is not found");
        }
        transaction.commit();
        session.close();
    }

    public void deleteById(long id) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Client clientToDelete = session.get(Client.class, id);
        if (clientToDelete != null) {
            session.remove(clientToDelete);
            System.out.println("Client \"" + clientToDelete.getName()
                    + "\" with id = " + id + " deleted successfully");
        } else {
            System.out.println("Client with id " + id + " is not found");
        }
        transaction.commit();
        session.close();
    }
}
