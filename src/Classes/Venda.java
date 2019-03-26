package Classes;

public class Venda {
    
    private int id;
    private int id_cliente;
    private int id_produto;
    private String data_venda;

    public Venda(int id, int id_cliente, int id_produto, String data_venda) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.id_produto = id_produto;
        this.data_venda = data_venda;
    }

    public Venda() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getData_venda() {
        return data_venda;
    }

    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }

        

}

