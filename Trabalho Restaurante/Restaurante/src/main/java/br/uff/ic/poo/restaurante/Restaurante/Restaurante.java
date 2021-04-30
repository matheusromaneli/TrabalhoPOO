package br.uff.ic.poo.restaurante.Restaurante;

import br.uff.ic.poo.restaurante.Cliente.Cliente;
import br.uff.ic.poo.restaurante.Mesa.Mesa;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Restaurante {
    
    Queue<Cliente> fila = new LinkedList();
    ArrayList<Mesa> mesas = new ArrayList();
    
    public void entrarNaFila(Cliente atual){
        fila.add(atual);
    }
    
    public void esvaziaFila(){
        fila.clear();
    }
    
    public void encontraMesaDisponivel(){
        int i = 0;        
        while (mesas.get(i).isDisponivel() != true){
            i++;
        }
        if (mesas.get(i).isDisponivel() == true){
            System.out.println("O cliente " + fila.element().getNome() + "irá ser atendido na mesa " + mesas.get(i).getNumMesa() );
            fila.remove();            
        }
    }    

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }   
    
}
