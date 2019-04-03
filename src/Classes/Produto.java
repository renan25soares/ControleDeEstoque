package Classes;

public class Produto {
    
    private String nome;
    private double preço;
    private int id;
    private int quantidade;

    public Produto(String nome, double preço, int id, int quantidade) {
        this.nome = nome;
        this.preço = preço;
        this.id = id;
        this.quantidade = quantidade;
    }

    public Produto() {
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
 
}
