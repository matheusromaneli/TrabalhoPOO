package br.uff.ic.poo.restaurante.Mesa;

import br.uff.ic.poo.restaurante.Pedido.Pedido;
import java.util.ArrayList;

public class Mesa {
    
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    private boolean disponivel = true;
    private int numMesa;
    
    public void fazerPedido(Pedido p){
        pedidos.add(p);
    }
    public void removerPedido(){
        pedidos.remove(pedidos.size()-1);
    }
    
    public float calcularTotal(){
        float total = 0;
        for(int i=0;i < pedidos.size(); i++){
            total += pedidos.get(i).calculaSubTotal();
        }
        return total;
    }

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

}
