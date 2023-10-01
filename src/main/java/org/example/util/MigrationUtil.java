package org.example.util;

import org.flywaydb.core.Flyway;

public class MigrationUtil {
    public static void migrate() {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:./mydb",null,null)
                .load();
        flyway.migrate();
    }
}
