/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;

/**
 *
 * @author samuel
 */
public class Main {
    
    public static void main(String[] args){
        
        String start_url = "";
        int botControl = 1;
        
        Scanner read = new Scanner(System.in);
        
        System.out.println("ESSE É O WEBCRAWLER DE PRODUTOS DA BH GAMES\n");
        
        do{
            System.out.print("ENTRE COM O URL DO PRODUTO A SER PROCURADO: ");
            start_url = read.next();

            Bot bot = new Bot(start_url);

            bot.start();
            
            System.out.println("\nTECLE 0 PARA BUSCAR OUTRO PRODUTO OU TECLE QUALQUER OUTRA TECLA PARA SAIR:");
            botControl = read.nextInt();
        }while(botControl != 0);
        
        
    }
}
