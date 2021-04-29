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

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public float getPreco() {
        return preco;
    }
    
}
