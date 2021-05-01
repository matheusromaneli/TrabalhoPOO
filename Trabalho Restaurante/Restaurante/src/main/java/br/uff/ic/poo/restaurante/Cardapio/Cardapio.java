package br.uff.ic.poo.restaurante.Cardapio;

import br.uff.ic.poo.restaurante.Item.Item;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Cardapio {   
    
    Scanner Teclado = new Scanner(System.in);
    
    public void SalvarItem(){
        File arquivo = new File("src\\main\\java\\br\\uff\\ic\\poo\\restaurante\\Cardapio\\cardapio.txt");
        try{
            if (!arquivo.exists()) {
                //cria arquivo vazio
                arquivo.createNewFile();
                
                try (FileWriter fw = new FileWriter(arquivo, true); BufferedWriter bw = new BufferedWriter(fw)) {
                    
                    boolean continua;
                    continua = true;
                    while (continua){
                        System.out.println("Insira o nome do item a ser inserido");
                        Item novo = new Item();
                        bw.write(novo.getId()+ " " + novo.getNome()+ " " +  + novo.getPreco());
                        bw.newLine();
                        System.out.println("Deseja salvar mais um item?");
                        String op = Teclado.nextLine();
                        if (("N".equals(op)) || ("n".equals(op))){
                            continua = false;
                        }   
                    }
                }                  
            }else{
                boolean continua;
                continua = true;                
                while (continua){
                    //arquivo já contem dados
                    String nome = Teclado.nextLine();

                    FileReader fr = new FileReader(arquivo);
                    BufferedReader br = new BufferedReader(fr);
                    boolean existe;
                    existe = false;
                    while (br.ready()) {
                        //lê a linha
                        String linha = br.readLine();
                        //verifica se item já encontra no arquivo
                        String palavras[] = linha.split(" ");
                        if (palavras[1].equals(nome)){
                            existe = true;                       
                        }                                                             
                    }

                    if (!existe){
                        try (FileWriter fw = new FileWriter(arquivo, true); BufferedWriter bw = new BufferedWriter(fw)) {
                            //caso não exista salvar novo item
                            Item novo = new Item(nome);
                            bw.write(novo.getId()+ " " + novo.getNome()+ " " +  + novo.getPreco());                           
                            bw.newLine();
                            
                        }                    
                    }else{
                        System.out.println("Item já se encontra no cardapio");
                    }
                    System.out.println("Deseja salvar mais um item?");
                    String op = Teclado.nextLine();
                    if (("N".equals(op)) || ("n".equals(op))){
                        continua = false;
                    }        
                }                              
            }                
        }catch (IOException ex) {
        }
        
    }
    
    public void imprimeCardapio(){
        File arquivo = new File("src\\main\\java\\br\\uff\\ic\\poo\\restaurante\\Cardapio\\cardapio.txt");
        try{
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                        //lê a linha
                        String linha = br.readLine();
                        //verifica se item já encontra no arquivo
                        String palavras[] = linha.split(" ");
                        System.out.println("ID:"+palavras[0]+ " Item: " + palavras[1]+ " R$" + palavras[2]);                                                                              
                    }
            
        }catch (IOException ex) {
        }
        
    }
      

}
