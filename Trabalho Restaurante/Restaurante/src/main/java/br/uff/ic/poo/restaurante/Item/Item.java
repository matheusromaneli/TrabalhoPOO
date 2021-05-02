package br.uff.ic.poo.restaurante.Item;

import java.util.Scanner;

public class Item {

    private String nome;
    private int id;
    private float preco;

    Scanner Teclado = new Scanner(System.in);

    public Item(){
        System.out.println("\nInsira o nome do item");
        String nomeRecebido = Teclado.nextLine();
        this.nome = nomeRecebido;

        System.out.println("\nInsira o id do item");
        String aux = Teclado.nextLine();
        int idRecebido = Integer.parseInt(aux);
        this.id = idRecebido;

        System.out.println("\nInsira o preço do item");
        aux = Teclado.nextLine();
        float precoRecebido = Float.parseFloat(aux);
        this.preco = precoRecebido;
    }

    public Item(String nomeRecebido){
        this.nome = nomeRecebido;

        System.out.println("\nInsira o id do item");
        String aux = Teclado.nextLine();
        int idRecebido = Integer.parseInt(aux);
        this.id = idRecebido;

        System.out.println("\nInsira o preço do item");
        aux = Teclado.nextLine();
        float precoRecebido = Float.parseFloat(aux);
        this.preco = precoRecebido;
    }

    public Item(int id, String nome , float preco){
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