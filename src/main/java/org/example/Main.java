package org.example;

import org.flywaydb.core.Flyway;


public class Main {
    public static void main(String[] args) {

        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:./mydb",null,null)
                .load();
        flyway.migrate();

//        ClientCrudService clientCrudService = new ClientCrudService();
//        PlanetCrudService planetCrudService = new PlanetCrudService();
//
//        System.out.println("clientCrudService.listAll() = " + clientCrudService.listAll());
//        clientCrudService.create(new Client("Mark Brown"));
//        clientCrudService.create(new Client("Mark Brown Jr."));
//        System.out.println("clientCrudService.getById(11) = " + clientCrudService.getById(11));
//        System.out.println("clientCrudService.getById(454) = " + clientCrudService.getById(454));
//        clientCrudService.updateById(5, "Angela Shelby");
//        clientCrudService.updateById(58, "Catrin Johnson");
//        clientCrudService.deleteById(11);
//        clientCrudService.deleteById(93);
//        System.out.println("clientCrudService.listAll() = " + clientCrudService.listAll());
//        System.out.println();
//        System.out.println("planetCrudService.listAll() = " + planetCrudService.listAll());
//        planetCrudService.create(new Planet("UR","Uranus"));
//        planetCrudService.create(new Planet("ST","Saturn"));
//        System.out.println("planetCrudService.getById(\"EA3\") = " + planetCrudService.getById("EA3"));
//        System.out.println("planetCrudService.getById(\"UR\") = " + planetCrudService.getById("UR"));
//        System.out.println("planetCrudService.getById(\"Some_id\") = " + planetCrudService.getById("Some_id"));
//        planetCrudService.updateById("EA3", "Earth365");
//        planetCrudService.updateById("", "Some_planet");
//        planetCrudService.deleteById("UR");
//        planetCrudService.deleteById("NOTID");
//        System.out.println("planetCrudService.listAll() = " + planetCrudService.listAll());
    }
}