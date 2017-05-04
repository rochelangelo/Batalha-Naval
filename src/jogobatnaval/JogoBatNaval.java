/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogobatnaval;

import java.util.Random;
import java.util.Scanner;
import static jogobatnaval.Tabuleiro.input;

/**
 *
 * @author rochel
 */
public class JogoBatNaval {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tabuleiro.obterTamanhoDoTab();
        Tabuleiro.calcularQtdNavios();
        Tabuleiro.iniciarTamanhosDoTab();
        Tabuleiro.obterNumNavios();
        Tabuleiro.retornarTabuleiroComNavios();
        Tabuleiro.inserirNavios();
        Tabuleiro.exibirTabuleiro();
        
        input.close();
    }
    
}
