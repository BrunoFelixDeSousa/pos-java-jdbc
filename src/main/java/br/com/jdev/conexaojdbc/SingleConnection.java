package br.com.jdev.conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

    private static final String url = "jdbc:postgresql://localhost:5432/posjava";
    private static final String user = "postgres";
    private static final String password = "admin";
    private static Connection connection = null;

    static {
        conectar();
    }

    public SingleConnection() {
        conectar();
    }

    private static void conectar() {
        try {
            if ( connection == null ) {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection( url, user, password );
                connection.setAutoCommit(false); // para não salvar automaticamente
                System.out.println("Conectado com sucesso!");
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
