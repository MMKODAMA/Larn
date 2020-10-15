package br.senac.tads.pi4.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Larn
 */
public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String LOGIN = "root"; //usuario root do bd
    //private static final String SENHA = "password"; //senha banco em nuvem
    private static final String SENHA = ""; //senha bd local
    private static final String URL = "jdbc:mysql://localhost:3306/nomeBanco"
            //private static final String URL = "jdbc:mysql://endereco-server-nuvem:3306/nomeBanco"
            + "?useUnicode=yes&"
            + "characterEncoding=UTF-8&"
            + "useTimezone=true&"
            + "serverTimezone=UTC";

    public static final Connection Conectar() throws SQLException {

        java.sql.Connection conexao;

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            throw new SQLException(ex);
        }
        Connection conn = DriverManager.getConnection(URL, LOGIN, SENHA);
        return conn;
    }

    public static void CloseConnection(Connection conn) throws SQLException {

        try {
            if (conn != null) {
                conn.close();
            }

        } catch (Exception ErrorSQL) {
            throw new SQLException(ErrorSQL);
        }
    }

}
