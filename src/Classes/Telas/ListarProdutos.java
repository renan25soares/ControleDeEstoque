/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Telas;

import Classes.Cliente;
import Classes.Persistencia.ClienteBD;
import Classes.Persistencia.ProdutoBD;
import Classes.Produto;
import java.awt.BorderLayout;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nhdsd
 */
public class ListarProdutos extends JFrame{
    
    private JPanel painelFundo;
    private JTable tabela;
    private JScrollPane barraRolagem;

    private DefaultTableModel modelo = new DefaultTableModel();
 
    public ListarProdutos() throws SQLException {
        super("Produto");
        criaJTable();
        criaJanela();
    }
    
     public void criaJanela() {

        barraRolagem = new JScrollPane(tabela);
        painelFundo = new JPanel();
        painelFundo.setLayout(new BorderLayout());
        painelFundo.add(BorderLayout.CENTER, barraRolagem);
 
        getContentPane().add(painelFundo);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 320);
        setVisible(true);
    }

        private void criaJTable() throws SQLException {
        tabela = new JTable(modelo);
        modelo.addColumn("Id");
        modelo.addColumn("Nome");
        modelo.addColumn("Telefone");
        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(80);
        pesquisar(modelo);
    }
        
        public static void pesquisar(DefaultTableModel modelo) throws SQLException {
        modelo.setNumRows(0);
        ProdutoBD dao = new ProdutoBD();
 
        for (Produto p : dao.getLista()) {
            modelo.addRow(new Object[]{p.getId(), p.getNome(), p.getPreço()});
        }
    }
    
}
