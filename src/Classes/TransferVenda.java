/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author nhdsd
 */
public class TransferVenda {
    
    private int id_venda;
    private String nome_cliente;
    private String produto;
    private String data_venda;
    private int quantidade;

    public TransferVenda(int id_venda, String nome_cliente, String produto, String data_venda, int quantidade) {
        this.id_venda = id_venda;
        this.nome_cliente = nome_cliente;
        this.produto = produto;
        this.data_venda = data_venda;
        this.quantidade = quantidade;
    }

    public TransferVenda() {
    }

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getData_venda() {
        return data_venda;
    }

    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}
