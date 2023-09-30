package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PlanetCrudService {
    private final HibernateUtil util = HibernateUtil.getInstance();
    private Session getSession() {
        return util.getSessionFactory().openSession();
    }

    public void create(Planet planet) {
        try {
            Session session = getSession();
            Transaction transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Planet getById(String id) {
        Session session = getSession();
        Planet planet = session.get(Planet.class, id);
        session.close();
        return planet;
    }
    public List<Planet> listAll() {
        Session session = getSession();
        List<Planet> planets = session.createQuery("from Planet", Planet.class).list();
        session.close();
        return planets;
    }
    public void updateById(String id, String name) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Planet planetToUpdate = session.get(Planet.class, id);
        if (planetToUpdate != null) {
            planetToUpdate.setName(name);
            System.out.println("Planet with id = " + id + " is renamed to \"" + name +"\"");
        } else {
            System.out.println("Planet with id " + id + " is not found");
        }
        transaction.commit();
        session.close();
    }
    public void deleteById(String id) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Planet planetToDelete = session.get(Planet.class, id);
        if (planetToDelete != null) {
            session.remove(planetToDelete);
            System.out.println("Planet \"" + planetToDelete.getName()
                    + "\" with id = " + id + " deleted successfully");
        } else {
            System.out.println("Planet with id = " + id + " is not found");
        }
        transaction.commit();
        session.close();
    }
}
