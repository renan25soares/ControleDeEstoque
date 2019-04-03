/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Telas;

import Classes.Cliente;
import Classes.Persistencia.ClienteBD;
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

/**
 *
 * @author nhdsd
 */
public class ListarClientes extends JFrame{
    

    private JPanel painelFundo;
    private JTable tabela;
    private JScrollPane barraRolagem;
    private JButton excluir;

    private DefaultTableModel modelo = new DefaultTableModel();
 
    public ListarClientes() throws SQLException {
        super("Cliente");
        criaJTable();
        criaJanela();
        setLocationRelativeTo( null );
        setResizable(false);
    }
    
     public void criaJanela() {
         
        barraRolagem = new JScrollPane(tabela);
        painelFundo = new JPanel();
        painelFundo.setLayout(new BorderLayout());
        painelFundo.add(BorderLayout.CENTER, barraRolagem);
        excluir = classeJButton();
        getContentPane().add(excluir);
        
 
        getContentPane().add(painelFundo);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 400);
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
        ClienteBD dao = new ClienteBD();
 
        for (Cliente c : dao.getLista()) {
            modelo.addRow(new Object[]{c.getId(), c.getNome(), c.getFone()});
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
                ClienteBD c = new ClienteBD();
                c.remove(pegaIdCliente());

                JOptionPane.showMessageDialog(rootPane, "Registro excluido com sucesso.");
                JOptionPane.showMessageDialog(rootPane, "Feche a página para atualizar os dados.");
                                                
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Cliente não selecionado.");
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

