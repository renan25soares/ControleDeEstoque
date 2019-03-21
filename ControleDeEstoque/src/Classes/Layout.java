package Classes;

import javax.swing.JOptionPane;

public class Layout {
    
    public int DesenhaMenu(){
    
        String desenha =  "1 - Cadastrar Cliente\n"
                        + "2 - Cadastrar Produto\n"
                        + "3 - Registrar Venda\n"
                        + "4 - Listar clientes\n"
                        + "5 - Listar Produtos\n"
                        + "6 - Listar vendas\n"
                        + "0 - Sair\n"
                        + "Escolha uma opção: " ;
        int escolheu = Integer.parseInt(JOptionPane.showInputDialog(desenha));
        return escolheu;
        
        
    }
    
}
