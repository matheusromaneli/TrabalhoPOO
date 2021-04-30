package br.uff.ic.poo.restaurante.Main;

import br.uff.ic.poo.restaurante.Cardapio.Cardapio;

public class main {
    public static void main(String[]args){
        
        Cardapio cardapioAtual = new Cardapio();
        cardapioAtual.imprimeCardapio();
        cardapioAtual.SalvarItem();
        cardapioAtual.imprimeCardapio();
        
        
        
    }   
    
}