
package Classes.Telas;

import Classes.Persistencia.TransferVendaBD;
import Classes.TransferVenda;
import java.awt.BorderLayout;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListarVendas extends JFrame{
    
    
    private JPanel painelFundo;
    private JTable tabela;
    private JScrollPane barraRolagem;

    private DefaultTableModel modelo = new DefaultTableModel();
 
    public ListarVendas() throws SQLException {
        super("Venda");
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
        setSize(500, 320);
        setVisible(true);
    }

        private void criaJTable() throws SQLException {
        tabela = new JTable(modelo);
        modelo.addColumn("Id");
        modelo.addColumn("Cliente");
        modelo.addColumn("Produto");
        modelo.addColumn("Data");
        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(80);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(80);
        pesquisar(modelo);

        }
        

        public static void pesquisar(DefaultTableModel modelo) throws SQLException {
            modelo.setNumRows(0);
            
            TransferVendaBD tv = new TransferVendaBD();
            
            for (TransferVenda v : tv.getLista()) {
                 modelo.addRow(new Object[]{v.getId_venda(), (v.getNome_cliente()), (v.getProduto()), (v.getData_venda())});
        }
    }
    }



