package progetto.astrazione;

import java.sql.*;


public class Database {

    public Connection db() 
        throws ClassNotFoundException, SQLException {

            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql-42.7.0://localhost:5432/work_java";
            String username = "postgres";
            String password = "riccardofusaro2000";
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
    }

    public void createTable()
        throws SQLException, ClassNotFoundException {

            try(Connection conn = db()){
                String createDB = "CREATE DATABASE IF NOT EXISTS utenti( id SERIAL, nome VARCHAR(50) PRIMARY KEY, password VARCHAR(255) NOT NULL)";
                try(PreparedStatement createTabStatement = conn.prepareStatement(createDB)){
                    createTabStatement.executeUpdate();
                    conn.close();
                }
            }
    }

    public void insert__DB(String nome, String password)
        throws SQLException, ClassNotFoundException {
            try(Connection conn = db()){
                String insert = "INSERT INTO utenti (nome, password) VALUES (?, ?)";
                try(PreparedStatement insertDataStatement = conn.prepareStatement(insert)){
                    insertDataStatement.setString(1, nome);
                    insertDataStatement.setString(2, password);
                    insertDataStatement.executeUpdate();
                    conn.close();
                }
            }
    }

}
