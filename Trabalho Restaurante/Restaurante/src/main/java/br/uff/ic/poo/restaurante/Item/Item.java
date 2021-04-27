package br.uff.ic.poo.restaurante.Item;

public class Item {
    
    private String nome;
    private int id;
    private float preco;
    
    public Item(String nome, int id, float preco){
        this.nome = nome;
        this.id = id;
        this.preco = preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    
}
