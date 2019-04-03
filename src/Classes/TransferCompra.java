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
public class TransferCompra {
    
    private int id_venda;
    private String produto;
    private double preço;
    private String data;

    public TransferCompra(int id_venda, String produto, double preço, String data) {
        this.id_venda = id_venda;
        this.produto = produto;
        this.preço = preço;
        this.data = data;
    }

    public TransferCompra() {
    }

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
      
}
