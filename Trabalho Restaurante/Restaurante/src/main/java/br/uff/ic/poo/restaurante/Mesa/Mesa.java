package br.uff.ic.poo.restaurante.Mesa;

import br.uff.ic.poo.restaurante.Pedido.Pedido;
import java.util.ArrayList;

public class Mesa {
    
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    private boolean disponivel = true;
    private int numMesa;
    
    public void ocupada(){
        this.disponivel = false;
    }
    
    public void fazerPedido(Pedido p){
        pedidos.add(p);
    }
    public void removerPedido(){
        pedidos.remove(pedidos.size()-1);
    }
    
    public float fechaMesa(){
        this.disponivel = true;
        return calcularTotal();
    }
    
    private float calcularTotal(){
        float total = 0;
        for(int i=0;i < pedidos.size(); i++){
            total += pedidos.get(i).calculaSubTotal();
        }

        return total;
    }
<<<<<<< HEAD
    
    
=======

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

>>>>>>> a7475692d0202c6cb9bf0c65842606b329999aa8
}
