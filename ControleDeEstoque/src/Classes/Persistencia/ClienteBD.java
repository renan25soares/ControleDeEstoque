package Classes.Persistencia;

import Classes.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteBD {
    
    
    private Connection conexao;
    
    // Estabelece uma conexão
    public ClienteBD() throws SQLException {       
        this.conexao = ConexaoBD.getConexao();
    }
        
        
    
        public void adicionaCliente(Cliente c) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "INSERT INTO cliente(nome, fone)"
                + "VALUES(?, ?)";       
        PreparedStatement stmt;
        // stmt recebe o comando SQL
        stmt = this.conexao.prepareStatement(sql);
        
        // Seta os valores p/ o stmt, substituindo os "?"
        stmt.setString(1, c.getNome());
        stmt.setString(2, c.getFone());
        
        // O stmt executa o comando SQL no BD, e fecha a conexão
        stmt.execute();
        stmt.close();
        
    }
        
        
        public void mostrarClientes() throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT * FROM cliente";       
        PreparedStatement stmt;
        // stmt recebe o comando SQL
        stmt = this.conexao.prepareStatement(sql);
        
        // Seta os valores p/ o stmt, substituindo os "?"
        
        // O stmt executa o comando SQL no BD, e fecha a conexão
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            System.out.println("ID:" + rs.getInt("id_cliente") +" - Nome:"+ rs.getString("nome")+" - Fone:"+ rs.getString("fone"));
        }
        stmt.close();
        
    }    

        
        
}
