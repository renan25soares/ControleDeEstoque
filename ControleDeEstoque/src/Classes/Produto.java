package Classes;

public class Produto {
    
    private String nome;
    private double preço;
    private int id;
    private int qtd;

    public Produto(String nome, double preço, int id, int qtd) {
        this.nome = nome;
        this.preço = preço;
        this.id = id;
        this.qtd = qtd;
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

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
    
}
