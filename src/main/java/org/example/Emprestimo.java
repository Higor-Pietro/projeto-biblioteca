package org.example;

import java.util.Scanner;

public class Emprestimo {

    // Atributos

    private int id;
    private Livro livro;
    private String nomeCliente;
    private String dataEmpréstimo;
    private String dataDevolução;

    // Método Construtor


    public Emprestimo() {

    }

    // Métodos Acessores


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getDataEmpréstimo() {
        return dataEmpréstimo;
    }

    public void setDataEmpréstimo(String dataEmpréstimo) {
        this.dataEmpréstimo = dataEmpréstimo;
    }

    public String getDataDevolução() {
        return dataDevolução;
    }

    public void setDataDevolução(String dataDevolução) {
        this.dataDevolução = dataDevolução;
    }

    // Métodos Públicos

    public void realizarEmprestimo(Livro livro){
        Scanner read = new Scanner(System.in);

        if (livro.isDisponível()){                              //Verificação se o Livro está disponível
            livro.setDisponível(false);

            // Seleção do nome do cliente
            System.out.print("Selecione seu nome: ");
            String nome = read.nextLine();
            this.setNomeCliente(nome);

            // Seleção da data do empréstimo
            System.out.print("Selecione a data atual: ");
            String dataAtual = read.nextLine();
            this.setDataEmpréstimo(dataAtual);

            //Seleção da data de devolução
            System.out.print("Selecione a data de devolução: ");
            String dataDevoluçao = read.nextLine();
            this.setDataDevolução(dataDevoluçao);

            //Inclusão do livro
            this.setLivro(livro);

            // Mensagem de finalização do empréstimo
            System.out.println("EMPRÉSTIMO REALIZADO! ");
            System.out.println("-----------------------------------");

        } else{
            System.out.println("O Livro precisa estar DISPONÍVEL para realizar o empréstimo! ");
        }

    }
}
