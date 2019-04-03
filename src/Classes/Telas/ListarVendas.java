
package Classes.Telas;

import Classes.Persistencia.ClienteBD;
import Classes.Persistencia.TransferVendaBD;
import Classes.Persistencia.VendaBD;
import Classes.TransferVenda;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
        setLocationRelativeTo( null );
        setResizable(false);

    }
    
     public void criaJanela() {

        barraRolagem = new JScrollPane(tabela);
        painelFundo = new JPanel();
        painelFundo.setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        painelFundo.add(BorderLayout.CENTER, barraRolagem);
        JButton excluir = classeJButton();
        getContentPane().add(excluir);
        
        getContentPane().add(painelFundo);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(650, 300);
        setSize(600, 400);
        setVisible(true);
    }

        private void criaJTable() throws SQLException {
        tabela = new JTable(modelo);
        modelo.addColumn("Id");
        modelo.addColumn("Cliente");
        modelo.addColumn("Produto");
        modelo.addColumn("Data");
        modelo.addColumn("Quantidade");
        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(80);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(80);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(80);
        pesquisar(modelo);

        }
        

        public static void pesquisar(DefaultTableModel modelo) throws SQLException {
            modelo.setNumRows(0);
            
            TransferVendaBD tv = new TransferVendaBD();
            
            for (TransferVenda v : tv.getLista()) {
                 modelo.addRow(new Object[]{v.getId_venda(), (v.getNome_cliente()), (v.getProduto()), (v.getData_venda()), v.getQuantidade()});
        }
    }
            
    private void excluirRegistro() throws SQLException {
        // Se algum registro estiver selecionado
        if (tabela.getSelectedRow() != -1) {
            // Exibe uma janela de confirmação antes de exluir o registro
            int resp = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir este registro?",
                    "Confirmação!", JOptionPane.YES_NO_OPTION);

            // Se a confirmação for SIM
            if (resp == JOptionPane.YES_NO_OPTION) {
                // Remove o registro, usando como parâmetro, o id da linha selecionada                
                VendaBD v = new VendaBD();
                v.remove(pegaIdCliente());

                JOptionPane.showMessageDialog(rootPane, "Registro excluido com sucesso.");
                JOptionPane.showMessageDialog(rootPane, "Feche a página para atualizar os dados.");
                                                
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Venda não selecionado.");
        }
    }
    
        private int pegaIdCliente() {        
        int id_Cliente = 0;
        
        if (tabela.getSelectedRow() != -1) {           
            // Salva a posição da linha selecionada na tabela de pesquisa
            int linhaSelecionada = tabela.getSelectedRow();
            
            id_Cliente = (int) tabela.getValueAt(linhaSelecionada, 0);
        }       
        return id_Cliente;
    }
        
        public JButton classeJButton(){

	JButton excluir = new JButton();
	excluir.setText("Excluir");
	excluir.setSize(100,25);
	excluir.setLocation(450,300);
	excluir.setEnabled(true);
        
        
        excluir.addActionListener( new ActionListener() { public void actionPerformed(ActionEvent e) { 
            try {
                excluirRegistro();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Registro não pode ser exluído");
            }
        } });
        
        return excluir;
        }
        
        
    }



