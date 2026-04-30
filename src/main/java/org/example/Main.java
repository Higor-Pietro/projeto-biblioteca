package org.example;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.livrosPadrao();                 // Método para Adicionar 3 livros padrões da biblioteca
        String resposta;

        biblioteca.interações(0);               // Método utilizado para comunicação com o usuário

        do{
            biblioteca.menu();
            biblioteca.interações(1);
            int escolhaMenu = read.nextInt();
            read.nextLine();
            switch (escolhaMenu) {
                case 1:
                    biblioteca.mostrarListas();
                    break;
                case 2:
                    biblioteca.registrarLivro();
                    break;
                case 3:
                    biblioteca.removerLivro();
                    break;
                case 4:
                    biblioteca.fazerEmprestimo();
                    break;
                case 5:
                    biblioteca.listaEmprestimos();
                    break;
                case 6:
                    biblioteca.cancelarEmprestimo();
                    break;
                case 7:
                    break;
            }

            biblioteca.interações(2);
            resposta = read.nextLine();


        } while ("SIM".equalsIgnoreCase(resposta));
    }

}
