package Classes;

import Classes.Persistencia.ClienteBD;
import static Classes.Persistencia.ConexaoBD.getConexao;
import Classes.Persistencia.ProdutoBD;
import Classes.Persistencia.VendaBD;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Main {
        
    public static void main(String[] args) throws SQLException {
        
        Layout l = new Layout();
        
        int x = 0;
        
        do{
        
            x = l.DesenhaMenu();
            
            if (x == 1) {
              
                getConexao();
                ClienteBD cbd = new ClienteBD();
                Cliente c = new Cliente();
                
                c.setNome(JOptionPane.showInputDialog("Nome: "));
                c.setFone(JOptionPane.showInputDialog("Contato: "));
                
                cbd.adicionaCliente(c);
                
            }
            
            if (x == 2) {
                
                getConexao();
                ProdutoBD pbd = new ProdutoBD();
                Produto p = new Produto();
                
                p.setNome(JOptionPane.showInputDialog("Nome: "));
                p.setPreço(Float.parseFloat(JOptionPane.showInputDialog("Preço: ")));
                
                pbd.adicionaProduto(p);
            }
            
            if (x == 3) {
                getConexao();
                VendaBD vbd = new VendaBD();
                Venda v = new Venda();
                
                v.setData_venda(JOptionPane.showInputDialog("Data da venda: "));
                v.setId_cliente(Integer.parseInt(JOptionPane.showInputDialog("ID do cliente: ")));
                v.setId_produto(Integer.parseInt(JOptionPane.showInputDialog("ID do produto: ")));
                
                vbd.adicionaVenda(v);
            }
            
            
            if (x == 4) {
                
                ClienteBD cbd =  new ClienteBD();
                cbd.mostrarClientes();
                
            }
            
            if (x == 5) {
                
                getConexao();
                ProdutoBD pbd = new ProdutoBD();
                pbd.mostrarProdutos();;
            }
            
            if (x == 6) {
                
                getConexao();
                VendaBD vbd = new VendaBD();
                vbd.mostrarVendas();
                
            }
            
            
        
        }while(x != 0);
    }     
}