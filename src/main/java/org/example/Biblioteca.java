package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Biblioteca {

    //Listas para guardar dados na biblioteca

    List<Livro> livros = new ArrayList<>();
    List<Autor> autores = new ArrayList<>();
    List<Emprestimo> emprestimos = new ArrayList<>();

    // Métodos da Biblioteca

    public void registrarLivro(){
        Scanner read = new Scanner(System.in);
        Random random = new Random();

        // Registro das Informações:

        // Livro:
        Livro l = new Livro();
        Autor a = new Autor();
        System.out.print("Insira o titulo do livro: ");
        String titulo = read.nextLine();
        int idLivro = random.nextInt(9999) + 1000;
        l.setTitulo(titulo);
        l.setId(idLivro);
        l.setDisponível(true);

        // Autor:
        System.out.print("Insira o Autor do livro: ");
        String nomeAutor = read.nextLine();
        a.setNome(nomeAutor);
        int idAutor = random.nextInt(9999) + 1000;
        a.setId(idAutor);
        l.setAutor(a);

        // Registro do livro e autor na lista:

        livros.add(l);
        autores.add(a);

        // Registrar no banco de dados

        int autor_id = new AutoresDAO().cadastrarAutor(a);         //Aqui é feita a conexão do id do autor para a tabela livros
        new LivrosDao().cadastrarLivro(l, autor_id);

        //Mensagem ao usuário

        System.out.println("Livro Adicionado!");
        System.out.println("--------------------------------------");

    }

    // Método para remover Livro da Biblioteca

    public void removerLivro(){
        Scanner read = new Scanner(System.in);

        mostrarListas();
        System.out.println("Selecione o ID do livro para a remoção: ");
        int id = read.nextInt();
        read.nextLine();
        for (int c = 0; c < livros.size(); c++){
            if (id == livros.get(c).getId()){
                System.out.println("O livro " + livros.get(c).getTitulo()
                + " foi removido da biblioteca. ");
                livros.remove(c);
                System.out.println("-----------------------------------------");
            }

        }

    }

    // Método para adicionar 3 livros padrões no estoque de livro

    public void livrosPadrao(){

        Random random = new Random();

        //Livros
        Livro l1 = new Livro();
        Livro l2 = new Livro();
        Livro l3 = new Livro();

        //Autores
        Autor a1 = new Autor();
        Autor a2 = new Autor();
        Autor a3 = new Autor();

        //Informações
        l1.setTitulo("Margens de Ouro");
        a1.setNome("Elisabeth Cooper");
        l1.setId(8276);
        a1.setId(7539);
        l1.setAutor(a1);
        l1.setDisponível(true);

        l2.setTitulo("A Arte da Trapaçeira");
        l2.setId(3381);
        a2.setId(8311);
        a2.setNome("Nicolas Seth");
        l2.setAutor(a2);
        l2.setDisponível(true);

        l3.setTitulo("Rebelde Amaldiçoada");
        l3.setId(9918);
        a3.setId(8641);
        a3.setNome("Allan Fawler");
        l3.setAutor(a3);
        l3.setDisponível(true);

        //Inserir na Lista

        livros.add(l1);
        livros.add(l2);
        livros.add(l3);

        autores.add(a1);
        autores.add(a2);
        autores.add(a3);
    }

    // Método para gerar lista de Livros ao usuário

    public void mostrarListas(){

        System.out.printf("%-25s %-25s %-10s %-15s%n", "LIVROS", "AUTORES", "ID", "STATUS");

        for (int c = 0; c < livros.size(); c++) {
            System.out.printf("%-25s %-25s %-10d %-15s%n",
                    livros.get(c).getTitulo(),
                    autores.get(c).getNome(),
                    livros.get(c).getId(),
                    livros.get(c).disponibilidade()
            );
        }




    }

    // Método Para mostrar mensagens ao usuário

    public void interações(int n){

       if (n == 0){
           System.out.println("----------BIBLIOTECA-------------");
       } else if (n == 1){
           System.out.print("OPÇÃO: ");
       } else if ( n == 2) {
           System.out.print("Deseja acessar o menu novamente? ");
       }

    }

    public void fazerEmprestimo(){
        Scanner read = new Scanner(System.in);
        Random random = new Random();

        // Seleção de ID do livro
        mostrarListas();
        System.out.print("Selecione o ID do livro para realizar o empréstimo: ");
        int id = read.nextInt();

        // Criando objeto de empréstimo
        Emprestimo emprestimo = new Emprestimo();

        // Estrutura for para selecionar livro para o empréstimo
        for (int c = 0; c < livros.size(); c++){
            if (id == livros.get(c).getId()){
                System.out.println("---------------------------------------------------");
                System.out.println("Você selecionou o livro " + livros.get(c).getTitulo()
                + " do autor " + autores.get(c).getNome());
                System.out.println("----------------------------------------------------");
                emprestimo.realizarEmprestimo(livros.get(c));
                emprestimo.setId(random.nextInt(9999) + 1000);
                emprestimos.add(emprestimo);
                new EmprestimosDAO().cadastrarEmprestimo(emprestimo);

                break;
            }
        }

    }

    // Método para mostrar Lista de empréstimos

    public void listaEmprestimos(){

        System.out.println("-----------------Histórico de empréstimos-------------------");
        System.out.printf("%-25s %-25s %-25s %-10s%n",
                "NOME CLIENTE", "DATA DO EMPRESTIMO", "DATA DEVOLUÇÃO", "ID");

        for (int c = 0; c < emprestimos.size(); c++) {
            System.out.printf("%-25s %-25s %-25s %-10d%n",
                    emprestimos.get(c).getNomeCliente(),
                    emprestimos.get(c).getDataEmpréstimo(),
                    emprestimos.get(c).getDataDevolução(),
                    emprestimos.get(c).getId()
            );
        }
        System.out.println("--------------------------------------------------------------");
    }


    // Método para disponibilizar o MENU

    public void menu(){

        System.out.println("-------------SELECIONE A AÇÃO DESEJADA----------------");
        System.out.println("[1] = Verificar lista de livros ");
        System.out.println("[2] = Adicionar Livro á Lista   ");
        System.out.println("[3] = Remover Livro da Lista    ");
        System.out.println("[4] = Realizar novo empréstimo  ");
        System.out.println("[5] = Verificar histórico de empréstimos");
        System.out.println("[6] = Sair");
        System.out.println("-------------------------------------------------------");
    }

}


