/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogobatnaval;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import static jogobatnaval.Tabuleiro.tabuleiro;

/**
 *
 * @author rochel
 */
public class Tabuleiro {
    
   static int altura, largura, qtdNavios, limiteMaxNavios, qtdRestNavios;
   static int tabuleiro [][];
   static Scanner input = new Scanner(System.in);
   static Random aleatorio = new Random();
    
    public static void obterTamanhoDoTab(){       
        for(;;){  //FOR INFINTIO
            boolean ok = false;
            try{
                System.out.println("Digite a altura do tabuleiro:");
                altura = input.nextInt();
                System.out.println("Digite a largura do tabuleiro:");
                largura = input.nextInt();
                ok = true;
            }catch(InputMismatchException erro){ //quando for passado um valor diferente que numero
                System.out.println("Digite um valor numérico:");
            }
            if(ok){
                break;
            }
        }
    }
    
    public static void iniciarTamanhosDoTab(){
        tabuleiro = retornaTabuleiroVazio();
    } 
    
    public static void calcularQtdNavios(){
        limiteMaxNavios = (altura * largura)/2;
    }
    
    public static void obterNumNavios(){
        System.out.println("Digite um valor numérico:");
        System.out.println("Maximo: " + limiteMaxNavios + " navios");
        qtdNavios = input.nextInt();
        if(qtdNavios < 1 || qtdNavios < limiteMaxNavios){
            qtdNavios =  limiteMaxNavios;
        }
    }
    
    public static int[][] retornaTabuleiroVazio(){
        return new int[altura][largura];
    }
    
    public static void inserirNavios(){
        tabuleiro = retornarTabuleiroComNavios();
    }
    
    public static int[][] retornarTabuleiroComNavios(){
        int x = 0, y = 0;
        int novoTab[][] = retornaTabuleiroVazio();
        qtdRestNavios = qtdNavios;
        do{ 
            x = 0;
            y = 0;
            for(int [] linha : novoTab){
                for(int coluna : linha){
                    if(aleatorio.nextInt(100) <= 10){
                        if(coluna == 0){
                            novoTab[x][y] = 1;
                            qtdRestNavios--;
                            break;
                        }
                        if(qtdRestNavios <= 0){
                            break;
                        }
                    }
                    y++;
                }
                y = 0;
                x++;
                if(qtdRestNavios <= 0){
                    break;
                }
            }
        }while(qtdRestNavios > 0);
        
        return novoTab;
    }
    
    
    
    //EXEMPLO TABULEIRO
    
    //| | - |X| - |N|
    //----BATALHA NAVAL----
    //TABULEIRO 5X5
    //   A B C D E
    //1 | | | | | |
    //2 | | | | | |
    //3 | | | | | |
    //4 | | | | | |
    //5 | | | | | |
    //   A B C D E
    
    public static void exibirTabuleiro(){
        System.out.println("----BATALHA NAVAL----\n");
        char letraColuna = 65; //65 é o numero do caracter a
        String letrasTab = "   ";
        for(int i = 0 ; i < largura ; i++){
            letrasTab += (letraColuna++) + " ";
        }
        System.out.println(letrasTab);
        String linhaTab = "";
        int numeroLinha = 1;
        int[][] tab = retornarTabuleiroComNavios();
        for(int [] linha : tab){
            if(numeroLinha < 10){
                linhaTab = (numeroLinha++) + " |";
            }else{
                linhaTab = (numeroLinha++) + "|";
            }
            for(int coluna : linha){
                switch(coluna){ //Verifica estado da coluna
                    case 0: //está vazio ou sem ação
                        linhaTab += " |";
                        break;
                    case 1: //tem navio escondido
                        linhaTab += " |";
                        break;
                    case 2: //erro
                        linhaTab += "X|";
                        break;
                    case 3: //acerto
                        linhaTab += "N|";
                        break;
                }
            }
            System.out.println(linhaTab);
        }
        System.out.println(letrasTab);
    }
    
}



