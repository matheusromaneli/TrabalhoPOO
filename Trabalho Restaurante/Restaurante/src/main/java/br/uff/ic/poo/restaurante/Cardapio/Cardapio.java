package br.uff.ic.poo.restaurante.Cardapio;

import br.uff.ic.poo.restaurante.Item.Item;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.util.Scanner;

public class Cardapio {   
    
    Scanner Teclado = new Scanner(System.in);
    private int ocupado; //ocupado = 0 (LIVRE)  ocupado = 1 (OCUPADO)
    
    public void SalvarItem() throws FileNotFoundException{
        File arquivo = new File("src\\main\\java\\br\\uff\\ic\\poo\\restaurante\\Cardapio\\cardapio.dat");
        try{
            if (!arquivo.exists()) {
                //cria arquivo vazio
                arquivo.createNewFile();
                
                try (FileOutputStream arqWrite = new FileOutputStream(arquivo)) {
                    DataOutputStream gravarArq = new DataOutputStream(arqWrite);
                    
                    boolean continua;
                    continua = true;
                    while (continua){
                        Item novo = new Item();
                        this.ocupado = 1;
                        gravarArq.writeUTF(novo.getId()+ ";" + novo.getNome()+ ";" +  + novo.getPreco() + ";" + this.ocupado + "\n");
                        System.out.println("Deseja salvar mais um item?");
                        String op = Teclado.nextLine();
                        if (("N".equals(op)) || ("n".equals(op))){
                            continua = false;
                        }   
                    }
                    arqWrite.close();
                }
            }else{
                boolean continua;
                continua = true;  
                try (FileInputStream arqLeitura = new FileInputStream(arquivo)) {
                    DataInputStream lerArq = new DataInputStream(arqLeitura);
                    while (continua){
                        //arquivo já contem dados
                        System.out.println("\nInsira o nome do item a ser inserido");
                        String nome = Teclado.nextLine();                     
                        
                        boolean existe;
                        existe = false;
                        int cont = 0;
                        int tam = 0;
                        while (arqLeitura.available() > 0) {
                            //lê a linha
                            String linha = lerArq.readUTF();
                            //verifica se item já encontra no arquivo
                            String palavras[] = new String[4];
                            palavras = linha.split(";");
                            if (palavras[1].equals(nome)){
                                existe = true;
                                tam = palavras[1].length();                                
                            }
                            cont++;
                        }
                        arqLeitura.close();
                        if (!existe){
                            //caso não exista salvar novo item
                            RandomAccessFile raf = new RandomAccessFile(arquivo,"rw");                        
                            Item novo = new Item(nome);
                            this.ocupado = 1;
                            raf.seek(cont*(Integer.SIZE + (Character.SIZE * (tam+3)) + Float.SIZE + Integer.SIZE));
                            raf.writeUTF(novo.getId()+ ";" + novo.getNome()+ ";" +  + novo.getPreco() + ";" + this.ocupado + "\n");
                            raf.close();
                        }else{
                            System.out.println("\nItem já se encontra no cardapio");
                        }
                        System.out.println("Deseja salvar mais um item?");
                        String op = Teclado.nextLine();
                        if (("N".equals(op)) || ("n".equals(op))){
                            continua = false;
                        }
                    }
                }
            }                
        }catch (IOException ex) {
        }
        
    }
    
    public void imprimeCardapio() throws FileNotFoundException, IOException{
        File arquivo = new File("src\\main\\java\\br\\uff\\ic\\poo\\restaurante\\Cardapio\\cardapio.dat");
        
        try (FileInputStream arqLeitura = new FileInputStream(arquivo)) {
            DataInputStream lerArq = new DataInputStream(arqLeitura);

            while (arqLeitura.available() != 0){
                //lê a linha
                String linha = lerArq.readUTF();
                //verifica se item já encontra no arquivo
                String palavras[] = new String[4];
                palavras = linha.split(";");
                //palavras[3] é a flag de controle(ocupado)
                if ("1".equals(palavras[3])){
                    System.out.println("ID:" + palavras[0] + " Item:" + palavras[1] + " R$" + palavras[2]);
                }                                                                                                      
            }
        }
        
       
    }
    
    public void apagaItem() throws FileNotFoundException, IOException{        
        File arquivo = new File("src\\main\\java\\br\\uff\\ic\\poo\\restaurante\\Cardapio\\cardapio.dat");

        try (FileInputStream arqLeitura = new FileInputStream(arquivo)) {
            DataInputStream lerArq = new DataInputStream(arqLeitura);

            //arquivo já contem dados
            System.out.println("\nInsira o nome do item a ser excluido");
            String nome = Teclado.nextLine();                     

            int pos, cont, tam;
            tam = 0;
            cont = 0;
            pos = -1;
            int idExcluida = -1;
            float precoExcluido = -1; 
            
            
            while ((arqLeitura.available() != 0)||(pos < 0)) {
                //lê a linha
                String linha = lerArq.readUTF();                
                //verifica se item já encontra no arquivo
                String palavras[] = linha.split(";");
                if (palavras[1].equals(nome)){
                    pos = cont;
                    tam = palavras[1].length();
                    idExcluida = parseInt(palavras[0]);
                    precoExcluido = parseFloat(palavras[2]);                    
                }
                cont++;
            }
            arqLeitura.close();
            try (RandomAccessFile raf = new RandomAccessFile(arquivo,"rw")) {
                if (pos != -1){
                    //salvar no arquivo nessa pos*tamanho de cada linha
                    pos = pos*(Integer.SIZE + (Character.SIZE * (tam+3)) + Float.SIZE + Integer.SIZE);
                    raf.seek(pos);
                    this.ocupado = 0;
                    raf.writeUTF(idExcluida + ";" + nome + ";" + precoExcluido + ";" + this.ocupado + "\n");
                    System.out.println(nome + " foi excluido do cardapio");
                }else{
                    System.out.println(nome + " não se encontra no cardapio");
                }
                raf.close();
            }
        }        
    }         
}
