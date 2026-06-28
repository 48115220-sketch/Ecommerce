package com.sample.core.dao.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Conexion {

    private static final Logger log
            = Logger.getLogger(Conexion.class.getName());

    private static final String HOST = "db";
    private static final String URL = "jdbc:mysql://" + HOST + ":3306";
    private static final String DBNAME = "ecommercedb";

    private static final String TIMEZONE
            = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static final String USUARIO = "admin";
    private static final String PASSWORD = "admin";
    private static Conexion instance;

    private Connection conn;

    private Conexion() {
    }

    public static Conexion getInstance() {

        if (instance == null) {
            instance = new Conexion();
        }

        return instance;
    }

    public Connection dameConnection() throws Exception {

        try {

            Class.forName(DRIVER);

            conn = DriverManager.getConnection(
                    URL + "/" + DBNAME + TIMEZONE,
                    USUARIO,
                    PASSWORD);

            return conn;

        } catch (ClassNotFoundException e) {

            log.severe(e.getMessage());
            throw new Exception("No se encontró el driver de MySQL.", e);

        } catch (SQLException e) {

            throw new Exception("No se pudo conectar a la base de datos.", e);

        }

    }

}
