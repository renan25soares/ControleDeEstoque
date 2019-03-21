package Classes.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
        
        public static Connection getConexao() throws SQLException {
        
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            System.out.println("Conectando ao banco de dados.");
            return DriverManager.getConnection("jdbc:hsqldb:C:\\Users\\nhdsd\\OneDrive\\Área de Trabalho\\bd\\estoque", "SA", "");
        } catch (ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }   
        
    }
        
        
        
}
