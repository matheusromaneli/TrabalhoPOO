package br.uff.ic.poo.restaurante.Main;

import br.uff.ic.poo.restaurante.Item.Item;
import br.uff.ic.poo.restaurante.Mesa.Mesa;
import br.uff.ic.poo.restaurante.Pedido.Pedido;
import br.uff.ic.poo.restaurante.Restaurante.Restaurante;
import java.util.ArrayList;

import br.uff.ic.poo.restaurante.Cardapio.Cardapio;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        
        System.out.println("\n........... Restaurant System Mega Super Pro Version 1.0.28.45 Fall 2021 ...........");

        int escolha_menu_principal = -1;
        
        while(escolha_menu_principal != 0){

            System.out.println("\nMenu principal: ");
            System.out.println("1. Administrar cardápio.");
            System.out.println("2. Iniciar funcionamento.");
            System.out.println("0. Encerrar programa.\n");

            escolha_menu_principal = teclado.nextInt();
            
            switch(escolha_menu_principal){
                case 1:
                    int escolha_menu_secundario1 = -1;

                    while(escolha_menu_secundario1 != 0){

                        System.out.println("\nAdministrar Cardápio: ");
                        System.out.println("1. Imprimir cardápio.");
                        System.out.println("2. Adicionar prato.");
                        System.out.println("3. Remover prato.");
                        System.out.println("0. Voltar ao menu anterior.\n");

                        escolha_menu_secundario1 = teclado.nextInt();

                        // instanciar cardápio

                        switch(escolha_menu_secundario1){
                            case 1:
                                // chamar método para imprimir o cardápio
                                break;
                            case 2:
                                // chamar método para adicionar prato ao cardápio
                                break;
                            case 3:
                                // chamar método para remover prato do cardápio
                                break;
                            case 0:
                                escolha_menu_secundario1 = 0;
                                break;
                            default:
                                System.out.println("\nOpção inválida. Escolha uma opção válida.");
                                break;
                        }
                    }
                    break;
                case 2:
                    Restaurante restaurante = new Restaurante(10);
                    System.out.println("\nRestaurante em funcionamento.");
                    
                    int escolha_menu_secundario2 = -1;

                    while(escolha_menu_secundario2 != 0){

                        System.out.println("\nAdministrar salão: ");
                        System.out.println("1. Abrir conta para mesa.");
                        System.out.println("2. Fazer pedido para mesa.");
                        System.out.println("3. Fechar conta para mesa.");
                        System.out.println("4. Fazer pagamento de uma conta.");
                        System.out.println("5. Chama proximo da fila");
                        System.out.println("0. Voltar ao menu anterior.\n");

                        escolha_menu_secundario2 = teclado.nextInt();

                        switch(escolha_menu_secundario2){
                            case 1:
                                // instanciar uma mesa, adicioná-la às mesas existentes e abrir lista de pedidos para ela
                                ArrayList<Integer> disponiveis = restaurante.encontraMesaDisponivel();
                                if(disponiveis.size()>0){
                                    System.out.println("Possuem as seguintes mesas livres:\n"+disponiveis + "\n Qual deseja?");
                                    int k = -1;
                                    while(!disponiveis.contains(k)){
                                        k = Integer.parseInt(teclado.nextLine());
                                    }
                                    restaurante.ocupar(k);
                                }
                                else{
                                    System.out.println("Nao possui mesa disponível, favor aguardar\nInsira seu nome para entrar na lista de espera (n para sair):");
                                    restaurante.entrarNaFila(teclado.nextLine());
                                }
                                
                                break;
                            case 2:
                                // chamar método para fazer pedido para uma mesa
                                System.out.print("Insira o numero da mesa: ");
                                int num = Integer.parseInt(teclado.nextLine());
                                Pedido pedido = new Pedido();
                                while(true){
                                    System.out.println("Insira o nome do item e a quantidade:(Enter para sair)");
                                    String info = teclado.nextLine();
                                    if(!info.contains(" ")){
                                        break;
                                    }
                                    String [] infos = info.split(" ");
                                    //validar nome do item
                                    Item a = new Item(infos[0]);
                                    pedido.adicionaItem(a,Integer.parseInt(infos[1]));
                                }
                                
                                restaurante.getMesa(num).fazerPedido(pedido);
                                break;
                            case 3:
                                // fechar conta para uma mesa e apresentar valor total
                                System.out.print("Insira o numero da mesa: ");
                                num = Integer.parseInt(teclado.nextLine());
                                System.out.println("A conta da mesa "+num+" deu R$"+restaurante.getMesa(num).fechaMesa());
                                break;
                            case 4:
                                // apresentar formas de pagamento e receber pagamento (adicionar ao caixa do dia)
                                break;
                            case 5:
                                // administrar a fila
                                restaurante.chamaProx();
                                disponiveis = restaurante.encontraMesaDisponivel();
                                if(disponiveis.size()>0){
                                    System.out.println("Possuem as seguintes mesas livres:\n"+disponiveis + "\n Qual deseja?");
                                }
                                break;
                            case 0:
                                escolha_menu_secundario2 = 0;
                                break;
                            default:
                                System.out.println("\nOpção inválida. Escolha uma opção válida.");
                                break;
                        }
                    }
                    break;
                case 0:
                    
                    int sair_do_programa = -1;
                    
                    while(sair_do_programa != 0 && sair_do_programa != 1){
                        
                        System.out.println("\nVocê deseja encerrar o programa?");
                        System.out.println("1. Sim.");
                        System.out.println("0. Não.\n");
                        
                        sair_do_programa = teclado.nextInt();
                        
                        if(sair_do_programa != 0 && sair_do_programa != 1){
                            System.out.println("\nOpção inválida. Escolha uma opção válida.");
                        }
                    }
                    if(sair_do_programa == 0){
                        escolha_menu_principal = -1;
                    }else{
                        System.out.print("\nEncerrando programa");
                        try{
                            Thread.sleep(800);
                        }
                        catch(InterruptedException ex){
                            Thread.currentThread().interrupt();
                        }
                        System.out.print(".");
                        try{
                            Thread.sleep(800);
                        }
                        catch(InterruptedException ex){
                            Thread.currentThread().interrupt();
                        }
                        System.out.print(".");
                        try{
                            Thread.sleep(800);
                        }
                        catch(InterruptedException ex){
                            Thread.currentThread().interrupt();
                        }
                        System.out.println(".");
                        try{
                            Thread.sleep(400);
                        }
                        catch(InterruptedException ex){
                            Thread.currentThread().interrupt();
                        }
                    }
                    break;
                default:
                    System.out.println("\nOpção inválida. Escolha uma opção válida.");
                    break;
            }
            
        }
        
        System.out.println("\nPrograma encerrado.");
    }
    
}
