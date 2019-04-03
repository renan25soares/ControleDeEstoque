/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Telas;

import Classes.Persistencia.TransferCompraBD;
import Classes.TransferCompra;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nhdsd
 */
public class ListarCompras extends JFrame{
    
    private JPanel painelFundo;
    private JTable tabela;
    private JScrollPane barraRolagem;
    private JTextField pesquisa;

    private DefaultTableModel modelo = new DefaultTableModel();
 
    public ListarCompras() throws SQLException {
        super("Compras");
        criaJTable();
        criaJanela();
    }
    
     public void criaJanela() {

        barraRolagem = new JScrollPane(tabela);
        painelFundo = new JPanel();
        painelFundo.setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        painelFundo.add(BorderLayout.CENTER, barraRolagem);
        
        getContentPane().add(painelFundo);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(650, 300);
        setSize(600, 400);
        setVisible(true);
    }

        private void criaJTable() throws SQLException {
        tabela = new JTable(modelo);
        modelo.addColumn("Id");
        modelo.addColumn("Produto");
        modelo.addColumn("Preço");
        modelo.addColumn("Data");
        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(80);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(80);
        pesquisar(modelo);

        }
        

        public void pesquisar(DefaultTableModel modelo) throws SQLException {
            modelo.setNumRows(0);
            
            List<TransferCompra> tc = new ArrayList<>();
            
            TransferCompraBD bd = new TransferCompraBD();
            
            tc = bd.getLista(nome);
            
            for (TransferCompra c : tc) {
                 modelo.addRow(new Object[]{c.getId_venda(), (c.getProduto()), (c.getPreço()), (c.getData())});
        }
    }
            
        String nome = JOptionPane.showInputDialog("Nome do cliente: ");
    
}
